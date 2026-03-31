<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<title>Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #43cea2, #185a9d);
    height: 100vh;
}
.card {
    border-radius: 15px;
}
</style>

</head>

<body class="d-flex justify-content-center align-items-center">

<div class="card p-4 shadow-lg" style="width:350px;">

    <h3 class="text-center mb-3">Create Account</h3>

    <% if(request.getParameter("error") != null){ %>
        <div class="alert alert-danger">Registration Failed</div>
    <% } %>

    <form action="RegisterServlet" method="post">

        <input type="text" name="username" class="form-control mb-3" placeholder="Username" required>

        <input type="password" name="password" class="form-control mb-3" placeholder="Password" required>

        <button class="btn btn-success w-100">Register</button>

    </form>

    <p class="text-center mt-3">
        Already have account? <a href="login.jsp">Login</a>
    </p>

</div>

</body>
</html>