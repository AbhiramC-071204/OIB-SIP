<%@ page import="java.util.Random" %>

<%
    if (session.getAttribute("number") == null) {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;

        session.setAttribute("number", number);
        session.setAttribute("attempts", 5);
    }
%>

<html>
<head>
<title>Play Game</title>
<style>
body {
    margin: 0;
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    color: white;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    background: rgba(255, 255, 255, 0.1);
    padding: 40px;
    border-radius: 15px;
    backdrop-filter: blur(10px);
    text-align: center;
    width: 350px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.3);
}

h1, h2 {
    margin-bottom: 20px;
}

input[type="number"] {
    width: 80%;
    padding: 10px;
    border-radius: 8px;
    border: none;
    margin-bottom: 15px;
    font-size: 16px;
}

button, input[type="submit"] {
    background: #ff7b00;
    color: white;
    border: none;
    padding: 12px 20px;
    border-radius: 8px;
    cursor: pointer;
    font-size: 16px;
    transition: 0.3s;
}

button:hover, input[type="submit"]:hover {
    background: #ff9500;
    transform: scale(1.05);
}

.message {
    margin: 10px 0;
    font-weight: bold;
}

.attempts {
    margin-bottom: 15px;
    font-size: 14px;
    opacity: 0.8;
}
</style>
</head>

<body>

<div class="container">
    <h2>🎮 Guess Number</h2>

    <div class="attempts">
        Attempts left: <%= session.getAttribute("attempts") %>
    </div>

    <div class="message">
        <%= session.getAttribute("message") != null ? session.getAttribute("message") : "" %>
    </div>

    <form action="GameServlet" method="post">
        <input type="number" name="guess" placeholder="Enter your guess" required>
        <br>
        <button type="submit">Submit Guess</button>
    </form>
</div>

</body>
</html>