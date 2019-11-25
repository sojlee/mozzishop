<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="author" content="Kodinger">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>My Login Page</title>
	<style>
		.google{
			width:40px;
			margin:5px;
		}
		.facebook{
			width:40px;
			margin:5px;
		}
		.kakao{
			width:40px;
			margin:5px;
		}
	</style>
	
</head>

<body>
	
							
		<a href="/oauth2/authorization/google"><img class="google" src="https://pbs.twimg.com/profile_images/770139154898382848/ndFg-IDH_400x400.jpg" alt="google_login_btn"></a>
		<a href="/oauth2/authorization/facebook"><img class="facebook" src="./resources/img/facebook-logo.png" alt="facebook_login_btn"></a>
	<a href="/oauth2/authorization/kakao"><img class="kakao" src="./resources/img/kakao_logo.png" alt="kakao_login_btn"></a>

</body>
</html>