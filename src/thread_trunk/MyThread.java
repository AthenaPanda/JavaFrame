package thread_trunk;

public class MyThread extends Thread {
	@Override
	public void run() {
		//super.run();
		try {
			for (int i = 0; i < 10; i++) {
				int time = (int)(Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("Run=" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("MyThread");
	}

}
