package thread_trunk;

public class TestAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* a. Test thread execution sequence 
		 * 
		try {
			MyThread myThread = new MyThread();
			myThread.setName("myThread");
			myThread.start();
			for (int i = 0; i < 10; i++) {
				int time = (int)(Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("main =" + Thread.currentThread().getName());
			}
			
			//create other thread with Runnable
			MyRunnable myRunnable = new MyRunnable();
			Thread threadForRun = new Thread(myRunnable);
			threadForRun.start();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		/*
		 * b. Test thread  unshare var
		 */
		MyThread threadA = new MyThread("A");
		MyThread threadB = new MyThread("B");
		MyThread threadC = new MyThread("C");
		threadA.start();
		threadB.start();
		threadC.start();
	}

}
