package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10819 {
	private static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(arr, 0, n);
		
		System.out.println(max);
	}

	private static void permutation(int[] arr, int depth, int n) {
		if(depth == n - 1) {
			int result = solve(arr, n);
			
			if(result > max) {
				max = result;
			}
			
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n);
			swap(arr, depth, i);
		}
	}

	private static int solve(int[] arr, int n) {
		int sum = 0;
		
		for(int i = 0; i < n - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}
		
		return sum;
	}

	private static void swap(int[] arr, int depth, int i) {
		int tmp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = tmp;
	}
}
