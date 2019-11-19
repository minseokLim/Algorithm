package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Lim1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		seq[0] = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[n];
		sum[0] = seq[0];
		
		for(int i = 1; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + seq[i];
		}
		
		System.out.println(Arrays.toString(sum));
	}
}
