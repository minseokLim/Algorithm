package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2751_selection {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < n - 1; i++) {
			int tmp = i;
			
			for(int j = i + 1; j < n; j++) {
				if(nums[tmp] > nums[j]) tmp = j;
			}
			
			int tempValue = nums[i];
			nums[i] = nums[tmp];
			nums[tmp] = tempValue;
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int s : nums) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}

}
