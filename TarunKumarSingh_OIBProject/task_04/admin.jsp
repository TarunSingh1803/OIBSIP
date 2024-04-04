<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
</head>
<body>
    <h1>Admin Panel</h1>

    <ul>
        <li><a href="admin.jsp?action=addBook">Add Book</a></li>
        <li><a href="admin.jsp?action=deleteBook">Delete Book</a></li>
        <li><a href="admin.jsp?action=modifyBook">Modify Book</a></li>
        <li><a href="admin.jsp?action=addMember">Add Member</a></li>
        <li><a href="admin.jsp?action=deleteMember">Delete Member</a></li>
    </ul>

    <%
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("addBook")) {
                // Form to add a new book
                out.println("<form action='admin.jsp' method='post'>");
                out.println("Title: <input type='text' name='bookTitle' required>");
                out.println("Author: <input type='text' name='bookAuthor' required>");
                out.println("<input type='submit' value='Add Book'>");
                out.println("</form>");
            } else if (action.equals("deleteBook")) {
                // Form to select a book for deletion
                out.println("Select book to delete:");
                out.println("<form action='admin.jsp' method='post'>");
                out.println("<select name='isbn'>");
                // Replace with logic to populate book options from database
                for (Book book : books.values()) {
                    out.println("<option value='" + book.getIsbn() + "'>" + book.getTitle() + " by " + book.getAuthor() + "</option>");
                }
                out.println("</select>");
                out.println("<input type='submit' value='Delete Book'>");
                out.println("</form>");
            } else if (action.equals("modifyBook")) {
                // Form to select a book for modification (similar to deleteBook)
                out.println("Select book to modify:");
                out.println("<form action='admin.jsp' method='post'>");
                out.println("<select name='isbn'>");
                // Replace with logic to populate book options from database
                for (Book book : books.values()) {
                    out.println("<option value='" + book.getIsbn() + "'>" + book.getTitle() + " by " + book.getAuthor() + "</option>");
                }
                out.println("</select>");
                out.println("<input type='submit' value='Modify Book'>");
                out.println("</form>");
            } else if (action.equals("addMember")) {
                // Form to add a new member
                // ... (similar to addBook)
            } else if (action.equals("deleteMember")) {
                // Form to select a member for deletion
                // ... (similar to deleteBook)
            } else {
                out.println("Invalid action!");
            }
        }
    %>

</body>
</html>
