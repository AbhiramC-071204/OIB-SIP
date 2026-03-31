<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ATM Login</title>

<style>
body {
    margin:0;
    font-family: 'Segoe UI';
    background: linear-gradient(135deg,#0f2027,#203a43,#2c5364);
}

.container {
    width: 350px;
    margin: 120px auto;
    background: #fff;
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.3);
}

h2 {
    text-align:center;
}

input {
    width:100%;
    padding:12px;
    margin:10px 0;
    border-radius:8px;
    border:1px solid #ccc;
}

button {
    width:100%;
    padding:12px;
    background:#2c5364;
    color:white;
    border:none;
    border-radius:8px;
    cursor:pointer;
}

button:hover {
    background:#1a2f38;
}

.error {
    color:red;
    text-align:center;
}

.link {
    text-align:center;
    margin-top:10px;
}
</style>
</head>

<body>

<div class="container">

<h2>ATM Login</h2>

<%
String error = request.getParameter("error");
if(error != null){
%>
<p class="error">Invalid User ID or PIN</p>
<% } %>

<form action="login" method="post">
<input type="number" name="userId" placeholder="User ID" required>
<input type="password" name="pin" placeholder="PIN" required>
<button>Login</button>
</form>

<div class="link">
<a href="register.jsp">Create Account</a>
</div>

</div>

</body>
</html></html>