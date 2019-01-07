package mginham_lab04;

public class mginham_lab04_q3 {
	
	// Methods //
	public static void displayStudentInfo() {
		// Display information & question to user
		System.out.println("********************************"
					   + "\nES1036: Lab 04 Q3"
					   + "\n        Inheritance & Overriding"
					   + "\n        Methods"
					   + "\nDate: November 2, 2018"
					   + "\nName: Megan Ginham"
					   + "\nStudent Number: 251029381"
					   + "\nMission: Create a program that"
					   + "\n         computes the perimeter"
					   + "\n         & area of a square by"
					   + "\n         inheriting from an"
					   + "\n         abstract shape class"
					   + "\n********************************");
	} // end displayStudentInfo

	// MAIN //
	public static void main(String[] args) {
		// Create shape: square
		Square s = new Square (3.6);
		
		// Display dimensions to user
		System.out.println("The area of the square is: " + s.computeArea());
		System.out.println("The perimeter of the square is: " + s.computePerimeter());
	} // end main

} // end class
