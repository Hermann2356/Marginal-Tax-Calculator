<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="format.css"></link>
</head>
<body>

<h1>Login Verification</h1>

<form method="post" action="login-verification">
  <label for="userId">User Id:</label><br>
  <input type="text" id="userId" name="userId" /><br>
  <label for="password">Password:</label><br>
  <input type="text" id="password" name="password" ><br><br>
  <input type="submit" value="Login">
</form>
</body>
</html>