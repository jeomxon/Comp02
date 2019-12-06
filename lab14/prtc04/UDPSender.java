package lab14.prtc04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPSender {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		
		System.out.println("발신 시작");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String data = scanner.nextLine();
			byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
			SocketAddress address = new InetSocketAddress("localhost", 5001);
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address);
			datagramSocket.send(packet);
			if(data.equalsIgnoreCase("exit")) {
				break;
			}
			System.out.println("보낸 내용: " + data);
		}
		datagramSocket.close();
		scanner.close();
		System.out.println("발신 종료");
	}
}
