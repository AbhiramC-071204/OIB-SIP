<%@ page import="java.util.*,com.atm.model.Transaction" %>

<!DOCTYPE html>
<html>
<head>
<title>Transactions</title>

<style>
body { font-family:Segoe UI; background:#141e30; color:white; text-align:center; }

input {
    padding:10px;
    margin:15px;
    width:300px;
}

table {
    width:80%;
    margin:auto;
    border-collapse: collapse;
    background:white;
    color:black;
}

th, td {
    padding:12px;
}

th {
    background:#2c5364;
    color:white;
}

button {
    padding:10px;
    background:#00c6ff;
    border:none;
    color:white;
}
</style>

<script>
function filterTable() {
    let input = document.getElementById("search").value.toLowerCase();
    let rows = document.querySelectorAll("table tr");

    rows.forEach((row, index) => {
        if(index===0) return;
        row.style.display = row.innerText.toLowerCase().includes(input) ? "" : "none";
    });
}
</script>

</head>

<body>

<h2>Transaction History</h2>

<input type="text" id="search" placeholder="Search..." onkeyup="filterTable()">

<button onclick="window.print()">Download PDF</button>

<table>
<tr>
<th>Type</th>
<th>Amount</th>
<th>Date</th>
</tr>

<%
List<Transaction> list = (List<Transaction>) request.getAttribute("transactions");

if(list != null){
    for(Transaction t : list){
%>

<tr>
<td><%= t.getType() %></td>
<td> <%= t.getAmount() %></td>
<td><%= t.getDate() %></td>
</tr>

<%
    }
}
%>

</table>

<br><br>
<a href="dashboard.jsp" style="color:white"> Back</a>

</body>
</html>