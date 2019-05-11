<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google SignIn</title>
</head>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Google Sign In</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="315917675517-l8t13qqieb8kpt5k62ieho8nks6klnsm.apps.googleusercontent.com">
<style>
.g-signin2 {
	margin-left: 500px;
	margin-top: 200px;
}
</style>
<script>
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		var emailId=profile.getEmail();
		 window.location.replace("AuthenticationServlet?email="+emailId);
	
	}
</script>
</head>
<body>
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
</body>
</html>