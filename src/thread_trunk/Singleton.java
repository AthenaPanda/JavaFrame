package thread_trunk;

public class Singleton {

	private static volatile Singleton instance = null;
	
	private Singleton() {
		System.out.println("get one word!");
	}
	
	private static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		else {
			System.out.println("Have one word ,do not need any more!S");
		}
		return instance;
	}
	
	private static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}
	
	public void getName() {
		System.out.println("The word is Hello world!");
	}
}
