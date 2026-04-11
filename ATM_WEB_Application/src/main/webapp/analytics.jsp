<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Analytics</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
body {
    margin:0;
    font-family: 'Segoe UI';
    background: linear-gradient(135deg,#0f2027,#203a43,#2c5364);
    color:white;
    text-align:center;
}

.container {
    padding:30px;
}

.cards {
    display:flex;
    justify-content:center;
    gap:20px;
    flex-wrap:wrap;
}

.card {
    padding:20px;
    border-radius:15px;
    width:200px;
    text-align:center;
}

.deposit {
    background: linear-gradient(45deg,#00c6ff,#0072ff);
}

.withdraw {
    background: linear-gradient(45deg,#ff416c,#ff4b2b);
}

canvas {
    margin-top:40px;
}

.back {
    display:inline-block;
    margin-top:20px;
    padding:10px 20px;
    background:#00c6ff;
    border-radius:8px;
    color:white;
    text-decoration:none;
}
</style>

</head>

<body>

<div class="container">

<h1>📊 Financial Analytics</h1>

<div class="cards">

<div class="card deposit">
<h3>Total Deposit</h3>
<h2>₹ ${deposit}</h2>
</div>

<div class="card withdraw">
<h3>Total Withdraw</h3>
<h2>₹ ${withdraw}</h2>
</div>

</div>


<a href="dashboard.jsp" class="back">⬅ Back</a>

</div>

<script>
let deposit = ${deposit};
let withdraw = ${withdraw};

new Chart(document.getElementById("chart"), {
    type: 'doughnut',
    data: {
        labels: ["Deposit", "Withdraw"],
        datasets: [{
            data: [deposit, withdraw],
            backgroundColor: ["#00f2fe","#ff416c"]
        }]
    }
});
</script>

</body>
</html>