<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Cancel Ticket</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #ff758c, #ff7eb3);
}
.card {
    border-radius: 20px;
}
</style>

</head>

<body class="d-flex justify-content-center align-items-center" style="height:100vh;">

<div class="card shadow p-4" style="width:500px;">

    <h3 class="text-center mb-3">❌ Cancel Ticket</h3>

    <!-- INPUT -->
    <input type="number" id="pnr" class="form-control mb-3"
           placeholder="Enter PNR">

    <button onclick="searchTicket()" class="btn btn-primary w-100">
        Search Ticket
    </button>

    <!-- RESULT -->
    <div id="result" class="mt-4"></div>

</div>

<script>

function searchTicket() {

    let pnr = document.getElementById("pnr").value;

    fetch("CancelServlet?pnr=" + pnr)
    .then(res => res.json())
    .then(data => {

        let result = document.getElementById("result");

        if (!data.name) {
            result.innerHTML = "<div class='alert alert-danger'>No ticket found</div>";
            return;
        }

        result.innerHTML = `
            <div class="card p-3 bg-light">
                <h5>${data.name}</h5>
                <p>${data.train}</p>
                <p>${data.classType}</p>
                <p>${data.from} → ${data.to}</p>

                <button onclick="cancelTicket(${pnr})"
                        class="btn btn-danger w-100">
                        Cancel Ticket
                </button>
            </div>
        `;
    });
}

function cancelTicket(pnr) {

    if (!confirm("Confirm cancel?")) return;

    fetch("CancelServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "pnr=" + pnr
    })
    .then(res => res.text())
    .then(msg => {

        document.getElementById("result").innerHTML =
            "<div class='alert alert-success'>Ticket Cancelled 🎉</div>";
    });
}

</script>

</body>
</html>