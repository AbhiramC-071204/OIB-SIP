<%@ page import="com.atm.model.User" %>

<%
User user = (User) session.getAttribute("user");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>ATM Dashboard</title>

<style>
body {
    margin:0;
    font-family: 'Segoe UI';
    background: linear-gradient(135deg,#141e30,#243b55);
    color:white;
}

/* Navbar */
.navbar {
    padding:15px;
    background: rgba(0,0,0,0.3);
    display:flex;
    justify-content:space-between;
}

.logout {
    color:#ff7675;
    text-decoration:none;
}

/* Container */
.container {
    padding:30px;
}

/* Cards */
.cards {
    display:grid;
    grid-template-columns: repeat(auto-fit, minmax(200px,1fr));
    gap:20px;
}

.card {
    padding:20px;
    border-radius:15px;
    color:white;
    cursor:pointer;
    transition:0.3s;
    text-align:center;
}

.card:hover {
    transform: scale(1.05);
}

/* Gradient Colors */
.balance { background: linear-gradient(45deg,#00c6ff,#0072ff); }
.deposit { background: linear-gradient(45deg,#00b09b,#96c93d); }
.withdraw { background: linear-gradient(45deg,#ff416c,#ff4b2b); }
.transfer { background: linear-gradient(45deg,#8e2de2,#4a00e0); }
.history { background: linear-gradient(45deg,#f7971e,#ffd200); color:black; }

h2 { margin:0; }

/* Toast */
.toast {
    position:fixed;
    bottom:20px;
    right:20px;
    background:#00b894;
    padding:15px;
    border-radius:8px;
    display:none;
}
</style>

<script>
function showToast(msg){
    let t = document.getElementById("toast");
    t.innerText = msg;
    t.style.display="block";

    setTimeout(()=>{ t.style.display="none"; },3000);
}
</script>

</head>

<body>

<div class="navbar">
    <h2>ATM Dashboard</h2>
   <a href="admin" style="color:white;margin-right:15px;">Admin Panel</a>
<a href="analytics" style="color:white;margin-right:15px;">Analytics</a>

    <a href="logout" class="logout">Logout</a>
</div>

<div class="container">

<h3>Welcome, User <%= user.getUserId() %></h3>

<div class="cards">

    <div class="card balance">
        <h3>Balance</h3>
        <h2><%= user.getBalance() %></h2>
    </div>

    <div class="card deposit" onclick="location.href='deposit.jsp'">
        <h3>Deposit</h3>
    </div>

    <div class="card withdraw" onclick="location.href='withdraw.jsp'">
        <h3>Withdraw</h3>
    </div>

    <div class="card transfer" onclick="location.href='transfer.jsp'">
        <h3>Transfer</h3>
    </div>

    <div class="card history" onclick="location.href='history'">
        <h3>Transactions</h3>
    </div>

</div>

</div>

<div id="toast" class="toast"></div>

<%
String msg = request.getParameter("msg");
if(msg != null){
%>
<script>
showToast("<%= msg %>");
</script>
<% } %>

</body>
</html>