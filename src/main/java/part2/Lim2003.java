package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// use two pointer!!
public class Lim2003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] seq = new int[n + 1];	
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		
		while(right <= n) {
			if(sum < m) {
				sum += seq[right++];
			} else {
				if(sum == m) {
					cnt++;
				}
				
				sum -= seq[left++];
			}
		}
		
		System.out.println(cnt);
	}
}
