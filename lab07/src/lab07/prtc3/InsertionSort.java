package lab07.prtc3;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int ai = a[i], j = i;
			for(j = i; j > 0 && a[j-1] > ai; j--) { 
				a[j] = a[j-1];
			}
			a[j] = ai;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {55, 22, 11, 44, 33, 66};
		System.out.print("before sorting: ");
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.print("after sorting: ");
		System.out.println(Arrays.toString(arr));
	}
}
