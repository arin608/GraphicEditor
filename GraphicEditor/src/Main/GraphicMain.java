package Main;

import java.util.Scanner;

import Controller.GraphicController;
import Repository.GraphicRepository;
import Service.GraphicService;
import View.GraphicView;

public class GraphicMain {
	
	public static void main(String[] args) {
		
		GraphicRepository repository = new GraphicRepository();
		GraphicService service = new GraphicService(repository);
		GraphicController controller = new GraphicController(service, repository);
		GraphicView view = new GraphicView();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			view.displayMenu();
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("도형을 선택하세요\n 1.Line, 2.Rect, 3.Circle >> ");
				int shapeType = scanner.nextInt();
				controller.insertShape(shapeType);
				break;

			case 2:
				System.out.println("수정할 도형의 순서를 입력하세요 : ");
				int updateIndex = scanner.nextInt();
				controller.updateShape(updateIndex);
				break;
				
			case 3:
				System.out.println("삭제할 도형의 순서를 입력하세요 : ");
				int index = scanner.nextInt();
				controller.deleteShape(index);
				break;
				
			case 4:
				controller.displayShapesWithArea();
				break;
				
			case 5:
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				System.exit(0);
				
			default:
				System.out.println("잘못된 입력입니다. 1~5사이의 수를 입력하세요.");
			
			}
		}
	}

}
