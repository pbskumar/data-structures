public class CountingSort {
	
	// Space Complexity: O(n+k) n- for output array, k- for countArr
	// Time Complexity: O(n+k)
	
	public void countSort(int[] arr) {
		int n = arr.length;
		int inputRange = 10;
		
		int item, itemIdx;
		
		
		int[] output = new int[n];
		// each element initializes to zero by default
		int[] countArr = new int[inputRange];
		
		// Storing frequency of each character/ number
		for (int i = 0; i < n; i++) 
			++countArr[arr[i]];
		
		// Finding cummulative frequency
		for (int i = 1; i < inputRange; i++)
			countArr[i] += countArr[i-1];
		
		// Index of each input arr element is found from the frequency of it in countArr
		// The output index would be it's freq - 10
		// After this operation decrease the Cummulative frequency at that element by 1.
		// By doing that, we make sure the next occurrence of that element is placed before the current one.
		for (int i = 0; i < n; i++) {
			item = arr[i];
			itemIdx = countArr[item] - 1;
			
			output[itemIdx] = item;
			
			countArr[item]--;
		}
		
		for (int i = 0; i < n ; i++)
			arr[i] = output[i];
		
		
	}
	
	
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		CountingSort cs = new CountingSort();
		int[] arr = {2, 3, 5, 6, 1, 0, 2, 1, 1, 6, 1, 2, 1, 0, 7, 2, 4, 3, 9, 5, 7, 6};
		cs.printArray(arr);
		
		cs.countSort(arr);
		
		cs.printArray(arr);
	}
}