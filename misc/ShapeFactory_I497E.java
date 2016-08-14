package misc;

/**
 * Shape interface.
 */
interface Shape {
    void draw();
}

/**
 * Rectangle class.
 */
class Rectangle implements Shape {
	public void draw() {
		System.out.println(" ----");
		System.out.println("|    |");
		System.out.println(" ----");
	}
}

/**
 * Square class.
 */
class Square implements Shape {
	public void draw() {
		System.out.println(" ----");
		System.out.println("|    |");
		System.out.println("|    |");
		System.out.println(" ----");
	}
}

/**
 * Triangle class.
 */
class Triangle implements Shape {
	public void draw() {
		System.out.println("  /\\");
		System.out.println(" /  \\");
		System.out.println("/____\\");
	}
}

public class ShapeFactory_I497E {
	public Shape getShape(String shapeType) {
		if ("Square".equals(shapeType)) {
			return new Square();
		} else if ("Triangle".equals(shapeType)) {
			return new Triangle();
		} else if ("Rectangle".equals(shapeType)) {
			return new Rectangle();
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		ShapeFactory_I497E obj = new ShapeFactory_I497E();
		Shape shape = obj.getShape("Square");
		shape.draw();	// draw a square
		shape = obj.getShape("Triangle");
		shape.draw();	// draw a triangle
		shape = obj.getShape("Rectangle");
		shape.draw();	// draw a rectangle
	}
}

/**
 * LintCode #497
 * Factory is a design pattern in common usage. Implement a ShapeFactory that can generate correct shape.
 * You can assume that we have only tree different shapes: Triangle, Square and Rectangle.
 * Example
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape("Square");
 * shape.draw();
 * >>  ----
 * >> |    |
 * >> |    |
 * >>  ----
 * shape = sf.getShape("Triangle");
 * shape.draw();
 * >>   /\
 * >>  /  \
 * >> /____\
 * shape = sf.getShape("Rectangle");
 * shape.draw();
 * >>  ----
 * >> |    |
 * >>  ----
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
