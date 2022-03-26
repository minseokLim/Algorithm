package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2751_merge {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(nums, 0, n - 1);
		
		StringBuffer sb = new StringBuffer();
		
		for(int s : nums) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void merge(int[] nums, int s, int e, int m) {
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
	
	public static void mergeSort(int[] nums, int s, int e) {
		if(s < e) {
			int m = (s + e) / 2;
			
			mergeSort(nums, s, m);
			mergeSort(nums, m + 1, e);
			
			merge(nums, s, e, m);
		}
	}
}
