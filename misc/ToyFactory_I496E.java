package misc;

/**
 * Toy interface.
 */
interface Toy {
	void talk();
}

/**
 * Dog class.
 */
class Dog implements Toy {
	public void talk() {
		System.out.println("Wow");
	}
}

/**
 * Cat class.
 */
class Cat implements Toy {
	public void talk() {
		System.out.println("Meow");
	}
}

public class ToyFactory_I496E {
	public Toy getToy(String type) {
		if ("Dog".equals(type)) {
			return new Dog();
		} else if ("Cat".equals(type)) {
			return new Cat();
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		ToyFactory_I496E obj = new ToyFactory_I496E();
		Toy toy = obj.getToy("Dog");
		toy.talk();	// Wow
		toy = obj.getToy("Cat");
		toy.talk();	// Meow
	}
}

/**
 * LintCode #496
 * Factory is a design pattern in common usage. 
 * Please implement a ToyFactory which can generate proper toy based on the given type.
 * ToyFactory tf = ToyFactory();
 * Toy toy = tf.getToy('Dog');
 * toy.talk(); 
 * >> Wow
 * toy = tf.getToy('Cat');
 * toy.talk();
 * >> Meow
 */
