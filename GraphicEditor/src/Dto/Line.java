package Dto;

public class Line extends Shape {

	@Override
	public void draw() {
		System.out.println("선");
	}

	@Override
	public double calculateArea() {
		return 0; // 선의 넓이는 0
	}

}
