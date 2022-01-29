package part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] seq = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int min = 0;
		
		while(right <= n) {
			if(sum < s) {
				sum += seq[right++];
			} else {
				int length = right - left;
				
				if(min == 0 || length < min) {
					min = length;
				}
				
				sum -= seq[left++];
			}
		}
		
		System.out.println(min);
	}
}
