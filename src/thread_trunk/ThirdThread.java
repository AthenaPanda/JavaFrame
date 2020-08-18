package thread_trunk;


public class ThirdThread extends Thread{
	//private Object lock;
	private LockService service;
	//public ThirdThread(Object lock) {
	public ThirdThread(LockService service) {
		super();
		//this.lock = lock;
		this.service = service;
	}
	
	@Override
	public void run() {
		/*try {
				synchronized (lock) {
					System.out.println("start wait time = " + System.currentTimeMillis());
					lock.wait(2000);
					System.out.println("end wait time = " + System.currentTimeMillis());
				}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//service.testMethodA();
	}
}
