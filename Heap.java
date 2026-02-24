

public class Heap {
	
	private int heapSize;
	
	//#(1): HEAP SORT
	// You may add any class attributes as you see fit to complete the assignment
	// The only requirement is that the 3 functions must follow the provided pseudocode
	
	public void heapsort(int[] arr) {
		
		buildMaxHeap(arr);
		
		for (int i = arr.length - 1; i >= 1; i--) {
			
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapSize--;
			
			maxHeapify(arr, 0);
		}

		;
	}
	
	public void buildMaxHeap(int[] arr) {
		
		heapSize = arr.length;
		
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			maxHeapify(arr, i);
		}

		;
	}
	
	public void maxHeapify(int[] arr, int i) {
		
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		
		if (l < heapSize && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < heapSize && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			maxHeapify(arr, largest);
		}
		
		;
	}
}