package lab03.prtc3;

public class LottoTest {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		System.out.println("´çÃ·¹øÈ£:" + lotto.getWinNumbers());
		lotto.drawAgain();
		System.out.println("´çÃ·¹øÈ£:" + lotto.getWinNumbers());
	}
}
