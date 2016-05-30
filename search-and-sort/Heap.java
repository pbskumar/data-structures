// Max-heap implementation and Heap Sort.
public class Heap {
	// Time Complextiy: O(nlogn)
	public void heapSort(int[] arr) {
		buildHeap(arr);
		int n = arr.length;
		for (int i = n-1; i>= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			percolate(arr, i, 0);
		}
		
	}
	
	public void buildHeap(int[] arr) {
		int n = arr.length;
		
		// i = n/2 -1 because we start from right-most node in the level above leaf nodes
		for (int i = n / 2 -1; i >= 0; i--) {
			percolate(arr, n, i);
		}
	}
		
	public void percolate(int[] arr, int n, int i) {
		int largestIdx = i;
		int leftIdx = 2 * i + 1;
		int rightIdx = 2 * i + 2;
		
		if (leftIdx < n && arr[leftIdx] > arr[largestIdx])
			largestIdx = leftIdx;
		if (rightIdx < n && arr[rightIdx] > arr[largestIdx])
			largestIdx = rightIdx;
		
		if (largestIdx != i) {
			int temp = arr[largestIdx];
			arr[largestIdx] = arr[i];
			arr[i] = temp;
			
			percolate(arr, n, largestIdx);
		}
	}
	
	
	public static void main(String[] args) {
		Heap h = new Heap();
		int[] arr = {23, 56, 12, 11, 61, 21, 72, 43, 9, 5, 76};
		
		h.heapSort(arr);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
	}
}