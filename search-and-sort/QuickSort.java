public class QuickSort {

	public void quickSort(int[] arr, int l, int r) {
		
		if (l==r) return;
		
		int n = arr.length;
		int pivot = l;
		int i = l + 1;
		int j = r;
		
		while (i < n && j >= 0 && i <= j) {
			
			while (arr[i] <= arr[pivot])
				i++;
			while (arr[j] > arr[pivot])
				j--;
			
			if(j > i) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			printArray(arr);
		}
		i--;
		int temp = arr[i];
		arr[i] = arr[pivot];
		arr[pivot] = temp;
		
		printArray(arr);
		
		quickSort(arr, l, i);
		quickSort(arr, i + 1, r); 
		
	}
	
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = {23, 56, 12, 11, 61, 21, 72, 43, 9, 5, 76};
		qs.printArray(arr);
		
		qs.quickSort(arr, 0, arr.length-1);
		
		qs.printArray(arr);
	}
	
}