package thread_trunk;

public class Product {
	private String lock;
	
	public Product(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		try {
			synchronized (lock) {
				if(!ValueObject.value.equals("")) {
					lock.wait();
				}
				String valueString = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("Set value is " + valueString);
				ValueObject.value = valueString;
				lock.notify();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
