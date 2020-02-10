package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/source/6668735 이분탐색??

public class _Lim11053_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		int[] partSeq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			partSeq[i] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(partSeq[j] == -1 || partSeq[j] >= seq[i]) {
					partSeq[j] = seq[i];
					break;
				}
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			if(partSeq[i] != -1) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
