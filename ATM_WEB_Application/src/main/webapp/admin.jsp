<%@ page import="java.util.*,com.atm.model.User" %>

<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>

<style>
body {
    font-family:Segoe UI;
    background:#0f2027;
    color:white;
    text-align:center;
}

table {
    width:80%;
    margin:auto;
    background:white;
    color:black;
    border-collapse: collapse;
}

th, td {
    padding:12px;
}

th {
    background:#2c5364;
    color:white;
}

button {
    padding:8px;
    background:red;
    color:white;
    border:none;
}
</style>
</head>

<body>

<h2>Admin Panel - Users</h2>

<table>
<tr>
<th>User ID</th>
<th>Balance</th>
<th>Action</th>
</tr>

<%
List<User> list = (List<User>) request.getAttribute("users");

for(User u : list){
%>

<tr>
<td><%= u.getUserId() %></td>
<td><%= u.getBalance() %></td>
<td>
    <a href="deleteUser?id=<%= u.getUserId() %>">
        <button>Delete</button>
    </a>
</td>
</tr>

<% } %>

</table>

<br>
<a href="dashboard.jsp" style="color:white">Back</a>

</body>
</html>