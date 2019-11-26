package lab13.prtc03;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {
	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("./src/lab13/prtc03/test.txt");
		int readData;
		while(true) {
			readData = reader.read();
			if(readData == -1) break;
			System.out.print((char)readData);
		}
		reader.close();
	}
}
