package lab14.prtc03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8888);
		}
		catch (IOException e) {
			System.err.println("다음의 포트 번호에 연결할 수 없습니다.: 8888");
			System.exit(1);
		}
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		}
		catch (IOException e) {
			System.err.println("accept() 실패");
			System.exit(1);
		}
		try {
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			QuizProtocol protocol = new QuizProtocol();
			String outputLine = protocol.process(null);
			writer.println(outputLine);
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				outputLine = protocol.process(inputLine);
				writer.println(outputLine);
				System.out.println(outputLine);
				if (outputLine.equals("quit")) {
					break;
				}
			}
			writer.close();
			reader.close();
			clientSocket.close();
			serverSocket.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
