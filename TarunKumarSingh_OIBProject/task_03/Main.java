import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process submitted answers
        String q1Answer = request.getParameter("q1");
        
        // Calculate score, save answers, etc.
        
        // Redirect to result page
        response.sendRedirect("result.jsp");
    }
}
