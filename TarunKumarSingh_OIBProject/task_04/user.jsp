<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Panel</title>
</head>
<body>
    <h1>User Panel</h1>

    <h2>Browse Books</h2>
    <ul>
        <li><a href="UserModule?action=browse">View All Books</a></li>
    </ul>

    <h2>Search Books</h2>
    <form action="UserModule" method="post">
        <input type="hidden" name="action" value="search">
        <label for="searchTerm">Search Term:</label>
        <input type="text" name="searchTerm" id="searchTerm" required>
        <button type="submit">Search</button>
    </form>

    <h2>Issue Book</h2>
    <form action="UserModule" method="post">
        <input type="hidden" name="action" value="issue">
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" id="isbn" required>
        <button type="submit">Issue Book</button>
    </form>

    <h2>Return Book</h2>
    <form action="UserModule" method="post">
        <input type="hidden" name="action" value="return">
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" id="isbn" required>
        <button type="submit">Return Book</button>
    </form>

</body>
</html>
