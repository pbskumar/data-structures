public class BubbleSort {
	// Time Complexity: O(n^2)
	// When sorted array is given Time Complexity: O(n)
	// Best in class when given array is already sorted.
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp;
		boolean swapped;
		// In bubble sort, the largets element goes to its position in first series of swaps
		// In the 2nd series of swaps, 2nd largest element  moves to n-2 and so on.
		// Hence, j decreases on each iteration of the outer loop.
		for (int i = 0; i < n-1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
					swapped = true;
				}
			}
			
			if (swapped == false)
				break;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {23, 56, 12, 11, 61, 21, 72, 43, 9, 5, 56};
		
		bubbleSort(arr);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
	}
}