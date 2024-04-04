
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ReservationSystem {
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/reservation_system";
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");

            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            
            stmt = conn.createStatement();

                        String createTableSql = "CREATE TABLE reservations (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100)," +
                    "train_number VARCHAR(20)," +
                    "class_type VARCHAR(20)," +
                    "date_of_journey DATE," +
                    "source VARCHAR(50)," +
                    "destination VARCHAR(50)" +
                    ")";
            stmt.executeUpdate(createTableSql);

                        LoginForm loginForm = new LoginForm();
            loginForm.display();

            
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

class LoginForm {
    public void display() {
        public class LoginForm extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));

        usernameLabel = new JLabel("Username:");
        add(usernameLabel);

        usernameField = new JTextField();
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    // Redirect to the main system interface or perform other actions
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                   
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });
        add(loginButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
    }
}

class ReservationForm {
    public void display(){
public class ReservationFormUI extends JFrame {
    private JTextField nameField;
    private JTextField dateField;
    private JTextField timeField;
    private JButton submitButton;

    public ReservationFormUI() {
        setTitle("Reservation Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        JLabel timeLabel = new JLabel("Time:");
        timeField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitReservation());

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    private void submitReservation() {
        String name = nameField.getText();
        String date = dateField.getText();
        String time = timeField.getText();
        JOptionPane.showMessageDialog(this, "Reservation submitted:\nName: " + name + "\nDate: " + date + "\nTime: " + time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReservationFormUI::new);
    }
}
   
    }
}

class CancellationForm {
    public void display() {
        public class CancellationForm extends JFrame implements ActionListener {
    private JTextField reservationIDField;
    private JButton cancelButton;

    public CancellationForm() {
        setTitle("Cancellation Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel reservationIDLabel = new JLabel("Reservation ID:");
        reservationIDField = new JTextField();
        cancelButton = new JButton("Cancel Reservation");

        cancelButton.addActionListener(this);

        panel.add(reservationIDLabel);
        panel.add(reservationIDField);
        panel.add(new JLabel()); // Placeholder
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            // Retrieve the reservation ID from the text field
            String reservationID = reservationIDField.getText();

            // Perform cancellation logic here (e.g., call a method to cancel the reservation)

            // For demonstration purposes, let's just show a confirmation message
            JOptionPane.showMessageDialog(this, "Reservation with ID " + reservationID + " has been cancelled.");

            // Clear the text field after cancellation
            reservationIDField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CancellationForm();
            }
        });
    }
}
    }
}

