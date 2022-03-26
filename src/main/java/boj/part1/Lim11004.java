package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, n - 1);
		
		System.out.println(arr[k - 1]);
	}
	
	private static void merge(int[] nums, int s, int e, int m) {
		int[] tmp = new int[e - s + 1];
		
		int i = s;
		int j = m + 1;
		int k = 0;
		
		while(i <= m && j <= e) {
			if(nums[i] < nums[j]) {
				tmp[k++] = nums[i++];
			} else {
				tmp[k++] = nums[j++];
			}
		}
		
		while(i <= m) {
			tmp[k++] = nums[i++];
		}
		
		while(j <= e) {
			tmp[k++] = nums[j++];
		}
		
		System.arraycopy(tmp, 0, nums, s, tmp.length);
	}
	
	private static void mergeSort(int[] nums, int s, int e) {
		if(s < e) {
			int m = (s + e) / 2;
			
			mergeSort(nums, s, m);
			mergeSort(nums, m + 1, e);
			
			merge(nums, s, e, m);
		}
	}
}
