<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Withdraw</title>

<style>
body { font-family: Arial; background:#1f2c3e; color:white; }
.container {
    width: 400px; margin: 80px auto;
    background:white; color:black;
    padding:30px; border-radius:10px;
}
input, button {
    width:100%; padding:10px; margin:10px 0;
}
button {
    background:#e74c3c; color:white; border:none;
}
</style>

</head>

<body>

<div class="container">
<h2>Withdraw Money</h2>

<form action="withdraw" method="post">
    <input type="number" name="amount" placeholder="Enter Amount" required>
    <button type="submit">Withdraw</button>
</form>

<a href="dashboard.jsp"> Back</a>

</div>

</body>
</html>