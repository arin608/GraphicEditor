package Service;

import Dto.Shape;
import Repository.GraphicRepository;

public class GraphicService {
	
	private GraphicRepository repository;
	
	public GraphicService(GraphicRepository repository) {
		this.repository = repository;
	}
	public void insertShape(Shape shape) {
		repository.addShape(shape);
	}
	
	public void deleteShape(int index) {
		repository.removeShape(index);
	}

}
