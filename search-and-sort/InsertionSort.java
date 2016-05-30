public class InsertionSort {
	// Time Complexity: O(n^2))
	// 
	public void insertionSort(int[] arr) {
		int data;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			data = arr[i];
			int j = i -1;
			while (j >= 0 && arr[j] > data){
				arr[j+1] = arr[j];
				j--;
			}
			arr[++j] = data;
		}
		
	}
	
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] arr = {23, 56, 12, 11, 61, 21, 72, 43, 9, 5, 56};
		is.insertionSort(arr);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
		
	}
}