import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UserModule extends HttpServlet {

    // Simulate a database of books (replace with actual database interaction)
    private static Map<String, Book> books = new HashMap<>();

    public void init() {
        // Add some sample books during initialization (replace with database population)
        books.put("ISBN123", new Book("Book Title 1", "Author 1"));
        books.put("ISBN456", new Book("Book Title 2", "Author 2"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");  // Get the action parameter

        if (action != null) {
            if (action.equals("browse")) {
                // Handle browsing functionality
                doGet(request, response); // Leverage doGet for browsing (assuming browsing doesn't modify data)
            } else if (action.equals("search")) {
                // Handle search functionality
                String searchTerm = request.getParameter("searchTerm");
                List<Book> searchResult = searchBooks(searchTerm);
                // Prepare response for search results (e.g., send to JSP for display)
            } else if (action.equals("issue")) {
                // Handle book issuing functionality
                String isbn = request.getParameter("isbn");
                String userId = request.getSession().getAttribute("userId").toString(); // Assuming user session management
                if (issueBook(isbn, userId)) {
                    // Issue successful, send confirmation response
                } else {
                    // Issue failed, send error response
                }
            } else if (action.equals("return")) {
                // Handle book returning functionality
                String isbn = request.getParameter("isbn");
                String userId = request.getSession().getAttribute("userId").toString(); // Assuming user session management
                if (returnBook(isbn, userId)) {
                    // Return successful, send confirmation response
                } else {
                    // Return failed, send error response
                }
            } else {
                // Handle invalid action
                response.getWriter().println("Invalid action!");
            }
        } else {
            // Handle missing action parameter
            response.getWriter().println("Missing action parameter!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Handle browsing functionality (assuming browsing displays all books)
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Available Books</h1>");
        out.println("<ul>");
        for (Book book : books.values()) {
            out.println("<li>" + book.getTitle() + " by " + book.getAuthor() + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }

    // Simulate book search (replace with actual search logic)
    private List<Book> searchBooks(String searchTerm) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // Simulate book issuing (replace with actual data modification logic)
    private boolean issueBook(String isbn, String userId) {
        // Check book availability, update user record, etc.
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            // Issue book logic
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    // Simulate book returning (replace with actual data modification logic)
    private boolean returnBook(String isbn, String userId) {
        // Check user record, update book availability, etc.
        Book book = books.get(isbn);
        if (book != null) {
            // Return book logic
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    // Simple book class
    private static class Book {
        private String title;
        private String author;
        private boolean available;

