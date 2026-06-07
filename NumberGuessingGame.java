import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean playAgain = true;
		
		System.out.println("=== Welcome to Ryan's Number Guessing Game! ===");
		
		while (playAgain) {
			
			int choice = -1;
			
			// allows users to select difficulty
			while (true) {
				System.out.println("\nChoose difficulty:");
				System.out.println("1. Easy (10 guesses, 1 - 50)");
				System.out.println("2. Medium (7 guesses, 1 - 100)");
				System.out.println("3. Hard (5 guesses, 1 - 200)");
				System.out.print("Select option: ");
				
				if (scanner.hasNextInt()) {
					choice = scanner.nextInt();
					
					if (choice >= 1 && choice <= 3) {
						break;
					}
					
					else {
						System.out.println("Please enter 1, 2, or 3.");
					}
					
				}
				
				else {
					System.out.println("Invalid input. Please enter a number (1-3).");
			        scanner.next(); // clear bad input (THIS is what prevents the crash)
			        }
				}
			
			// difficulty medium is default
			int maxNumber = 100;
			int maxTries = 7;
			
			//int choice = scanner.nextInt();
			
			// difficulty = easy
			if (choice == 1) {
				maxNumber = 50;
				maxTries = 10;
			}
			
			// difficulty = medium
			else if (choice == 2) {
				maxNumber = 100;
				maxTries = 7;
			}
			
			// difficulty = hard
			else if (choice == 3) {
				maxNumber = 200;
				maxTries = 5;
			}
		
			
			int secretNumber = random.nextInt(maxNumber) + 1;
			int tries = 0;
			boolean guessedCorrectly = false;
			
			// begins guessing portion of the game
			System.out.println("\nHmm, Ryan's thinking of a number between 1 and " + maxNumber + "...");
			System.out.println("You have " + maxTries + " tries, GO!");
			
			while (!guessedCorrectly && tries < maxTries) {
				
				// allows user input
				System.out.print("What's your guess: ");
				
				if (scanner.hasNextInt()) {
					
					int guess = scanner.nextInt();
					tries++;
					
					// guess is too low
					if (guess < secretNumber) {
						System.out.println("Too low, try again...\n");
						System.out.println((maxTries - tries) + " tries left!");
					}
					
					// guess is too high
					else if (guess > secretNumber) {
						System.out.println("Too high, try again...\n");
						System.out.println((maxTries - tries) + " tries left!");
					}
					
					// guess is correct
					else {
						System.out.println("\nWoo! You got it!");
						System.out.println("It took you " + tries + " tries!");
						System.out.println("With " + (maxTries - tries) + " tries left!");
						guessedCorrectly = true;
					}
					
				}
				
				else {
					System.out.println("\nThat's not a number, try again.\n");
					// clears invalid input
					scanner.next(); 
				}
				
			}
			
			// reveals the secret number
			if (!guessedCorrectly) {
				System.out.println("\nGame over! You've used all your attempts.");
				System.out.println("The number was: " + secretNumber);
			}
			
			System.out.print("\nPlay again? (y/n): ");
			String response = scanner.next();
			
			// selecting "y" restarts game
			playAgain = response.equalsIgnoreCase("y");			
		}
		
		// selecting "n" will quit the game
		System.out.println("\nThank you for playing! I hope you had fun!");
		scanner.close();
	}

}
