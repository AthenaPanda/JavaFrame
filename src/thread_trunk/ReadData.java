package thread_trunk;
import java.io.*;

public class ReadData {
	public void readMethod(PipedInputStream in) {
		try {
			System.out.println("read : ");
			byte[] byteArray = new byte[20];
			int readLen = in.read(byteArray);
			while(readLen != -1) {
				String newData = new String(byteArray, 0, readLen);
				System.out.println(newData);
				readLen = in.read(byteArray);
			}
			System.out.println();
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
