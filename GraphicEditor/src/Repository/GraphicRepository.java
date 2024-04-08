package Repository;

import java.util.ArrayList;
import java.util.List;
import Dto.Shape;

public class GraphicRepository {

	private List<Shape> shapes;
	
	public GraphicRepository() {
		shapes = new ArrayList<>();
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}
	
	public void addShape(Shape shape) {
		
		shapes.add(shape);
	}
	
	public void removeShape(int index) {
		
		if (index >= 0 && index < shapes.size()) {
			shapes.remove(index);
		}
	}
}
