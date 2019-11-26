package lab13.prtc04;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample1 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("./src/lab13/prtc04/test1.txt");
		char[] data = "ȫ�浿".toCharArray();
		for (int i = 0; i < data.length; i++) {
			writer.write(data[i]);
		}
		writer.flush();
		writer.close();
	}
}
