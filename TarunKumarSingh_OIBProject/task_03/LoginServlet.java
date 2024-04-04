import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Validate username and password
        boolean isValidUser = validateUser(username, password);
        
        if(isValidUser) {
            // Redirect to exam page
            response.sendRedirect("exam.jsp");
        } else {
            // Redirect back to login page with error message
            response.sendRedirect("login.jsp?error=1");
        }
    }
    
    private boolean validateUser(String username, String password) {
        // Logic to validate user from database
        return true; // Dummy validation
    }
}
