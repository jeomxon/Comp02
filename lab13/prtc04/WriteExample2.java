package lab13.prtc04;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample2 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("./src/lab13/prtc04/test2.txt");
		char[] data = "ȫ�浿".toCharArray();
		writer.write(data);
		
		writer.flush();
		writer.close();
	}
}
