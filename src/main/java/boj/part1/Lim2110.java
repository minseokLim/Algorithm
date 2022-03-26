package boj.part1;

// https://meylady.tistory.com/13
	
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
		
		int wholeDistance = home[n - 1] - home[0];
		int max = wholeDistance / (c - 1);
				
		int left = 1;
		int right = max;
		int answer = 0;
		
		while(left <= right) {
			int a = 0;
			int b = 1;
			int cnt = 1;
			int mid = (left + right) / 2;
			
			while(b < n) {
				int sum = home[b] - home[a];
				
				if(sum >= mid) {
					a = b;
					b++;
					cnt++;
				} else {
					b++;
				}
			}
			
			if(cnt < c) {
				right = mid - 1;
			} else {
				answer = mid;			
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
