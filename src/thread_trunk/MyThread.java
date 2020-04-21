package thread_trunk;

public class MyThread extends Thread {
	//private int count = 5;
	
	/*
	 * c. Test thread share var 
	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super();
		this.setName(name);
	}*/
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
		long begintime = System.currentTimeMillis();
		int count = 0;
		for(int i = 0; i < 500000; i++) {
			Thread.yield();
			count = count + (i + 1);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("time is " + (endtime - begintime) +" ms.");
	}

}
