package maxsubarray;
// import java.util.Scanner;

public class MaxSumSubArray {
	
	static void maxSubarrayKadake(int[] arr) {
		
		MaxSub max = new MaxSub();
		
		int sum = 0;
		int start_index = 0;
		int end_index = 0;
		
		int current_max = -99999;
		
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum > current_max) {
				current_max = sum;
				end_index = i;
			} else if (sum < 0) {
				sum = 0;
				start_index = i+1;
			}
			
			if(current_max > max.sum) {
				max.sum = current_max;
				max.start = start_index;
				max.end = end_index;
			}
			
		}
		
		System.out.println("Max sum = " + max.sum);
		System.out.println("indices = (" + max.start + "," + max.end + ")");
	}
	
	static void maxSubarrayDivConquer(int[] arr) {
		
	}
	
	static void printArray(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ' ');
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		
		//int[] input_arr = {0, -1, 2, -5, 6, -1, 3, };
		
		int[] input_arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		maxSubarrayKadake(input_arr);
		
	}

}
