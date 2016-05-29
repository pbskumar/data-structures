import java.util.Scanner;

public class BinarySearch {
	
	public static int recursiveBinarySearch(int[] arr, int data, int l, int r) {
		if (l >= 0 && l <= r) {
			// mid = (l + r ) / 2 is not used becausefor large arrays l+r can exceed the range of
			// int. hence, using l + (r-l)/2 is a safe bet.
			int mid = l + (r - l) / 2;
			if(arr[mid] == data)
				return mid;
			if (arr[mid] > data)
				r = mid - 1;
			else
				l = mid + 1;
			
			return recursiveBinarySearch(arr, data, l, r);
		}
		
		return -1;
	}
	
	public static int iterativeBinarySearch(int[] arr, int data) {
		int l = 0;
		int r = arr.length - 1;
		int mid = 0;
		
		while (l >= 0 && l <= r) {
			mid = l + (r - l)/2;
			if(arr[mid] == data)
				return mid;
			if (arr[mid] > data)
				r = mid - 1;
			else
				l = mid + 1;
		} 
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,23,31,35,42,46,52,61,69, 73, 89};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("The numbers in array are:");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println(  );
		
		System.out.println("Enter the number to search: ");
		// int idx = recursiveBinarySearch(arr, sc.nextInt() , 0, arr.length - 1);
		int idx = iterativeBinarySearch(arr, sc.nextInt());
		
		System.out.println(idx);
	}
}