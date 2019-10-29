/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW02
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.29
 * ����  : ������ �������� ����� ����ϴ� GUI ���α׷�
 *
 ***************************/

package lab09.hw01;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lab07.hw1.RadixSort;
import lab07.hw2.CompareSortTest;
import lab07.prtc1.MyArray;
import lab07.prtc2.SelectionSort;
import lab07.prtc3.InsertionSort;
import javafx.scene.control.TextArea;

public class CompareSortingController {

	@FXML TextField randomInteger;
	@FXML TextField lowerLimit;
	@FXML TextField upperLimit;
	@FXML TextArea randomSorting;
	@FXML TextArea doneSorting;
	@FXML TextArea reverseSorting;
	@FXML public void sortingAction() {
		int n = Integer.parseInt(randomInteger.getText());
		int low = Integer.parseInt(lowerLimit.getText());
		int high = Integer.parseInt(upperLimit.getText());
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		// ���� ����
		
		StringBuilder builder1 = new StringBuilder();
		
		arr1 = CompareSortTest.makeRandArr(n, low, high);
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		long start = System.nanoTime();
		MyArray.bubbleSort(arr2);
		long end = System.nanoTime();
		builder1.append("Bubble sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		SelectionSort.selectionSort(arr2);
		end = System.nanoTime();
		builder1.append("Selection sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		InsertionSort.insertionSort(arr2);
		end = System.nanoTime();
		builder1.append("Insertion sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		RadixSort.radixSort(arr2);
		end = System.nanoTime();
		builder1.append("Radix sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		Arrays.sort(arr2);
		end = System.nanoTime();
		builder1.append("Arrays.sort: " + (end - start)/1000000000.0 + "��");
		
		randomSorting.setText(builder1.toString());
		
		///////////////////////////////////////////////////////////////////////////////////
		// ���ĵǾ� �ִ� ���
		
		int[] sortedArr = new int[n];
		StringBuilder builder2 = new StringBuilder(); 
		
		for(int i = 0; i < n; i++) {
			sortedArr[i] = i;
		}
		
		arr1 = sortedArr;
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		MyArray.bubbleSort(arr2);
		end = System.nanoTime();
		builder2.append("Bubble sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		SelectionSort.selectionSort(arr2);
		end = System.nanoTime();
		builder2.append("Selection sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		InsertionSort.insertionSort(arr2);
		end = System.nanoTime();
		builder2.append("Insertion sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		RadixSort.radixSort(arr2);
		end = System.nanoTime();
		builder2.append("Radix sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		Arrays.sort(arr2);
		end = System.nanoTime();
		builder2.append("Arrays.sort: " + (end - start)/1000000000.0 + "��");
		
		doneSorting.setText(builder2.toString());
		
		//////////////////////////////////////////////////////////////////////////////////
		// �������� ���ĵ� ���
		
		int[] reverseSortedArr = new int[n];
		StringBuilder builder3 = new StringBuilder();
		
		for(int i = n-1; i >= 0; i--) {
			reverseSortedArr[i] = i;
		}
		
		arr1 = reverseSortedArr;
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		MyArray.bubbleSort(arr2);
		end = System.nanoTime();
		builder3.append("Bubble sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		SelectionSort.selectionSort(arr2);
		end = System.nanoTime();
		builder3.append("Selection sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		InsertionSort.insertionSort(arr2);
		end = System.nanoTime();
		builder3.append("Insertion sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		RadixSort.radixSort(arr2);
		end = System.nanoTime();
		builder3.append("Radix sort: " + (end - start)/1000000000.0 + "��\n");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		Arrays.sort(arr2);
		end = System.nanoTime();
		builder3.append("Arrays.sort: " + (end - start)/1000000000.0 + "��");
		
		reverseSorting.setText(builder3.toString());
	}

}
