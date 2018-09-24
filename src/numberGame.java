import java.util.*;

public class numberGame {
	private static Scanner scan = new Scanner(System.in);
	private static boolean userWantsToPlay = true;
	private static int min = 1;
	private static int max = 100;
	private static int guesses = 0;
    
	public static void main(String[] args) {
		while (userWantsToPlay) {
		    runGame();
		    System.out.print("Do you want to keep playing? ");
		    userWantsToPlay = Character.toLowerCase(scan.next().charAt(0)) == 'y';
		    System.out.println();
    	} 
    }
    
    public static void runGame() {
    	
    	printIntroMessage();
    	
    	System.out.println("I'm thinking of a number...");
    	int target = (int) (Math.random() * (max + 1 - min)) + min;
    	
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
    			guesses = 0;
    			return;
    		}
    	}
    }
    
    public static void printIntroMessage() {
    	String message = String.format("%s\n%s %d %s %d\n%s\n%s\n%s\n",
    			"This program allows you to play a guessing game.",
    			"I will think of a number between", min, "and", max,
    			"and will allow you to guess until you get it",
    			"For each guess, I will tell you whether the",
    			"right answer is higher or lower than your guess.");
    	System.out.println(message);
    }
    
    
}
