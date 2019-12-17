package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] home = new int[n];
		
		for(int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		long left = 1;
		long right = home[n - 1] - 1;
		long answer = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			if(check(home, mid, n, c)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean check(int[] home, long mid, int n, int c) {
		
		int cnt = 1;
		int i = 0;
		
		while(i < n) {
			
			int j = 1;
			
			while(i + j < n) {
				int dist = home[i + j] - home[i];
				
				if(dist >= mid) {
					cnt++;
					break;
				} else {
					j++;
				}
			}
			
			i += j;
		}
		
		return cnt >= c;
	}
}
