package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2751_quick {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		quickSort(nums, 0, n - 1);
		
		StringBuffer sb = new StringBuffer();
		
		for(int s : nums) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void quickSort(int[] nums, int s, int e) {
		
		if(s < e) {
			int pivot = nums[s];
			int low = s + 1;
			int high = e;
			
			while(low <= high) {
				while(low <= e && nums[low] <= pivot) {
					low++;
				}
				
				while( high >= s + 1 && nums[high] >= pivot) {
					high--;
				}
				
				if(low > high) {
					break;
				}
				
				int tmp = nums[low];
				nums[low++] = nums[high];
				nums[high--] = tmp;
			}
			
			nums[s] = nums[high];
			nums[high] = pivot;
			
			quickSort(nums, s, high - 1);
			quickSort(nums, high + 1, e);
		}		
	}
}
