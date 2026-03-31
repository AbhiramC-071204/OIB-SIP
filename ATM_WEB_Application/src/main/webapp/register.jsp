<!DOCTYPE html>
<html>
<head>
<title>Register</title>

<style>
body {
    margin:0;
    font-family: 'Segoe UI';
    background: linear-gradient(135deg,#1d4350,#a43931);
}

.container {
    width: 350px;
    margin: 100px auto;
    background: #fff;
    padding: 30px;
    border-radius: 15px;
}

h2 {
    text-align:center;
}

input {
    width:100%;
    padding:12px;
    margin:10px 0;
    border-radius:8px;
}

button {
    width:100%;
    padding:12px;
    background:#a43931;
    color:white;
    border:none;
    border-radius:8px;
}

.error { color:red; text-align:center; }
.success { color:green; text-align:center; }
</style>

<script>
function validate(){
    let pin = document.forms["regForm"]["pin"].value;

    if(pin.length < 4){
        alert("PIN must be at least 4 digits");
        return false;
    }
    return true;
}
</script>

</head>

<body>

<div class="container">

<h2>Create Account</h2>

<%
String msg = request.getParameter("msg");
String error = request.getParameter("error");

if(msg != null){ %>
<p class="success"><%= msg %></p>
<% } %>

<% if(error != null){ %>
<p class="error"><%= error %></p>
<% } %>

<form name="regForm" action="register" method="post" onsubmit="return validate()">
<input type="number" name="userId" placeholder="User ID" required>
<input type="password" name="pin" placeholder="PIN" required>
<button>Register</button>
</form>

</div>

</body>
</html>