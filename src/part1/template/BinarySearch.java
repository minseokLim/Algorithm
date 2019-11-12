package part1.template;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {234, 5, -42, 35345, 7572352, -7546, 345, 0, -12, 43242, 345, 345, 234};
		int target = 345;
		int cnt = binarySearch(arr, target);
		
		System.out.println(cnt);
	}

	private static int binarySearch(int[] arr, int target) {
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int left = 0;
		int right = arr.length - 1;
		int cnt = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] < target) {
				left = mid + 1;
			} else if(arr[mid] > target) {
				right = mid - 1;
			} else {
				cnt ++;
				int tmp = mid;
				
				while(--tmp >= left && arr[tmp] == target) {
					cnt++;
				}
				
				while(++mid <= right && arr[mid] == target) {
					cnt++;
				}
				
				break;
			}
		}
		
		return cnt;
	}
}
