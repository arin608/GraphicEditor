package Dto;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle(double radius) {
		
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("원 (동그라미)");
	}

	@Override
	public double calculateArea() {

		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

}
