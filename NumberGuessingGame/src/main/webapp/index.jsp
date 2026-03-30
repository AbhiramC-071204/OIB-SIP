<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<title>Number Guess Game</title>
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
    <h1>🎯 Guess The Number</h1>
    <p>Try to guess the number between 1 and 100</p>

    <form action="game.jsp">
        <input type="submit" value="Start Game 🚀">
    </form>
</div>

</body>
</html>
