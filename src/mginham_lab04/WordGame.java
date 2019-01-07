package mginham_lab04;

import java.util.Scanner;

public class WordGame {
	
	// Declare and initialize global variables //
	public static Scanner input = new Scanner(System.in);
	public static StringBuilder word = new StringBuilder();
	public static String answer;
	public static int aLength;
	
	// Constructor //
	public WordGame() {
		playGame();
	} // end constructor
	
	// Methods //
	public static boolean checkIfValidWord(String word) { // check if word consists solely of uppercase alphabet letters
		boolean validWord = true;
		
		for(int i = 0; i < word.length(); i++)
			if(word.charAt(i) < 65 || word.charAt(i) > 90)
				validWord = false;
		
		return validWord;
	} // end checkForNotLetters
	public static boolean guessLetter() {
		// Declare and initialize variables
		boolean solved = true, elementOfWord = false;
		String userInput = "";
		char guess = 0;
		
		// Prompt User2 to make a letter guess
		do {
			System.out.print("Please enter your letter guess: ");
				userInput = input.next().toUpperCase();
				
				guess = userInput.charAt(0);
				
				if(guess < 65 || guess > 90 || userInput.length() != 1)
					System.out.print("\nInvalid input. ");
		} while(guess < 65 || guess > 90 || userInput.length() != 1); // loop while outside A to Z
		
		// Search for letter guess in word
		for(int i = 0; i < aLength; i++) {
			// Reveal all occurrences of letter in word
			if(guess == answer.charAt(i)) {
				word.setCharAt(i, guess);
				elementOfWord = true;
			}
		}
		
		if(!elementOfWord)
			System.out.println("\nThat letter is not in the word.");
		
		// Compare word to answer in case solution was found
		for(int i = 0; i < aLength; i++)
			if(word.charAt(i) != answer.charAt(i))
				solved = false;
		
		if(solved)
			System.out.println("\nYou guessed the word!");
		
		return solved;
	} // end guessLetter
	public static boolean guessWord() {
		// Declare and initialize variables
		boolean solved = false, validWord = true;
		String guess = "";
		
		// Prompt User2 to make a word guess
		do {
			System.out.print("Please enter your guess: ");
				guess = input.next().toUpperCase();
				
			// Check if guess consists solely of uppercase alphabet letters
			validWord = checkIfValidWord(guess);
			
			if(!validWord)
				System.out.print("\nInvalid input. ");
		} while(!validWord);
			
		// Compare guess to answer
		if(guess.equals(answer)) {
			System.out.println("\nYou guessed the answer!");
			word.replace(0, aLength, answer);
			solved = true;
		}
		else
			System.out.println("\nThat is not the answer.");
		
		return solved;
	} // end guessWord
	public static void displayWord() {
		System.out.println("\n\n" + word);
	} // end displayWord
	public static void playGame() {
		// Declare and initialize variables
		String answer = "";
		char charInput = 0;
		int turnsRemaining = 10;
		boolean solved = false, validWord = true;
		
		// Prompt User1 for input: Initial word
		do {
			System.out.print("Enter a word to begin the game: ");
				answer = input.next().toUpperCase();
			
			// Check if guess consists solely of uppercase alphabet letters
			validWord = checkIfValidWord(answer);
			
			if(!validWord)
				System.out.print("\nInvalid input. ");
		} while(!validWord); // loop while answer is invalid
			
		// Store solution
		WordGame.answer = answer;
		aLength = answer.length();
		
		// Initialize word as blanks
		for(int i = 0; i < aLength; i++)
			word.append("*");
		
		// Guess the word / letters in the word
		do { // Loop while User2 still has guesses left
			displayWord();
			
			// Display number of guesses remaining
			System.out.print("\nYou have " + turnsRemaining + " turn(s). ");
			
			// Prompt User2 for input: Preference of guessing word or letter
			System.out.print("Would you like to guess the word? (y/n): ");
				charInput = input.next().charAt(0);
			
			// Validate input
			while(charInput != 110 && charInput != 121) {// n = 110, y = 121
				System.out.print("\nIncorrect input, please enter y or n: ");
					charInput = input.next().charAt(0);
			}
			
			// Execute appropriate method
			if(charInput == 110)
				solved = guessLetter();
			else
				solved = guessWord();
		} while(turnsRemaining-- > 0 && !solved);
		
		// Display final game result to User2
		displayWord();
		
		if(!solved)
			System.out.println("\nYou lost! You were unable to guess the word in 10 tries"); 
		else
			System.out.println("\nYou won with " + turnsRemaining + " turn(s) remaining!");
		
	} // end playGame
	
} // end class
