/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.11.26
 * ����  : �ؽ�Ʈ ������� ���� ������ȣ ����
 *
 ***************************/

package lab13.hw01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaesarCipherTest {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("./src/lab13/hw01/original_text.txt");
			out = new FileOutputStream("./src/lab13/hw01/cryptographic_text.txt");
			int c;
			
			while((c = in.read()) != -1) {
				if(c >= 65 && c <=90) {
					if(c == 88 || c == 89 || c == 90) {
						out.write(c-23);
					}
					else {
						out.write(c+3);
					}
				}
				else if(c >= 97 && c <= 122){
					if(c == 120 || c == 121 || c == 122) {
						out.write(c-55);
					}
					else {
						out.write(c-29);
					}
				}
				else {
					out.write(c);
				}
			}
		}
		finally {
			if(in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
