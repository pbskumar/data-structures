public class MergeSort {
	// Time Cimplexity: O(nlogn) 
	// n for merge operation and logn for recurring calls
	// Space Complexity: O(n)
	// Best for LinkedLists
	// Used for external sort. 
	// For large data, small chunks of data are sorted first and merged at last.
	
	public void merge(int[] arr, int l, int mid, int r) {
	
		int arr1Len = mid - l + 1;
		int arr2Len = r - mid;
		
		int[] arr1 = new int[arr1Len], arr2 = new int[arr2Len];
		
		System.arraycopy(arr, l, arr1, 0, arr1Len);
		System.arraycopy(arr, mid + 1, arr2, 0, arr2Len);

		int i = 0, j = 0, k = l;
		
		while (i < arr1Len && j < arr2Len) {
			if (arr1[i] <= arr2[j]) 
				arr[k++] = arr1[i++];
			else
				arr[k++] = arr2[j++];
			
		}
		
		while(i < arr1Len)
			arr[k++] = arr1[i++];
			
		while(j < arr2Len)
			arr[k++] = arr2[j++];
		
	}
	
	public void mergeSort(int[] arr, int l, int r) {
		int n = arr.length - 1;
		if (l < 0 || r > n || l == r)
			return;
		
		int mid = l + (r - l)/2;
		
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		
		merge(arr, l, mid, r);
		
	}
	
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = {23, 56, 12, 11, 61, 21, 72, 43, 9, 5, 56};
		
		ms.mergeSort(arr, 0, arr.length - 1);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
	}
}