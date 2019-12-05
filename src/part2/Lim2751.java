package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2751 {
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
		
		if(i <= mid) {
			System.arraycopy(arr, i, tmp, k, mid - i + 1);
		} else {
			System.arraycopy(arr, j, tmp, k, end - j + 1);
		}
		
		System.arraycopy(tmp, 0, arr, start, tmp.length);
	}
}
