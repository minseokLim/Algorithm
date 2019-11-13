package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		int max = 0;
		
		for(int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		int[] ans = solve(max);
		
		for(int i = 0; i < t; i++) {
			sb.append(ans[arr[i]] + "\n");
		}
		
		System.out.println(sb);
	}

	private static int[] solve(int n) {
		int[] ans = new int[11];
		
		ans[1] = 1;
		ans[2] = 2;
		ans[3] = 4;
		
		for(int i = 4; i <= n; i++) {
			ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
		}
		
		return ans;
	}
}
