package mginham_lab04;

public abstract class Shape {
	
	// Declare global variables //
	protected int numOfSides;
	protected double sideLength;
	
	// Getters and Setters //
	protected abstract void setNumOfSides(int num);
	protected abstract int getNumberOfSides();
	protected abstract void setSideLength(double length);
	protected abstract double getSideLength();
	
	// Methods //
	public abstract double computeArea();
	public abstract double computePerimeter();
	
} // end class