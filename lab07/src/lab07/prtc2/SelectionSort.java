package lab07.prtc2;

import lab07.prtc1.MyArray;

public class SelectionSort {
	public static void selectionSort(int[] a) {
		for(int i = a.length - 1; i > 0; i--) {
			int m = 0;
			for(int j = 1; j <= i; j++) {
				if(a[j] > a[m]) {
					m = j;
				}
			}
			MyArray.swap(a, i, m);
		}
	}
}
