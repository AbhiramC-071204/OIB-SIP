<%@ page contentType="text/html;charset=UTF-8" %>
<%
String user = (String) session.getAttribute("user");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>

<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    margin:0;
    font-family: Arial;
}

/* Sidebar */
.sidebar {
    height: 100vh;
    background: #1e1e2f;
    color: white;
    padding: 20px;
}

.sidebar a {
    display: block;
    color: #ccc;
    padding: 10px;
    text-decoration: none;
    border-radius: 8px;
}

.sidebar a:hover {
    background: #343a40;
    color: white;
}

/* Navbar */
.navbar {
    background: #6a11cb;
    color: white;
}

/* Cards */
.card-box {
    border-radius: 15px;
    padding: 20px;
    color: white;
}

.bg1 { background: linear-gradient(45deg, #ff512f, #dd2476); }
.bg2 { background: linear-gradient(45deg, #11998e, #38ef7d); }
.bg3 { background: linear-gradient(45deg, #396afc, #2948ff); }

</style>

</head>

<body>

<div class="container-fluid">
<div class="row">

    <!-- Sidebar -->
    <div class="col-md-2 sidebar">
        <h4>🚆 Panel</h4>

        <a href="home.jsp">Dashboard</a>
        <a href="reservation.jsp">Book Ticket</a>
        <a href="cancel.jsp">Cancel Ticket</a>
        <a href="AdminServlet">Admin</a>
        <a href="LogoutServlet">Logout</a>
    </div>

    <!-- Main Content -->
    <div class="col-md-10">

        <!-- Navbar -->
        <nav class="navbar p-3">
            <span>Welcome, <%= user %></span>
        </nav>

        <!-- Dashboard Cards -->
        <div class="container mt-4">

            <div class="row g-4">

                <div class="col-md-4">
                    <div class="card-box bg1">
                        <h5>Total Bookings</h5>
                        <h2>120</h2>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card-box bg2">
                        <h5>Active Users</h5>
                        <h2>45</h2>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card-box bg3">
                        <h5>Cancelled</h5>
                        <h2>10</h2>
                    </div>
                </div>

            </div>

        </div>

    </div>

</div>
</div>

</body>
</html>