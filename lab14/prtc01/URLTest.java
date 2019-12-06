package lab14.prtc01;

import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://computer.cnu.ac.kr/computer/notice/bachelor.do?mode=view&articleNo=122400&article.offset=0&articleLimit=10#/list");
		
		System.out.println("Authority: " + url.getAuthority());
		System.out.println("Content: " + url.getContent());
		System.out.println("DefaultPort: " + url.getDefaultPort());
		System.out.println("Port: " + url.getPort());
		System.out.println("File: " + url.getFile());
		System.out.println("Host: " + url.getHost());
		System.out.println("Path: " + url.getPath());
		System.out.println("Protocol: " + url.getProtocol());
		System.out.println("Query: " + url.getQuery());
		System.out.println("Ref: " + url.getRef());
		System.out.println("UserInfo: " + url.getUserInfo());
		System.out.println("ExternalForm: " + url.toExternalForm());
		System.out.println("URI: " + url.toURI());
	}
}
