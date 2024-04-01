import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static ArrayList<String> playChoices;
	
	static {
		playChoices = new ArrayList<>();
		playChoices.add("r");
		playChoices.add("p");
		playChoices.add("s");
	}
	
	static HashMap<String, String> choiceKey;
	
	static {
		choiceKey = new HashMap<>();
		choiceKey.put("r", "rock");
		choiceKey.put("p", "paper");
		choiceKey.put("s", "scissors");
	}
	
	static HashMap<String, String> resultMap;
	
	static {
		resultMap = new HashMap<>();
		resultMap.put("rs", "won");
		resultMap.put("rp", "lost");
		resultMap.put("sr", "lost");
		resultMap.put("sp", "won");
		resultMap.put("pr", "won");
		resultMap.put("ps", "lost");
	}
	
	byte numOfRounds;
	Scanner scanner;
	byte userScore = 0;
	byte computerScore = 0;
	byte currentRound = 1;
	
	public Game(byte numOfRounds, Scanner scanner) {
		this.numOfRounds = numOfRounds;
		this.scanner = scanner;
	}
	
	public void playGame() {
		System.out.println("Okay! let's play a " + numOfRounds + " round game!");
		System.out.println("Press \"q\" at any time to quit");
		System.out.println();
		
		Random randGenerator = new Random();
		
		while (userScore + computerScore < numOfRounds) {
			System.out.println("Round " + currentRound + ":");
			System.out.println("Press \"r\" for rock, \"p\" for paper or \"s\" for scissors");
			
			String userChoice = scanner.nextLine();
			System.out.println();
			
			if (userChoice.equals("q")) break;
			if (!playChoices.contains(userChoice)) {
				System.out.println("Invalid choice");
				continue;
			}
			
			int randIndex = randGenerator.nextInt(3);
			String computerChoice = playChoices.get(randIndex);
			
			System.out.println("The computer played " + choiceKey.get(computerChoice) + "!");
			
			if (userChoice.equals(computerChoice)) {
				System.out.println("It was a draw!");
				System.out.println("Let's redo round " + currentRound);
				System.out.println();
				continue;
			}
			
			String result = resultMap.get(userChoice + computerChoice);
			
			if (result.equals("won")) {
				userScore++;
				System.out.println("Congratulations, you won this round!");
			}
			else {
				computerScore++;
				System.out.println("Too bad, you lost this round!");
			}
			
			if (userScore + computerScore == numOfRounds) {
				endGame();
			} else {
				System.out.println("The score is");
				System.out.println("You: " + userScore);
				System.out.println("Computer: " + computerScore);
			}
			
			currentRound++;
			
			System.out.println();
		}
	}
	
	private void endGame() {
		System.out.println();
		System.out.println("Final Score");
		System.out.println("You: " + userScore);
		System.out.println("Computer: " + computerScore);
		
		if (userScore > computerScore) {
			System.out.println("Congratulations! You won this match!!!");
			System.out.println("Let's play again!");
		}
		else if (userScore < computerScore) {
			System.out.println("It looks like I got you this time...");
			System.out.println("I'm up for a rematch if you are!");
		} else {
			System.out.println("Wow! We tied!");
			System.out.println("Let's settle this with a rematch!");
		}
	}
}
