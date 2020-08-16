package thread_trunk;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class LockService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void testMethod() {
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread Name is " + ThreadRead.currentThread().getName() + (" " + (i + 1)));
		}
		lock.unlock();
	}
	
	public void testMethodA() {
		try {
			lock.lock();
			System.out.println("methodA begin Thread Name is " + ThreadRead.currentThread().getName() +
					" time is " + System.currentTimeMillis());
			ThreadRead.sleep(5000);
			System.out.println("methodA End Thread Name is " + ThreadRead.currentThread().getName() +
					" time is " + System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void testMethodB() {
		try {
			lock.lock();
			System.out.println("methodB begin Thread Name is " + ThreadRead.currentThread().getName() +
					" time is " + System.currentTimeMillis());
			ThreadRead.sleep(5000);
			System.out.println("methodB End Thread Name is " + ThreadRead.currentThread().getName() +
					" time is " + System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void await() {
		try {
			lock.lock();
			System.out.println("await time is " + System.currentTimeMillis());
			condition.await();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void signal() {
		try {
			lock.lock();
			System.out.println("sinal time is " + System.currentTimeMillis());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
