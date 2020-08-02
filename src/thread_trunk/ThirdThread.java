package thread_trunk;

public class ThirdThread extends Thread{
	private Object lock;
	public ThirdThread(Object lock) {
		super();
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
				synchronized (lock) {
					System.out.println("start wait time = " + System.currentTimeMillis());
					lock.wait();
					System.out.println("end wait time = " + System.currentTimeMillis());
				}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
