<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<title>Reservation</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
}

.card {
    border-radius: 20px;
}

.form-control {
    border-radius: 10px;
}

.btn-custom {
    background: linear-gradient(45deg, #ff512f, #dd2476);
    color: white;
    border: none;
}

.btn-custom:hover {
    opacity: 0.9;
}

.title {
    font-weight: bold;
    color: #444;
}
</style>

<script>
function fetchTrain() {
    let trainNo = document.getElementById("trainNo").value;

    fetch("TrainServlet?trainNo=" + trainNo)
    .then(res => res.text())
    .then(data => {
        document.getElementById("trainName").value = data;
    });
}
</script>

</head>

<body class="d-flex justify-content-center align-items-center">
<div class="container mt-4">

    <div class="card shadow p-4">

        <h4 class="mb-3">Book Ticket</h4>

        <form action="ReservationServlet" method="post">

            <div class="row">
                <div class="col-md-6">
                    <input name="name" class="form-control mb-3" placeholder="Name">
                </div>

                <div class="col-md-6">
                    <input id="trainNo" name="trainNo" onkeyup="fetchTrain()" class="form-control mb-3" placeholder="Train No">
                </div>
            </div>

            <input id="trainName" name="trainName" class="form-control mb-3" readonly>

            <div class="row">
                <div class="col-md-6">
                    <input name="classType" class="form-control mb-3" placeholder="Class">
                </div>

                <div class="col-md-6">
                    <input type="date" name="date" class="form-control mb-3">
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <input name="source" class="form-control mb-3" placeholder="From">
                </div>

                <div class="col-md-6">
                    <input name="destination" class="form-control mb-3" placeholder="To">
                </div>
            </div>

            <button class="btn btn-success w-100">Book</button>

        </form>

    </div>

</div>

</body>
</html>