package thread_trunk;

public class JoinThread extends Thread {

	@Override
	public void run() {
		try {
			int secondValue = (int)(Math.random() * 10000);
			System.out.println("test time is " + secondValue);
			ThreadRead.sleep(secondValue);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
