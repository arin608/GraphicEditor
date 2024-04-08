package Dto;

public class Rect extends Shape {

	private double width;
	private double height;
	
	public Rect(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("사각형");
	}

	@Override
	public double calculateArea() {
		
		return width * height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
