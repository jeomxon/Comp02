package lab13.hw02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Word {

	public String getRandomWord() throws IOException {

		Random random = new Random();
		BufferedReader br = null;
		int countLine = 0;
		List<String> strList = new LinkedList<String>();
		String str;
		
		try {
			br = new BufferedReader(new FileReader("./src/lab13/hw02/sample.txt"));

			while ((str = br.readLine()) != null) {
				strList.add(str);
				countLine++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로가 잘못되었거나 찾을 수 없습니다.");
		}
		
		br.close();
		
		int randomNum = random.nextInt(countLine);
		
		return strList.get(randomNum);
	}
}
