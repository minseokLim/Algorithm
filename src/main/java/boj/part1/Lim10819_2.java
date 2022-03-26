package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10819_2 {	
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(arr, 0, n);
		
		System.out.println(max);
	}

	private static void permutation(int[] arr, int depth, int n) {
		
		if(depth == n - 1) {
			int sum = calculate(arr);
			
			if(sum > max) {
				max = sum;
			}
		}
		
		for(int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n);
			swap(arr, i, depth);
		}
	}

	private static int calculate(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}
		
		return sum;
	}

	private static void swap(int[] arr, int i, int depth) {
		
		if(i == depth) {
			return;
		}
		
		int temp = arr[i];
		arr[i] = arr[depth];
		arr[depth] = temp;
	}
}
