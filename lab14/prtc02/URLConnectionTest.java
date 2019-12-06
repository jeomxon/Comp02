package lab14.prtc02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://computer.cnu.ac.kr/computer/notice/bachelor.do?mode=view&articleNo=122400&article.offset=0&articleLimit=10#/list");
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inLine;
		while((inLine = in.readLine()) != null) {
			System.out.println(inLine);
		}
		in.close();
	}
}
