<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.reservation.model.Reservation" %>

<%
Reservation r = (Reservation) request.getAttribute("r");
%>

<!DOCTYPE html>
<html>
<head>

<title>Edit Booking</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="d-flex justify-content-center align-items-center" style="height:100vh; background:#f4f4f4;">

<div class="card p-4 shadow" style="width:400px;">

<h3>Edit Booking</h3>

<form action="UpdateServlet" method="post">

    <input type="hidden" name="pnr" value="<%= r.getPnr() %>">

    <input name="name" value="<%= r.getName() %>" class="form-control mb-2">

    <input name="trainName" value="<%= r.getTrainName() %>" class="form-control mb-2">

    <input name="classType" value="<%= r.getClassType() %>" class="form-control mb-2">

    <input name="source" value="<%= r.getSource() %>" class="form-control mb-2">

    <input name="destination" value="<%= r.getDestination() %>" class="form-control mb-2">

    <button class="btn btn-success w-100">Update</button>

</form>

</div>

</body>
</html>