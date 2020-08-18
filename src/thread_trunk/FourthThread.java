package thread_trunk;

public class FourthThread extends Thread {
	
	//private Object lock;
	private LockService service;
	
	//public FourthThread(Object lock) {
	public FourthThread(LockService service) {
		super();
		//this.lock = lock;
		this.service = service;
	}
	
	@Override
	public void run() {
			/*synchronized (lock) {
				System.out.println("Sart notify time = " + System.currentTimeMillis());
				lock.notify();
				System.out.println("End notify time = " + System.currentTimeMillis());
			}*/
			//service.testMethodB();
		/*for(int i = 0; i < 10; i++) {
			service.get();
		}*/
		service.read();
	}

}
