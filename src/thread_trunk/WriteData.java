package thread_trunk;
import java.io.*;

public class WriteData {
	public void writeMethod(PipedOutputStream out) {
		try {
			System.out.println("write : ");
			for(int i =0; i < 300; i++) {
				String outData = ""+ (i+1);
				out.write(outData.getBytes());
				System.out.println(outData);
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
