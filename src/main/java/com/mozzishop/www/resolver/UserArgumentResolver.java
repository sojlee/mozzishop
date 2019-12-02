package com.mozzishop.www.resolver;

import static com.mozzishop.www.user.jpa.SocialType.FACEBOOK;
import static com.mozzishop.www.user.jpa.SocialType.GOOGLE;
import static com.mozzishop.www.user.jpa.SocialType.KAKAO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.mozzishop.www.user.jpa.Grade;
import com.mozzishop.www.user.jpa.SocialType;
import com.mozzishop.www.user.jpa.User;
import com.mozzishop.www.user.jpa.UserRepository;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private UserRepository userRepository;

    public UserArgumentResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(SocialUser.class) != null && parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        User user = (User) session.getAttribute("user");
        return getUser(user, session);
    }

    private User getUser(User user, HttpSession session) {
    	// 새로 가입하는 User
        if(user == null) {
            try {
                OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
                Map<String, Object> map = authentication.getPrincipal().getAttributes();
                // 로그인 시도해서 입력받은 사용자 정보 converUser에 담기. 
                User convertUser = convertUser(authentication.getAuthorizedClientRegistrationId(), map);
               
                // SocialType이 KAKAO면 
                if(convertUser.getSocialType()==KAKAO){
                	// user로부터 email을 받지 못하거나, user에 등록된 이메일이 없으면 principal로 탐색.
                	if(convertUser.getEmail().equals("null")) 
                		user = userRepository.findByPrincipal(convertUser.getPrincipal());
                	// user로부터 email을 받으면, 다른 소셜 로그인으로 인해 DB에 중복된 이메일이 있는지 탐색.
                	else 
                		user = userRepository.findByEmail(convertUser.getEmail());
                }else {
                	// SocialType이 Google, Facebook일 때.
                	user = userRepository.findByEmail(convertUser.getEmail());
                }
                System.out.println("convertUser : "+convertUser.toString());
                
                // 신규 회원인 경우 DB에 저장
                if (user == null) { user = userRepository.save(convertUser); }
        
                setRoleIfNotSame(user, authentication, map);
                session.setAttribute("user", user);
            } catch (ClassCastException e) {
                return user;
            }
        }
      
        return user;
    }
    
    // 소셜 타입 별로 user정보와 매핑.  
    private User convertUser(String authority, Map<String, Object> map) {
    	
        if(FACEBOOK.isSocialTypeEquals(authority)) return getModernUser(FACEBOOK, map);
        else if(GOOGLE.isSocialTypeEquals(authority)) return getModernUser(GOOGLE, map);
        else if(KAKAO.isSocialTypeEquals(authority)) return getKaKaoUser(map);
        
        return null;
    }

  
    // SocialType을 파라미터로 map의 값으로부터 매핑. 
	private User getModernUser(SocialType socialType, Map<String, Object> map) {
        return User.builder()
                .name(String.valueOf(map.get("name")))
                .email(String.valueOf(map.get("email")))
                .principal(String.valueOf(map.get("id")))
                .socialType(socialType)
                .grade(Grade.USER)
                .createdDate(LocalDateTime.now())
                .build();
    }
	
    private User getKaKaoUser(Map<String, Object> map) {
        Map<String, String> propertyMap = (HashMap<String, String>) map.get("properties");
        return User.builder()
                .name(propertyMap.get("nickname"))
                .email(String.valueOf(map.get("kaccount_email")))
                .principal(String.valueOf(map.get("id")))
                .socialType(KAKAO)
                .grade(Grade.USER)
                .createdDate(LocalDateTime.now())
                .build();
    }

    // 사용자가 권한을 가지고 있는지 체크, 없다면 역할에 따른 권한을 부여한다. 
    private void setRoleIfNotSame(User user, OAuth2AuthenticationToken authentication, Map<String, Object> map) {
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority(user.getGrade().getGradeType()))) {
        	SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(map, "N/A", 
        			AuthorityUtils.createAuthorityList(user.getGrade().getGradeType())));
            System.out.println("권한이 없습니다!!!!!!!!!!!");
        }
    }
}