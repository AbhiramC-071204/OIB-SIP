<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.reservation.model.Reservation" %>

<!DOCTYPE html>
<html>
<head>

<title>Admin Panel</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-4">

<h3 class="mb-3">📊 Admin Dashboard</h3>

<!-- SEARCH -->
<form class="row g-2 mb-3" method="get" action="AdminServlet">

    <div class="col-md-3">
        <input name="pnr" class="form-control" placeholder="Search by PNR">
    </div>

    <div class="col-md-3">
        <input type="date" name="date" class="form-control">
    </div>

    <div class="col-md-2">
        <button class="btn btn-primary w-100">Search</button>
    </div>

</form>

<!-- TABLE -->
<table class="table table-bordered table-hover text-center">

<thead class="table-dark">
<tr>
<th>PNR</th>
<th>Name</th>
<th>Train</th>
<th>Class</th>
<th>From</th>
<th>To</th>
<th>Action</th>
</tr>
</thead>

<tbody>

<%
List<Reservation> list = (List<Reservation>) request.getAttribute("data");

if(list != null && !list.isEmpty()) {
    for(Reservation r : list) {
%>

<tr>
<td><%= r.getPnr() %></td>
<td><%= r.getName() %></td>
<td><%= r.getTrainName() %></td>
<td><%= r.getClassType() %></td>
<td><%= r.getSource() %></td>
<td><%= r.getDestination() %></td>

<td>
  <a href="EditServlet?pnr=<%= r.getPnr() %>" 
       class="btn btn-warning btn-sm">Edit</a>

<a href="DeleteServlet?pnr=<%= r.getPnr() %>"
   class="btn btn-danger btn-sm"
   onclick="return confirm('Delete booking?')">
   Delete
</a>
</td>
</tr>

<%
    }
} else {
%>

<tr>
<td colspan="7">No bookings found</td>
</tr>

<%
}
%>

</tbody>

</table>

</div>

<!-- CHART -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<canvas id="myChart" height="100"></canvas>

<script>
const ctx = document.getElementById('myChart');

new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Bookings'],
        datasets: [{
            label: 'Total',
            data: [<%= (list != null) ? list.size() : 0 %>],
        }]
    }
});
</script>

</body>
</html>