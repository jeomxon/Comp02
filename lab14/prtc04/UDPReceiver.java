package lab14.prtc04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UDPReceiver {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(5001);
		System.out.println("���� ����");
		while(true) {
			byte[] bytes = new byte[1024];
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
			datagramSocket.receive(packet);
			String data = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
			if(data.equalsIgnoreCase("exit")) {
				break;
			}
			System.out.println("��������: " + data);
		}
		datagramSocket.close();
		System.out.println("���� ����");
	}
}
