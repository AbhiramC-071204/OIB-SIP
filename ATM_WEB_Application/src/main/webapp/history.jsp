<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Transactions</title>

<style>
body { font-family: Arial; background:#222; color:white; }
table {
    width:80%; margin:auto;
    border-collapse:collapse;
    background:white; color:black;
}
th, td {
    padding:10px; border:1px solid #ccc;
}
th { background:#333; color:white; }
</style>

</head>

<body>

<h2 style="text-align:center;">Transaction History</h2>

<table>
<tr>
    <th>Type</th>
    <th>Amount</th>
    <th>Date</th>
</tr>

<%
List<String> list = (List<String>) request.getAttribute("transactions");

if(list != null){
    for(String t : list){
%>
<tr>
    <td colspan="3"><%= t %></td>
</tr>
<%
    }
}
%>

</table>

<div style="text-align:center; margin-top:20px;">
<a href="dashboard.jsp">⬅ Back</a>
</div>

</body>
</html>