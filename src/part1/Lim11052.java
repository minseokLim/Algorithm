package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] p = new int[n + 1];
		int[] max = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			max[i] = p[i];
			
			for(int j = 1; j <= i / 2; j++) {
				int tmp = max[j] + max[i - j];
				
				if(tmp > max[i]) {
					max[i] = tmp;
				}
			}
		}
		
		System.out.println(max[n]);
	}
}
