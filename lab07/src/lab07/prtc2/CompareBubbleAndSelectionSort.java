package lab07.prtc2;

import lab07.prtc1.MyArray;

public class CompareBubbleAndSelectionSort {
	public static void main(String[] args) {
		int[] arr1 = new int[10000];
		int[] arr2 = new int[10000];
		
		for(int i = 0; i < 10000; i++) {
			arr1[i] = (int)(Math.random()*10000);
		}
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		long start = System.currentTimeMillis();
		MyArray.bubbleSort(arr1);
		long end = System.currentTimeMillis();
		System.out.println("bubble sort: " + (end - start)/1000.0 + "ÃÊ");
		
		start = System.currentTimeMillis();
		SelectionSort.selectionSort(arr2);
		end = System.currentTimeMillis();
		System.out.println("selection sort: " + (end - start)/1000.0 + "ÃÊ");
		
	}
}
