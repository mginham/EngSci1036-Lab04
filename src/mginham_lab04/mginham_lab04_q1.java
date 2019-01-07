package mginham_lab04;

import java.util.Scanner;

public class mginham_lab04_q1 {
	
	// Declare and initialize global variables //
	public static Scanner input = new Scanner(System.in);
	
	// Methods //
	public static void displayStudentInfo() {
		// Display information & question to user
		System.out.println("********************************"
					   + "\nES1036: Lab 04 Q1"
					   + "\n        Static Calculator Class"
					   + "\nDate: November 2, 2018"
					   + "\nName: Megan Ginham"
					   + "\nStudent Number: 251029381"
					   + "\nMission: Create a calculator"
					   + "\n         class that implements"
					   + "\n         several custom math"
					   + "\n         functions"
					   + "\n********************************");
	} // end displayStudentInfo
	private static char displayMenu() {
		// Declare and initialize variables
		char optionChoice = 0;
		
		// Display menu options
		System.out.println("\n--------------------------"
						 + "\n--Calculator Application--"
						 + "\n--------------------------"
						 + "\na. Power Function"
						 + "\nb. Inverse Tangent Function"
						 + "\nc. Sine Function"
						 + "\nd. Exponential Function"
						 + "\ne. Factorial Function"
						 + "\nf. Exit"
						 + "\n--------------------------");
		
		do { // Validate that an appropriate char has been entered (loop until input is valid)
			// Prompt user for input
			System.out.print("Please enter your choice: ");
				optionChoice = input.next().charAt(0);
			
			if(optionChoice < 97 || optionChoice > 102)
				System.out.print("Invalid input! ");
		} while(optionChoice < 97 || optionChoice > 102); // valid input: 97-102 (a-f)
		
		return optionChoice;
	} // end displayMenu
	
	public static class Calculator {
		// a. Power Function
		public static double power(double base, int expo) {
			// Declare and initialize variables
			double result = base;
			boolean negPower = false;
			
			// Calculate the result
			if(expo == 0) // Any base to the power zero is equal to one (except 0, which is indeterminate)
				result = 1;
			else {
				if(expo < 0) {
					negPower = true;
					expo *= -1;
				}
				
				for(int i = 1; i < expo; i++)
					result *= base;
				
				if(negPower)
					result = 1/result;
			}
			
			return result;
		} // end power
		// b. Inverse Tangent Function
		public static double inverseTangent (double radians, int iterations) {
			// Declare and initialize variables
			int expo = 0;
			double result = radians; // accounts for first (n=0) iteration of summation
			
			// Calculate the result
			for(int n = 1; n <= iterations; n++) {
				expo = 2*n+1;
				
				result += (power(-1,n))*(power(radians,expo)/expo);
			}
			
			return result;
		} // end inverseTangent
		// c. Sine Function
		public static double sine(double radians, int iterations) { // not valid for values > abs(5.9)
			// Declare and initialize variables
			int expo = 0;
			double result = radians; // accounts for first (n=0) iteration of summation
			
			// Calculate the result
			for(int n = 1; n <= iterations; n++) {
				expo = 2*n+1;
				
				result += (power(-1,n))*(power(radians,expo)/factorial(expo));
			}
			
			return result;
		} // end sine
		// d. Exponential Function
		public static double exponential(double exponential, int iterations) {
			// Declare and initialize variables
			double result = 0;
			
			// Calculate the result
			for(int n = 0; n <= iterations; n++)
				result += (power(exponential,n)/factorial(n));
			
			return result;
		} // end exponential
		// e. Factorial Function
		public static double factorial(int value) {
			// Declare and initialize variables
			double factorial = 0;
			int counter = 0;
			
			// Calculate the result
			if(value == 0) // the factorial of zero is one
				factorial = 1;
			else {
				factorial = value;
				
				while(++counter < value)
					factorial *= (value-counter);
			}
			
			return factorial;
		} // end factorial
	} // end static class Calculator
	
	// MAIN //
	public static void main(String[] args) {
		// Declare and initialize variables
		char menuChoice = 0;
		double base = 0, radians = 0, exponential = 0, result = 0;
		int expo = 0, iterations = 0, value = 0;
		
		displayStudentInfo();
		
		do { // Loop while menu choice != f (exit)
			// Print menu from method
			menuChoice = displayMenu();
			
			// Execute appropriate method
			if(menuChoice == 97) { // option a: Power Function
				// Prompt user for necessary input
				System.out.print("\nPlease enter a real number base: ");
					base = input.nextDouble();
				System.out.print("\nPlease enter an integer exponent: ");
					expo = input.nextInt();
				
				// Calculate result
				result = Calculator.power(base, expo);
			}
			else if(menuChoice == 98) { // option b: Inverse Tangent Function
				// Prompt user for necessary input
				System.out.print("\nPlease enter a number in radians: ");
					radians = input.nextDouble();
				System.out.print("\nPlease enter the number of iterations: ");
					iterations = input.nextInt();
			
				// Calculate result
				result = Calculator.inverseTangent(radians, iterations);
			}
			else if(menuChoice == 99) { // option c: Sine Function
				// Prompt user for necessary input
				System.out.print("\nPlease enter a number in radians: ");
					radians = input.nextDouble();
				System.out.print("\nPlease enter the number of iterations: ");
					iterations = input.nextInt();
				
				// Calculate result
				result = Calculator.sine(radians, iterations);
			}
			else if(menuChoice == 100) { // option d: Exponential Function
				// Prompt user for necessary input
				System.out.print("\nPlease enter a number for the exponential: ");
					exponential = input.nextDouble();
				System.out.print("\nPlease enter the number of iterations: ");
					iterations = input.nextInt();
				
				// Calculate result
				result = Calculator.exponential(exponential, iterations);
			}
			else if(menuChoice == 101) { // option e: Factorial Function
				// Prompt user for necessary input
				System.out.print("Please input a positive integer: ");
					value = input.nextInt();
				
				// Calculate result
				result = Calculator.factorial(value);
			}
			
			if(menuChoice != 102)
				// Display result to user
				System.out.println("The result is: " + result);
		} while(menuChoice != 102); // char f = 102 (exit)
		
		System.out.println("\n--------------------------"
					  	 + "\nGoodbye!"
						 + "\n--------------------------");
	} // end main

} // end class
