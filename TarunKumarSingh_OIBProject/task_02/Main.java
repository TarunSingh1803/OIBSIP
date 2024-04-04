import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = generateRandomNumber(lowerBound, upperBound);
        int maxAttempts = 5;
        int attempts = 0;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!\nGuess a number between " + lowerBound + " and " + upperBound);

        while (true) {
            String input = JOptionPane.showInputDialog("Enter your guess:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                break;
            }

            try {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
                    score += 100 - (attempts * 10);
                    int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
                    if (option == JOptionPane.YES_OPTION) {
                        randomNumber = generateRandomNumber(lowerBound, upperBound);
                        attempts = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Your final score is: " + score);
                        break;
                    }
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }

                if (attempts >= maxAttempts) {
                    JOptionPane.showMessageDialog(null, "You have reached the maximum number of attempts. The correct number was " + randomNumber);
                    int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
                    if (option == JOptionPane.YES_OPTION) {
                        randomNumber = generateRandomNumber(lowerBound, upperBound);
                        attempts = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Your final score is: " + score);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    private static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
