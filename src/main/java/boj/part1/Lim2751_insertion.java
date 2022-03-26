package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2751_insertion {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i < n; i++) {
			int tmp = nums[i];
			int j = i - 1;
			
			while(j >= 0 && nums[j] > tmp) {
				nums[j + 1] = nums[j];
				j--;
			}
			
			nums[j + 1] = tmp;
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int s : nums) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
}
