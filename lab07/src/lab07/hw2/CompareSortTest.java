/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW02
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.15
 * ����  : BubbleSort, SelectionSort, InsertionSort, RadixSort, Arrays.sort�� ���� ������ ���� �迭, �̹� ���ĵ� ���, �������� ���ĵ� ����� ���� ���̸� ��
 *
 ***************************/

package lab07.hw2;

import java.util.Arrays;
import java.util.Scanner;

import lab07.hw1.RadixSort;
import lab07.prtc1.MyArray;
import lab07.prtc2.SelectionSort;
import lab07.prtc3.InsertionSort;

public class CompareSortTest {
	public static int[] makeRandArr(int n, int low, int high) {
		int[] randArr = new int[n];
		
		for(int i = 0; i < randArr.length; i++) {
			low = (int) Math.ceil(low);
			high = (int) Math.floor(high);
			randArr[i] = (int) (Math.floor(Math.random() * (high - low)) + low);
		} // n���� ���� �������� ���� �迭
		return randArr;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("�� ���� �迭�� ����ðڽ��ϱ�?: ");
		int n = scan.nextInt();
		
		System.out.print("���Ѱ��� �Է��ϼ���: ");
		int low = scan.nextInt();
		
		System.out.print("���Ѱ��� �Է��ϼ���: ");
		int high = scan.nextInt();
		
		
		System.out.println("\n���� �迭�� ���");
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		arr1 = makeRandArr(n, low, high);
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		long start = System.nanoTime();
		MyArray.bubbleSort(arr2);
		long end = System.nanoTime();
		System.out.println("bubble sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		SelectionSort.selectionSort(arr2);
		end = System.nanoTime();
		System.out.println("selection sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		InsertionSort.insertionSort(arr2);
		end = System.nanoTime();
		System.out.println("insertion sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		RadixSort.radixSort(arr2);
		end = System.nanoTime();
		System.out.println("radix sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		Arrays.sort(arr2);
		end = System.nanoTime();
		System.out.println("Arrays.sort: " + (end - start)/1000000000.0 + "��");
		
		//////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n�̹� ���ĵ� ���");
		
		int[] sortedArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			sortedArr[i] = i;
		}
		
		arr1 = sortedArr;
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		MyArray.bubbleSort(arr2);
		end = System.nanoTime();
		System.out.println("bubble sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		SelectionSort.selectionSort(arr2);
		end = System.nanoTime();
		System.out.println("selection sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		InsertionSort.insertionSort(arr2);
		end = System.nanoTime();
		System.out.println("insertion sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		RadixSort.radixSort(arr2);
		end = System.nanoTime();
		System.out.println("radix sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		Arrays.sort(arr2);
		end = System.nanoTime();
		System.out.println("Arrays.sort: " + (end - start)/1000000000.0 + "��");
		
		/////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n�������� ���ĵ� ���");
		
		int[] reverseSortedArr = new int[n];
		
		for(int i = n-1; i >= 0; i--) {
			reverseSortedArr[i] = i;
		}
		
		arr1 = reverseSortedArr;
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		MyArray.bubbleSort(arr2);
		end = System.nanoTime();
		System.out.println("bubble sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		SelectionSort.selectionSort(arr2);
		end = System.nanoTime();
		System.out.println("selection sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		InsertionSort.insertionSort(arr2);
		end = System.nanoTime();
		System.out.println("insertion sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		RadixSort.radixSort(arr2);
		end = System.nanoTime();
		System.out.println("radix sort: " + (end - start)/1000000000.0 + "��");
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
		
		start = System.nanoTime();
		Arrays.sort(arr2);
		end = System.nanoTime();
		System.out.println("Arrays.sort: " + (end - start)/1000000000.0 + "��");
		
	}
}
