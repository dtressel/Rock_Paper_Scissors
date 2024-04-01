import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Let's play Rock, Paper, Scissors!");
		
		while(true) {
			byte numOfRounds = 0;
			
			System.out.println("How many rounds do you want to play?");
			System.out.println("Choose 1-20 or \"q\" to quit");
			
			String roundResponse = scanner.nextLine();
			
			System.out.println();
			
			if (roundResponse.equals("q")) break;
			
			boolean isNumeric = roundResponse.matches("-?\\d+(\\.\\d+)?");
			
			if (isNumeric) numOfRounds = Byte.parseByte(roundResponse);
			
			if (numOfRounds >= 1 && numOfRounds <= 20) {
				Game newGame = new Game(numOfRounds, scanner);
				newGame.playGame();
				System.out.println("Let's play again!");
			}
			else {
				System.out.println("Invalid Response");
			}

		}
		
		scanner.close();

	}

}
