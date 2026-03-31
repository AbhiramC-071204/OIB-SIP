<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<title>Booking Success</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #11998e, #38ef7d);
    height: 100vh;
}
.card {
    border-radius: 20px;
}
</style>

</head>

<body class="d-flex justify-content-center align-items-center">

<div class="card shadow-lg p-4 text-center" style="width:400px;">

    <h2 class="text-success mb-3">✅ Booking Confirmed</h2>

    <%
        String pnr = request.getParameter("pnr");
    %>

    <h4>Your PNR: <%= pnr %></h4>

    <p class="mt-3">Your ticket has been successfully booked 🎉</p>

    <a href="home.jsp" class="btn btn-primary mt-3">Go to Dashboard</a>

</div>

</body>
</html>