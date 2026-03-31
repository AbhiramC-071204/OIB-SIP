<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Transfer</title>

<style>
body { font-family: Arial; background:#34495e; color:white; }
.container {
    width: 400px; margin: 80px auto;
    background:white; color:black;
    padding:30px; border-radius:10px;
}
input, button {
    width:100%; padding:10px; margin:10px 0;
}
button {
    background:#2980b9; color:white; border:none;
}
</style>

</head>

<body>

<div class="container">
<h2>Transfer Money</h2>

<form action="transfer" method="post">
    <input type="number" name="toUser" placeholder="Receiver User ID" required>
    <input type="number" name="amount" placeholder="Amount" required>
    <button type="submit">Transfer</button>
</form>

<a href="dashboard.jsp"> Back</a>

</div>

</body>
</html>