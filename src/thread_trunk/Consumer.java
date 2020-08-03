package thread_trunk;

public class Consumer {
	private String lock;
	
	public Consumer(String lock) {
		super();
		this.lock = lock;
	}
	
	public void getValue() {
		try {
			synchronized (lock) {
				if(ValueObject.value.equals("")) {
					lock.wait();
				}
				System.out.println("get value is " + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
