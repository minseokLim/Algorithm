package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] max = new int[n];
		max[0] = 1;
		
		for(int i = 1; i < n; i++) {
			max[i] = 1;
			
			for(int j = i - 1; j >= 0; j--) {
				
				if(seq[i] > seq[j] && max[j] + 1 > max[i]) {
					max[i] = max[j] + 1;
				}
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(answer < max[i]) {
				answer = max[i];
			}
		}
		
		System.out.println(answer);
	}
}
