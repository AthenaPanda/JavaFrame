package thread_trunk;

import trunk.MyRunnable;
import trunk.MyThread;

public class TestAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		}
		
	}

	}

}
