package View;

import java.util.List;
import Dto.Shape;

public class GraphicView {
	
	public void displayMenu() {
		
		System.out.println("프로그램을 실행합니다");
		System.out.println("1.삽입\t 2.수정\t 3.삭제\t 4.모두 보기\t5.종료");
		
	}
	
	public void displayShapes(List<Shape> shapes) {
		
		for (Shape shape : shapes) {
			shape.draw();
		}
	}


}
