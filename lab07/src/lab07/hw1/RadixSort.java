/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.15
 * 목적  : RadixSort구현
 *
 ***************************/

package lab07.hw1;

import java.util.Arrays;

public class RadixSort {
	public static int[] radixSort(int[] a) {
		int maxLength = getMaxLength(a); // 자리 수를 getMaxLength라는 메소드로 센 후에 변수에 저장
		int digit = 1; // 자리 수를 for문이 돌아갈 때 마다 나눠주면서 계산하기 위함
		
		int[][] subArray; // 정렬되기전 넣는 버킷을 위한 2차원 배열 
		int[] sortedArray = new int[a.length]; // 버킷에서 다시 정렬된 배열로 빼서 저장하기 위한 배열
		int[] arraySize; // 버킷의 사이즈를 체크하기 위한 배열
		
		for(int m = 0; m < maxLength; m++) {
			
			subArray = new int[10][a.length]; 
			sortedArray = new int[a.length];
			arraySize = new int[10]; // 배열을 초기화 해줘야 for문이 새로 돌게되면 다시 작업을 수행할 수 있음
			
			for(int i = 0; i < a.length; i++) {
				subArray[(a[i]/digit) % 10][arraySize[(a[i]/digit) % 10]++] = a[i];
			} // 버킷에 for문을 통해서 0~9까지 수를 나눠서 넣는 코드
			
			int count = 0;
			int point = 0;
			for(int i = 0; i < a.length; i++) {
				if(count >= arraySize[point]) {
					point++;
					count = 0;
					i--;
					continue;
				} // 빈 공간이 있으면 넣지 않고 i를 하나 빼주고 다음 코드로 돌아가게 함
				sortedArray[i] = subArray[point][count++];
			} // 버킷에 있는 수들을 순차적으로 배열에 넣어 정렬시키기 위함
			a = sortedArray;
			digit *= 10; // 매 for문 마다 10을 곱해주어서 자리 수가 늘어나는 것을 계산을 통해 해결
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
	} // 가장 큰 수의 자리수를 구하기 위한 메소드
	
	public static void main(String[] args) {
		int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		System.out.print("before sorting: ");
		System.out.println(Arrays.toString(arr));
		arr = radixSort(arr);
		System.out.print("after sorting: ");
		System.out.println(Arrays.toString(arr));	
	}
}