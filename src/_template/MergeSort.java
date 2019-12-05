package _template;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2751
public class MergeSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergesort(arr, 0, n - 1);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
	}

	private static void mergesort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			
			mergesort(arr, start, mid);
			mergesort(arr, mid + 1, end);
			
			merge(arr, start, end, mid);
		}
	}

	private static void merge(int[] arr, int start, int end, int mid) {
		int[] tmp = new int[end - start + 1];
		
		int i = start;
		int j = mid + 1;
		int k = 0;
		
		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}
		
		while(i <= mid) {
			tmp[k++] = arr[i++];
		}
		
		while(j <= end) {
			tmp[k++] = arr[j++];
		}
		
		System.arraycopy(tmp, 0, arr, start, tmp.length);
	}
}
