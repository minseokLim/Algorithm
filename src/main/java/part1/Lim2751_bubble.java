package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2751_bubble {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
				
		for(int i = 0; i < n - 1; i++){
			
			for(int j = 0; j < n - 1 - i; j++) {
				if(nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int s : nums) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
}
