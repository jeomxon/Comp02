/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.15
 * ����  : RadixSort����
 *
 ***************************/

package lab07.hw1;

import java.util.Arrays;

public class RadixSort {
	public static int[] radixSort(int[] a) {
		int maxLength = getMaxLength(a); // �ڸ� ���� getMaxLength��� �޼ҵ�� �� �Ŀ� ������ ����
		int digit = 1; // �ڸ� ���� for���� ���ư� �� ���� �����ָ鼭 ����ϱ� ����
		
		int[][] subArray; // ���ĵǱ��� �ִ� ��Ŷ�� ���� 2���� �迭 
		int[] sortedArray = new int[a.length]; // ��Ŷ���� �ٽ� ���ĵ� �迭�� ���� �����ϱ� ���� �迭
		int[] arraySize; // ��Ŷ�� ����� üũ�ϱ� ���� �迭
		
		for(int m = 0; m < maxLength; m++) {
			
			subArray = new int[10][a.length]; 
			sortedArray = new int[a.length];
			arraySize = new int[10]; // �迭�� �ʱ�ȭ ����� for���� ���� ���ԵǸ� �ٽ� �۾��� ������ �� ����
			
			for(int i = 0; i < a.length; i++) {
				subArray[(a[i]/digit) % 10][arraySize[(a[i]/digit) % 10]++] = a[i];
			} // ��Ŷ�� for���� ���ؼ� 0~9���� ���� ������ �ִ� �ڵ�
			
			int count = 0;
			int point = 0;
			for(int i = 0; i < a.length; i++) {
				if(count >= arraySize[point]) {
					point++;
					count = 0;
					i--;
					continue;
				} // �� ������ ������ ���� �ʰ� i�� �ϳ� ���ְ� ���� �ڵ�� ���ư��� ��
				sortedArray[i] = subArray[point][count++];
			} // ��Ŷ�� �ִ� ������ ���������� �迭�� �־� ���Ľ�Ű�� ����
			a = sortedArray;
			digit *= 10; // �� for�� ���� 10�� �����־ �ڸ� ���� �þ�� ���� ����� ���� �ذ�
		}
		return sortedArray;
	}
	
	private static int getMaxLength(int[] a) {
		int max = 0;
		for(int num : a) {
			if(max < num) {
				max = num;
			}
		}
		return (int)Math.log10(max)+1;
	} // ���� ū ���� �ڸ����� ���ϱ� ���� �޼ҵ�
	
	public static void main(String[] args) {
		int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		System.out.print("before sorting: ");
		System.out.println(Arrays.toString(arr));
		arr = radixSort(arr);
		System.out.print("after sorting: ");
		System.out.println(Arrays.toString(arr));	
	}
}