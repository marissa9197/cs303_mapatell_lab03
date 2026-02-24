

import java.util.Arrays;
import java.util.Random;

public class Lab03 {
	
	public static String name = "Marissa Patellaro";
	public static String blazerID = "mapatell";
	
	// TODO:#(1): HEAP SORT - REFER TO Heap.java file
	// Default class constructor provided
	// You may add any class attributes as you see fit to complete the assignment
	// The only requirement is that the 3 functions must follow the provided pseudocode
	
	//#(2): MERGE AND INSERTION SORT - you may copy your lab2 solution here
	public static void insertion_sort(int[] arr) {
		
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;	
		}
		;
	}
	
	public static void merge_sort(int[] arr, int[] temp, int p, int r) {
		
		if (p < r){
			int q = (p + r) / 2; //finds midpoint
			merge_sort(arr, temp, p, q);
			merge_sort(arr, temp, q + 1, r);
			merge(arr, temp, p, q, r);
		}
		;
	}
	
	public static void merge(int[] arr, int[] temp, int p, int q, int r) {
		
		for (int k = p; k <= r; k++) {
			temp[k] = arr[k];
		}
		
		int i = p;
		int j = q + 1;
			
		for (int k = p; k <= r; k++) {
			if (i > q) {
				arr[k] = temp[j++];
			} else if (j > r) {
				arr[k] = temp[i++];
			} else if (temp[j] < temp[i]) {
				arr[k] = temp[j++];
			} else {
				arr[k] = temp[i++];
			}
		}
		;
	}
	
	//############# DO NOT MODIFY CODE BELOW THIS LINE #############
	
	public static int[] gen_array(int n) {
		Random rand = new Random();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}
	
	public static boolean compare_arr(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		for (int i = 0; i<arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		long start;
		long stop;
		
		int[][] arrays = new int[13][];
		int n = 4;
		for (int i = 0; i < 13; i++) {
			arrays[i] = new int[(int)(Math.pow(2, n))];
			int[] temp = gen_array((int)(Math.pow(2, n)));
			arrays[i] = temp.clone();
			n++;
		}
		
		System.out.println("Name: " + name);
		System.out.println("BlazerID: " + blazerID);
		
		System.out.println("-------- Insertion Sort --------");
		
		n = 4;
		for (int[] array : arrays) {
			int[] arr = array.clone();
			if (n == 4) {
				System.out.println("Before insertion sort: " + Arrays.toString(arr));
			}
			int[] sorted_arr = arr.clone();
			
			start = System.nanoTime();
			insertion_sort(arr);
			stop = System.nanoTime();
			
			boolean is_true = compare_arr(sorted_arr, arr);
			
			if (n == 4) {
				System.out.println("After insertion sort: " + Arrays.toString(arr));
			}
			
			System.out.println("Array size: 2**" + n + 
					" || Correct: " + is_true + " || Time: " + (stop-start) + "ns");
			n++;
		}
		
		System.out.println("-------- Merge Sort --------");
		
		n = 4;
		for (int[] array : arrays) {
			int[] arr = array.clone();
			int[] temp = new int[arr.length];
			if (n == 4) {
				System.out.println("Before merge sort: " + Arrays.toString(arr));
			}
			int[] sorted_arr = arr.clone();
			
			start = System.nanoTime();
			merge_sort(arr, temp, 0, arr.length - 1);
			stop = System.nanoTime();
			
			boolean is_true = compare_arr(sorted_arr, arr);
			
			if (n == 4) {
				System.out.println("After merge sort: " + Arrays.toString(arr));
			}
			
			System.out.println("Array size: 2**" + n + 
					" || Correct: " + is_true + " || Time: " + (stop-start) + "ns");
			n++;
		}
		
		System.out.println("--------- Heap Sort --------");
		
		n = 4;
		for (int[] array : arrays) {
			int[] arr = array.clone();
			if (n == 4) {
				System.out.println("Before heap sort: " + Arrays.toString(arr));
			}
			
			int[] sorted_arr = arr.clone();
			
			Heap heap = new Heap();
			
			start = System.nanoTime();
			heap.heapsort(arr);
			stop = System.nanoTime();
			
			boolean is_true = compare_arr(sorted_arr, arr);
			
			if (n == 4) {
				System.out.println("After heap sort: " + Arrays.toString(arr));
			}
			
			System.out.println("Array size: 2**" + n + 
					" || Correct: " + is_true + " || Time: " + (stop-start) + "ns");
			n++;
		}
		
	}
}
