package _template;

import java.util.Arrays;

// http://swlock.blogspot.com/2016/03/permutation-algorithm.html
	
public class PermutationPractice {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		permutation(arr, 0, arr.length);
	}

	private static void permutation(int[] arr, int depth, int n) {
		
		if(depth == n - 1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n);
			swap(arr, i, depth);
		}
	}

	private static void swap(int[] arr, int i, int depth) {
		int temp = arr[i];
		arr[i] = arr[depth];
		arr[depth] = temp;
	}
}
