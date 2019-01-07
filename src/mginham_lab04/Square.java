package mginham_lab04;

public class Square extends Shape{
	
	// Constructor //
	public Square(double length) {
		sideLength = length;
		numOfSides = 4;
	} // end constructor
	
	// Getters and Setters //
	protected void setNumOfSides(int num) {
		numOfSides = num;
	} // end setNumofSides
	protected int getNumberOfSides() {
		return numOfSides;
	} // end getNumberOfSides
	protected void setSideLength(double length) {
		sideLength = length;
	} // end setSideLength
	protected double getSideLength() {
		return sideLength;
	} // end getSideLength
	
	// Methods //
	public double computeArea() {
		double area = Math.pow(sideLength, 2);
		
		return area;
	} // end computeArea
	public double computePerimeter() {
		double perimeter = numOfSides*sideLength;
		
		return perimeter;
	} // end computePerimeter
	
} // end class
