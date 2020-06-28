package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] seq = new int[n];
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int sum = seq[0];
		int left = 0;
		int right = 0;
		
		while(right < n) {
			if(sum >= s) {
				int len = right - left + 1;
				
				if(len < min) {
					min = len;
				}
				
				if(left < right) {
					sum -= seq[left++];
				} else {
					break;
				}
			} else {
				if(right + 1 < n) {
					sum += seq[++right];
				} else {
					break;
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}
}
