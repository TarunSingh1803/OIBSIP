import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the ATM");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        // Authenticate user
        User user = authenticateUser(userId, pin);
        
        if (user != null) {
            System.out.println("Welcome " + user.getName() + "!");
            System.out.println("Select an option:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Display transactions history
                    user.showTransactionHistory();
                    break;
                case 2:
                    // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 4:
                    // Transfer money
                    System.out.print("Enter recipient's user ID: ");
                    String recipientUserId = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    User recipient = findUser(recipientUserId);
                    if (recipient != null) {
                        user.transfer(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient not found.");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Authentication failed. Please check your user ID and PIN.");
        }
        
        scanner.close();
    }
    
    private static User authenticateUser(String userId, String pin) {
        // Logic to authenticate user
        // Dummy implementation
        if (userId.equals("123") && pin.equals("1234")) {
            return new User("John", "123");
        } else {
            return null;
        }
    }
    
    private static User findUser(String userId) {
        // Logic to find user by ID
        // Dummy implementation
        if (userId.equals("456")) {
            return new User("Alice", "456");
        } else {
            return null;
        }
    }
}

class User {
    private String name;
    private String userId;
    private double balance;
    private TransactionHistory transactionHistory;
    
    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.balance = 0.0;
        this.transactionHistory = new TransactionHistory();
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransaction(new Deposit(amount));
        System.out.println("Deposit successful. New balance: " + balance);
    }
    
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.addTransaction(new Withdraw(amount));
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    
    public void transfer(User recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.addTransaction(new Transfer(recipient, amount));
            System.out.println("Transfer successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        transactionHistory.showHistory();
    }
}

class Transaction {
    private double amount;
    private String type;
    
    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getType() {
        return type;
    }
}

class Deposit extends Transaction {
    public Deposit(double amount) {
        super(amount, "Deposit");
    }
}

class Withdraw extends Transaction {
    public Withdraw(double amount) {
        super(amount, "Withdraw");
    }
}

class Transfer extends Transaction {
    private User recipient;
    
    public Transfer(User recipient, double amount) {
        super(amount, "Transfer");
        this.recipient = recipient;
    }
    
    public User getRecipient() {
        return recipient;
    }
}

class TransactionHistory {
    private Transaction[] transactions;
    private int size;
    private static final int MAX_SIZE = 100;
    
    public TransactionHistory() {
        transactions = new Transaction[MAX_SIZE];
        size = 0;
    }
    
    public void addTransaction(Transaction transaction) {
        if (size < MAX_SIZE) {
            transactions[size++] = transaction;
        } else {
            System.out.println("Transaction history full. Unable to add new transaction.");
        }
    }
    
    public void showHistory() {
        for (int i = 0; i < size; i++) {
            Transaction transaction = transactions[i];
            System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
            if (transaction instanceof Transfer) {
                Transfer transfer = (Transfer) transaction;
                System.out.println("Recipient: " + transfer.getRecipient().getName());
            }
        }
    }
}
