<!DOCTYPE html>
<html>
<head>
<title>Deposit</title>

<style>
body {
    font-family:'Segoe UI';
    background: linear-gradient(135deg,#00b09b,#96c93d);
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.box {
    background:white;
    padding:30px;
    border-radius:15px;
    width:300px;
}

input, button {
    width:100%;
    padding:12px;
    margin:10px 0;
}

button {
    background:#00b09b;
    color:white;
    border:none;
}
</style>
</head>

<body>

<div class="box">
<h2>Deposit Money</h2>

<form action="deposit" method="post">
<input type="number" name="amount" placeholder="Enter amount" required>
<button>Deposit</button>
</form>

</div>

</body>
</html>