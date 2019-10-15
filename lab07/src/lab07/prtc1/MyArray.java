package lab07.prtc1;

import java.util.Arrays;

public class MyArray {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubbleSort(int[] a) {
		for(int i = a.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(a[j] > a[j+1]) {
					MyArray.swap(a, j, j + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {55, 22, 11, 44, 33, 66};
		System.out.print("before sorting: ");
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.print("after sorting: ");
		System.out.println(Arrays.toString(arr));
	}
}
