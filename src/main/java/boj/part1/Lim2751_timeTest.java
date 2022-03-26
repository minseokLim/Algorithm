package boj.part1;

import java.util.Arrays;
import java.util.Random;

public class Lim2751_timeTest {
	public static void main(String[] args) {
		int[] nums = new Random().ints(100000).toArray();
		System.out.println("selectionSort : " + selectionSort(nums) + " millis");
		System.out.println("insertionSort : " + insertionSort(nums) + " millis");
		System.out.println("bubbleSort : " + bubbleSort(nums) + " millis");
		System.out.println("mergeSort : " + mergeSortMain(nums) + " millis");
		System.out.println("quickSort : " + quickSortMain(nums) + " millis");
		System.out.println("javaSort : " + javaSort(nums) + " millis");
	}
	
	public static Long javaSort(int[] origin) {
		int[] nums = Arrays.copyOf(origin, origin.length);
		
		long start = System.currentTimeMillis();
		
		Arrays.sort(nums);
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	
	public static Long selectionSort(int[] origin) {
		int[] nums = Arrays.copyOf(origin, origin.length);
		int n = nums.length;
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < n - 1; i++) {
			int tmp = i;
			
			for(int j = i + 1; j < n; j++) {
				if(nums[tmp] > nums[j]) tmp = j;
			}
			
			int tempValue = nums[i];
			nums[i] = nums[tmp];
			nums[tmp] = tempValue;
		}
		
		long end = System.currentTimeMillis();
				
		return end - start;
	}
	
	public static Long insertionSort(int[] origin) {
		int[] nums = Arrays.copyOf(origin, origin.length);
		int n = nums.length;
		
		long start = System.currentTimeMillis();
		
		for(int i = 1; i < n; i++) {
			int tmp = nums[i];
			int j = i - 1;
			
			while(j >= 0 && nums[j] > tmp) {
				nums[j + 1] = nums[j];
				j--;
			}
			
			nums[j + 1] = tmp;
		}
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	
	public static Long bubbleSort(int[] origin) {
		int[] nums = Arrays.copyOf(origin, origin.length);
		int n = nums.length;
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < n - 1; i++){
			
			for(int j = 0; j < n - 1 - i; j++) {
				if(nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	
	public static Long mergeSortMain(int[] origin) {
		int[] nums = Arrays.copyOf(origin, origin.length);
		int n = nums.length;
		
		long start = System.currentTimeMillis();
		mergeSort(nums, 0, n - 1);
		
		long end = System.currentTimeMillis();
		
		return end - start;
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
	
	public static Long quickSortMain(int[] origin) {
		int[] nums = Arrays.copyOf(origin, origin.length);
		int n = nums.length;
		
		long start = System.currentTimeMillis();
		
		quickSort(nums, 0, n - 1);
		
		long end = System.currentTimeMillis();
		
		return end - start;
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


