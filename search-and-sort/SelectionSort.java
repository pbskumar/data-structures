public class SelectionSort {
	// Time complexity : O(n^2)
	// SPace Complexity : O(1)
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		int minIdx = 0;
		int temp;
		for (int i = 0; i < n - 1; i++) {
			minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx])
					minIdx = j;
			}
			// Here, we could do away with If.
			// If there was no min element found, i == minIdx
			// The array will remain same. If loop is used to avoid 
			// that unnecessary swap operation
			if (minIdx != i) {
				temp = arr[minIdx];
				arr[minIdx] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {23, 56, 12, 11, 61, 21, 72, 43, 9, 5, 56};
		selectionSort(arr);
		// int sortedArr = selectionSort(arr);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
	}
}