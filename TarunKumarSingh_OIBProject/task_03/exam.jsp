<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Examination</title>
</head>
<body>
    <!-- Display MCQs -->
    <form action="SubmitServlet" method="post">
        <h2>Question 1</h2>
        <p>What is the capital of France?</p>
        <input type="radio" name="q1" value="Paris"> Paris<br>
        <input type="radio" name="q1" value="Berlin"> Berlin<br>
        <input type="radio" name="q1" value="London"> London<br>
        <input type="radio" name="q1" value="Rome"> Rome<br><br>
        
        <!-- Timer -->
        <h3>Time Left: <span id="timer">10:00</span></h3>
        
        <!-- Submit Button -->
        <input type="submit" value="Submit">
    </form>
    
    <!-- Timer Script -->
    <script>
        var timer = 600; // 10 minutes in seconds
        var interval = setInterval(function() {
            var minutes = Math.floor(timer / 60);
            var seconds = timer % 60;
            document.getElementById('timer').innerHTML = (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
            timer--;
            if (timer < 0) {
                clearInterval(interval);
                document.forms[0].submit(); // Auto submit when timer ends
            }
        }, 1000);
    </script>
</body>
</html>
