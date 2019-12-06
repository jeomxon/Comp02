package lab14.prtc03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class QuizClient {
	public static void main(String[] args) {
		PrintWriter writer;
		BufferedReader reader = null;
		try {
			Socket socket = new Socket("localhost", 8888);
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String fromServer;
			String fromClient;
			Scanner scanner = new Scanner(System.in);
			while ((fromServer = reader.readLine()) != null) {
				System.out.println("서버: " + fromServer);
				if(fromServer.equals("quit")) {
					break;
				}
				fromClient = scanner.nextLine();
				if (fromClient != null) {
					System.out.println("클라이언트: " + fromClient);
					writer.println(fromClient);
				}
			}
			scanner.close();
			reader.close();
			writer.close();
			socket.close();
		}
		catch (UnknownHostException e) {
			System.err.println("localhost에 접근할 수 없습니다.");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("입출력 오류");
			System.exit(1);
		}
	}
}
