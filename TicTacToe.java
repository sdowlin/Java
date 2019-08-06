package charlieTeam;

import java.util.Scanner;
import java.util.Random;



// Implements an instance of the Game interface
public class TicTacToe implements Game {

	private Scanner scanner; // Used to scan in strings and chars
	private char[] board; // Array to store board positions
	private char firstInput; // Input for who goes first
	private boolean assigned; // Checks if space is assigned with X or O in array
	private int randomMove; // Used to hold random int for cumputer move
	private int moveInput; // Used to store int user move
	private boolean available; // used to check if all spaces are filled with X or O
	private char playAgainInput; // Used to hold user input to play again or not
	private boolean playAgainBoolean; // Used to evaluate playAgainInput fpr logic
	public int wins; // Records user wins
	public int gamesPlayed; //Records number of games played

	// Done
	public TicTacToe() {

		//initial value of board
		board = new char[9];
		{
			board[0] = ' ';
			board[1] = ' ';
			board[2] = ' ';
			board[3] = ' ';
			board[4] = ' ';
			board[5] = ' ';
			board[6] = ' ';
			board[7] = ' ';
			board[8] = ' ';
		}
		scanner = new Scanner(System.in);

		
	

	}

	
	// Prints board at beginning of each turn
	public void displayBoard() {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + "  ");
		System.out.println("---|---|---");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + "  ");
		System.out.println("---|---|---");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + "  \n");
		


	}


	// Clears board after win/lose/draw
	public void clearBoard() {

		board = new char[9];
		{
			board[0] = ' ';
			board[1] = ' ';
			board[2] = ' ';
			board[3] = ' ';
			board[4] = ' ';
			board[5] = ' ';
			board[6] = ' ';
			board[7] = ' ';
			board[8] = ' ';
		
		}
	}

	// Checks board state for win conditions then prints win and adds win to tally
	public void gameWinner() {
		
		
		
		
		// Win conditions
		if ((board[0] == 'O')&& (board[1] == 'O') && (board[2] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
		if ((board[3] == 'O')&& (board[4] == 'O') && (board[5] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
		if ((board[6] == 'O')&& (board[7] == 'O') && (board[8] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
		if ((board[0] == 'O')&& (board[3] == 'O') && (board[6] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
		if ((board[1] == 'O')&& (board[4] == 'O') && (board[7] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
		if ((board[2] == 'O')&& (board[5] == 'O') && (board[8] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
        if ((board[0] == 'O')&& (board[4] == 'O') && (board[8] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
		if ((board[2] == 'O')&& (board[4] == 'O') && (board[6] == 'O')) {
			System.out.println("You win!");
			wins++;
			setAvailable(true);
		}
	

		
		// Lose conditions
		if ((board[0] == 'X')&& (board[1] == 'X') && (board[2] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
		if ((board[3] == 'X')&& (board[4] == 'X') && (board[5] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
		if ((board[6] == 'X')&& (board[7] == 'X') && (board[8] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
		if ((board[0] == 'X')&& (board[3] == 'X') && (board[6] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
		if ((board[1] == 'X')&& (board[4] == 'X') && (board[7] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
		if ((board[2] == 'X')&& (board[5] == 'X') && (board[8] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
        if ((board[0] == 'X')&& (board[4] == 'X') && (board[8] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}
		if ((board[2] == 'X')&& (board[4] == 'X') && (board[6] == 'X')) {
			System.out.println("You lose.");
			setAvailable(true);
		}

		
	

	
	}
	
	// Initializes the program
	public void initializeProgram() {
		wins = 0;
		gamesPlayed = 0;
	}

	// Prints initial greeting and displays board reference
	public void greetings() {
		System.out.println("Welcome to Charlie Team's Tic Tac Tow Game!\n");
		System.out.println("Computer is always X and you are always O.");
		System.out.println("This grid shows the numbers you will use to choose a space on the board.\n");
		System.out.println(" 1 | 2 | 3 ");
		System.out.println("---|---|---");
		System.out.println(" 4 | 5 | 6 ");
		System.out.println("---|---|---");
		System.out.println(" 7 | 8 | 9 \n");

	}

	// Prints initial board state
	public void initializeGame() {

		System.out.println("The board is set.");
		displayBoard();

	}

	// Prompts user for who should go first
	public char whoMovesFirst() {

		System.out.println("Who moves first?");

		
		do {
			// Picks up first character typed 
			System.out.println("Type C for computer or U for User then hit Enter: ");
			firstInput = scanner.next().charAt(0);

			// Character is evaluated and adjusted for case sensitivity. Loops until instructions followed
			switch (firstInput) {

			case 'c':
			case 'C': {
				firstInput = 'C';
				break;
			}

			case 'u':
			case 'U': {
				firstInput = 'U';
				break;
			}

			default: {

				System.out.println("You did not enter a C or U. Please try again");
				continue;
			}
			}
			return firstInput; //returns value to break out of loop

		} while (firstInput != 'U' || firstInput != 'C');

		return firstInput; // returns value to whoMovesFirst() m,ethod

	}

	// Controls flow of computer turn
	public boolean computerMove() {

		

		
		setAssigned(false); //Used to keep loop if initial slot taken

		Random randomInt = new Random(); // Creates random integer
		
		
		String string = new String(board); // Converts board to string form to evaluate loop

	
		
		if ((string.contains(" "))) { // If a space exists enter the do-while loop
		
			do {
				randomMove = randomInt.nextInt(9); // int assigned to slot

															
				// if slot chosen is open assign an X and allow out of loop
				if (board[randomMove] != 'X' && board[randomMove] != 'O') {
					board[randomMove] = 'X';
					setAssigned(true);

				} else {
	

					// If slot chosen not open reenter loop
					continue;
				}

			} while(assigned == false);
			
			// Show board after move and print out move info
				displayBoard();
				System.out.println("Computer placed X at " + randomMove + "\n"); // test printing System.out.println(randomMove); //test printing
				
		

		available = false; // Assign false to computerMove() to escape turn
		gameWinner(); // Check to see if win/loss condition occurred and end game if so
		
		
	}
		// This is reached if no slots available and will end the game
		else {
			System.out.println("The game was a draw.");
			available = true;
		}
		return available;
		}

	
	
	
	// Controls flow of user turn
	public boolean userMove() {

		
		
		setAssigned(false); //Used to keep loop if initial slot taken

		


		String string = new String(board); // Converts board to string form to evaluate loop

	
		
		if ((string.contains(" "))) { // If a space exists enter the do-while loop
			do {

				System.out.println("Make a move by typing 1-9 then hit Enter: "); 
				moveInput = scanner.nextInt(); 

				// Adjusts input to match board index, attempts to assign as O, then allow out of loop if successful
				if (moveInput >= 1 && moveInput <= 9 && (board[moveInput - 1] != 'X') && (board[moveInput - 1] != 'O')) {
					
					board[moveInput - 1] = 'O';
					setAssigned(true);
				} 
				
				else {
					// Loops back to input and displays message
					System.out.println("Space taken or number out of range, try again!"); 
					continue;
				}

			} while (assigned == false);

			// Places move in board and checks to see if there is a winner
			displayBoard();

			System.out.println("User placed O at " + (moveInput) + "\n"); 
			available = false;
			gameWinner();
		}

		// No space found so a draw is concluded
		else {
			System.out.println("The game was a draw.");
			available = true;
		
		}

		//returns value to userMove()
	return available;

		
	}
	

	// Reset board and ask to play again
	public boolean playAgain() {
		
		gamesPlayed ++;
		clearBoard();
		System.out.println("Thanks for playing Tic Tac Toe!");
		System.out.println("You won " + wins + " out of " + gamesPlayed);

		
		
		// evaluates input and attempts to resolve case mistakes
		do {
			
			System.out.println("Do you want a rematch? Type Y or N");
			playAgainInput = scanner.next().charAt(0);
			
		switch (playAgainInput) {
		case 'y':
		case 'Y': {
			return playAgainBoolean = true;
		}
		case 'n':
		case 'N': {
			return playAgainBoolean = false;
			
			
		}
		default:{
			System.out.println("You did not enter a Y or N. Please try again");
			break;
		}
		
		
		}
		
		} while (playAgainInput != 'N' || playAgainInput != 'Y');
		
		return playAgainBoolean;
	
	}

	// Terminates the game
	public void endProgram() {
		scanner.close();

	}

	
	// List of setters and getters.
	public boolean isAssigned() {
		return assigned;
	}

	public boolean setAssigned(boolean assigned) {
		this.assigned = assigned;
		return assigned;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}


	
	


	



	


}
