package thread_trunk;

public class FourthThread extends Thread {
	
	private Object lock;
	
	public FourthThread(Object lock) {
		super();
		this.lock = lock;
	}
	
	@Override
	public void run() {
			synchronized (lock) {
				System.out.println("Sart notify time = " + System.currentTimeMillis());
				lock.notify();
				System.out.println("End notify time = " + System.currentTimeMillis());
			}

	}

}
