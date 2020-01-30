package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim2225 {
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(combination(20, 1, 1, 0));
	}
	
	private static long combination(int n, int r, int target, int depth) {
		if(depth == r - 1) {
			return 1;
		} else if(target > n) {
			return 0;
		} else {
			long ret = 0;
			ret += combination(n, r, target + 1, depth + 1);
			ret += combination(n, r, target + 1, depth);
			
			return ret;
		}		
	}
}
