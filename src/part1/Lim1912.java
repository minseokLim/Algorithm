package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// need to be refactored in terms of efficiency
public class Lim1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[n];		
		sum[0] = seq[0];
		
		for(int i = 1; i < n; i++) {
			sum[i] = seq[i] + sum[i - 1];
		}
		
		int max = sum[0];
		
		for(int i = 1; i < n; i++) {
			
			if(max < sum[i]) {
				max = sum[i];
			}
						
			for(int j = 0; j < i; j++) {
				
				if(max < sum[i] - sum[j]) {
					max =  sum[i] - sum[j];
				}
			}
		}
		
		System.out.println(max);
	}
}
