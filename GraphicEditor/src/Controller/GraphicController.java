package Controller;

import java.util.List;
import java.util.Scanner;

import Dto.*;
import Repository.GraphicRepository;
import Service.GraphicService;

public class GraphicController {

    private GraphicService service;
    private GraphicRepository repository;
    private Scanner scanner;

    public GraphicController(GraphicService service, GraphicRepository repository) {
        this.service = service;
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    public void insertShape(int type) {
        Shape shape;

        switch (type) {
            case 1:
                shape = new Line();
                break;

            case 2:
                System.out.println("사각형의 가로 길이를 입력하세요 : ");
                double width = scanner.nextDouble();
                System.out.println("사각형의 세로 길이를 입력하세요 : ");
                double height = scanner.nextDouble();
                shape = new Rect(width, height);
                break;

            case 3:
                System.out.println("원의 반지름을 입력하세요 : ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;

            default:
                System.out.println("잘못된 입력입니다. 1~3 사이의 정수를 입력해 주세요");
                return;
        }
        service.insertShape(shape);
    }

    public void updateShape(int userIndex) {
    	
    	int internalIndex = userIndex - 1; // 사용자 입력을 내부 인덱스로 변환
    	
        List<Shape> shapes = repository.getShapes();
        if (shapes == null || internalIndex < 0 || internalIndex >= shapes.size()) {
            System.out.println("Error: 입력한 인덱스가 올바르지 안습니다.");
            return;
        }

        Shape shapeToUpdate = shapes.get(internalIndex);

        if (shapeToUpdate instanceof Rect) {
            Rect rect = (Rect) shapeToUpdate;
            System.out.println("사각형을 수정합니다. 현재 가로 길이 : "
                    + rect.getWidth() + " 현재 세로 길이 : " + rect.getHeight());

            System.out.println("새로운 가로 길이를 입력하세요 : ");
            double newWidth = scanner.nextDouble();
            System.out.println("새로운 세로 길이를 입력하세요 : ");
            double newHeight = scanner.nextDouble();

            rect.setWidth(newWidth);
            rect.setHeight(newHeight);

        } else if (shapeToUpdate instanceof Circle) {
            Circle circle = (Circle) shapeToUpdate;
            System.out.println("원의 반지름을 수정합니다. 현재 반지름 : " + circle.getRadius());

            System.out.println("새로운 반지름을 입력하세요 : ");
            double newRadius = scanner.nextDouble();
            circle.setRadius(newRadius);

        } else {
            System.out.println("해당 도형은 수정할 수 없습니다.");
        }
    }

    public void displayShapesWithArea() {
        List<Shape> shapes = repository.getShapes();
        
        if (shapes == null) {
        	System.out.println("등록된 도형이 없습니다.");
        }

        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            System.out.println((i+1) + "모양 : " + shape.getClass().getSimpleName()
                    + ", 넓이 : " + shape.calculateArea());
        }
    }

    public void deleteShape(int userIndex) {
    	
    	int internalIndex = userIndex - 1; // 사용자 입력을 내부 인덱스로 변환
    	List<Shape> shapes = repository.getShapes();
    	if (shapes == null || internalIndex < 0 || internalIndex >= shapes.size()) {
    		System.out.println("Error: 입력한 인덱스가 올바르지 안습니다.");
    		return;
    	}
        service.deleteShape(internalIndex);
    }
}

