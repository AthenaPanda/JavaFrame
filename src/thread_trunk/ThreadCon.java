package thread_trunk;

public class ThreadCon extends Thread{
	private Consumer consumer;
	
	public ThreadCon(Consumer consumer) {
		super();
		this.consumer = consumer;
	}
	
	@Override
	public void run() {
		while (true) {
			consumer.getValue();			
		}
	}
}
