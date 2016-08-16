package misc;

public final class Singleton_I204E {
	/**
	 * Implementation #1: Lazy initialization.
	 */
	private static Singleton_I204E instance = null;
	
	private Singleton_I204E() {
	}
	
	public static synchronized Singleton_I204E getInstance() {
		if (instance == null) {
			instance = new Singleton_I204E();
		}
		return instance;
	}
  
	public static void main(String[] args) {
		Singleton_I204E a = Singleton_I204E.getInstance();
		Singleton_I204E b = Singleton_I204E.getInstance();
		System.out.println(a.equals(b));
	}
}

/**
 * LintCode #204
 * Singleton is a most widely used design pattern. 
 * If a class has and only has one instance at every moment, we call this design as singleton. 
 * For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * You job is to implement a getInstance method for given class, 
 *   return the same instance of this class every time you call this method.
 * Example in Java:
 * A a = A.getInstance();
 * A b = A.getInstance();
 * a should equal to b.
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 */
