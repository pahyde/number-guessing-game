import java.util.*;

public class numberGame {
	private static Scanner scan = new Scanner(System.in);
	private static boolean userWantsToPlay = true;
	private static int min = 1;
	private static int max = 100;
	private static int games = 0;
	private static int totalGuesses = 0;
	private static int maxGuesses = 0;
    
	public static void main(String[] args) {
		
		printIntroMessage();
		
		while (userWantsToPlay) {
		    runGame();
		    System.out.print("\nDo you want to play again? ");
		    userWantsToPlay = Character.toLowerCase(scan.next().charAt(0)) == 'y';
		}
		displayGameStats();
    }
    
    public static void runGame() {
    	
    	System.out.println("\nI'm thinking of a number...");
    	int target = (int) (Math.random() * (max + 1 - min)) + min;
    	
    	int guesses = 0;
    	
    	while (true) {
    		System.out.print("Your guess? ");
    		int guess = scan.nextInt();
    		guesses++;
    		if (guess < target) {
    			System.out.println("higher");
    		} else if (guess > target) {
    			System.out.println("lower");
    		} else {
    			System.out.println("You got it right in " + guesses + " guesses");
    			updateStats(guesses);
    			return;
    		}
    	}
    }
    
    public static void updateStats(int guesses) {
    	totalGuesses += guesses;
    	maxGuesses = Math.max(maxGuesses, guesses);
    	games++;
    }
    
    public static void displayGameStats() {
    	System.out.println("\nOveral results:");
    	System.out.printf("%s\n%s\n%s\n%s\n",
    			"    total games   = " + games,
    			"    total guesses = " + totalGuesses,
    			"    guesses/game  = " + (totalGuesses / games),
    			"    max guesses   = " + maxGuesses);
    }
    
    public static void printIntroMessage() {
    	System.out.printf("%s\n%s %d %s %d\n%s\n%s\n%s",
    			"This program allows you to play a guessing game.",
    			"I will think of a number between", min, "and", max,
    			"and will allow you to guess until you get it",
    			"For each guess, I will tell you whether the",
    			"right answer is higher or lower than your guess.");
    }
}
