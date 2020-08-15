package thread_trunk;

import java.util.Random;

public class SecondThread extends Thread {
	
	//private SampleObject secObj;
	private LockService service;
	/*
	 * e. test synchornized 
	 * the lock is for object not method or code
	 */
	//public SecondThread(SampleObject object) {
	public SecondThread(LockService service) {

		super();// TODO Auto-generated constructor stub
		//this.secObj = object;
	    this.service =  service;
	}
	@Override
	public void run() {
		/*
		 long begintime = System.currentTimeMillis();


		long addResult = 0;
		for(int j=0; j < 10; j++) {
			for(int i = 0; i < 50000; i++) {
				Random random = new Random();
				random.nextInt();
				addResult =  addResult + i;

			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("SecondThread time is " + (endtime - begintime) +" ms.");
		*/
		
		
		/*  
		 * e. test synchornized 
		 * the lock is for object not method or code
		 */
		//super.run();
		//secObj.methodA();
		
		// test lock 
		service.testMethodA();
	}
}
