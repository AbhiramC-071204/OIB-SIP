<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
}

.card {
    border-radius: 15px;
    backdrop-filter: blur(10px);
}

a { text-decoration: none; }
</style>

</head>

<body class="d-flex justify-content-center align-items-center">

<div class="card p-4 shadow-lg" style="width:350px;">

    <h3 class="text-center mb-3">Login</h3>

    <% if(request.getParameter("error") != null){ %>
        <div class="alert alert-danger">Invalid credentials</div>
    <% } %>

    <% if(request.getParameter("register") != null){ %>
        <div class="alert alert-success">Registered successfully</div>
    <% } %>

<form action="LoginServlet" method="post">
        <input type="text" name="username" class="form-control mb-3" placeholder="Username" required>
        <input type="password" name="password" class="form-control mb-3" placeholder="Password" required>

        <button class="btn btn-primary w-100">Login</button>
    </form>

    <p class="text-center mt-3">
        Don't have account? <a href="register.jsp">Register</a>
    </p>

</div>

</body>
</html>