package thread_trunk;


public class testLock extends Thread{
	private LockService service;

	public testLock(LockService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		//service.testMethod();
		//service.testMethodB();
		//service.await();
		/*for(int i = 0; i < 10; i++) {
			service.set();
		}*/
		service.read();
	}
}
