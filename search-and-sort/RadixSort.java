public class RadixSort {
	
	// Time Complexity: O(nk) n - inputs, k - number of digits
	// Space Complexity:O(n+k)
	
	public int getMax(int[] arr) {
		int maxInt = arr[0];
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > maxInt)
				maxInt = arr[i];
		return maxInt;
	}
	
	public int getDigit(int num, int divisor) {
		return (num/divisor) % 10;
	}
	
	public void countingSort(int[] arr, int divisor) {
		int n = arr.length;
		int inputRange = 10;
		
		int item, itemIdx;
		
		// Array identical to arr
		int[] output = new int[n];
		// each element initializes to zero by default
		int[] countArr = new int[inputRange];
		
		// Storing frequency of each character/ number
		for (int i = 0; i < n; i++) 
			countArr[getDigit(arr[i], divisor)]++;
		
		// Finding cummulative frequency
		for (int i = 1; i < inputRange; i++)
			countArr[i] += countArr[i-1];
		
		// Index of each input arr element is found from the frequency of it in countArr
		// The output index would be it's freq - 10
		// After this operation decrease the Cummulative frequency at that element by 1.
		// By doing that, we make sure the next occurrence of that element is placed before the current one.
		for (int i = n-1; i >= 0; i--) {
			item = arr[i];
			itemIdx = countArr[getDigit(item, divisor)] - 1;
			
			output[itemIdx] = item;
			
			countArr[getDigit(item, divisor)]--;
		}
		
		for (int i = 0; i < n ; i++)
			arr[i] = output[i];
		
		
	}
	
	public void radixSort(int[] arr) {
		
		// Finding the max element in arr
		int maxInt = getMax(arr);
		
		for (int div = 1; maxInt/div > 0; div *= 10)
			countingSort(arr, div);
		
	}	
	
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] arr = {23, 56, 102, 9006, 11, 612, 10, 72, 43, 95, 7};
		
		rs.printArray(arr);
		
		rs.radixSort(arr);
		
		rs.printArray(arr);
	}
}