package lab13.prtc02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample2 {
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("./src/lab13/prtc02/test2.txt");
		byte[] data = "ABCD".getBytes();
		os.write(data);
		os.flush();
		os.close();
	}
}
