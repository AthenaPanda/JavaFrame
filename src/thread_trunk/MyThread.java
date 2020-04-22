package thread_trunk;
import java.util.Random;

public class MyThread extends Thread {
	//private int count = 5;
	private SampleObject myObj;
	/*
	 * c. Test thread share var 
	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super();
		this.setName(name);
	}*/
	/*
	 * e. test synchornized 
	 * the lock is for object not method or code
	 */
	public MyThread(SampleObject object) {

		super();// TODO Auto-generated constructor stub
		this.myObj = object;
	}
	@Override
	 synchronized public void run() {
		/*
		 * b. Test thread unshare var  
		 *
		super.run();
		while(count > 0) {
			count--;
			System.out.println("get " + this.currentThread().getName() +" count is " + count);
		}
		*/
		/*  a. Test thread execution sequence 
		 * try {
			for (int i = 0; i < 10; i++) {
				int time = (int)(Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("Run=" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		/*
		 * c. Test thread share var 
		 *
		super.run();
		count--;
		System.out.println("get " + this.currentThread().getName() +" count is " + count);
		*/
		
		/* 
		 * d .test Thread priority
		 *
		long begintime = System.currentTimeMillis();
		//int count = 0;
		long addResult = 0;
		for(int j=0; j < 10; j++) {
			for(int i = 0; i < 50000; i++) {
			//Thread.yield();
				Random random = new Random();
				random.nextInt();
				addResult =  addResult + i;
				//count = count + (i + 1);
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("MyThread time is " + (endtime - begintime) +" ms.");
		*/
		
		/*  
		 * e. test synchornized 
		 * the lock is for object not method or code
		 */
		super.run();
		myObj.methodA();
	}

}
