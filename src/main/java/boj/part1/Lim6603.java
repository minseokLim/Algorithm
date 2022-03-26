package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim6603 {
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if(k == 0) break;
			
			int[] s = new int[k];
			
			for(int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			int r = 6;
			int[] combArr = new int[r];
			
			combination(combArr, k, r, 0, 0, s);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void combination(int[] combArr, int k, int r, int index, int target, int[] s) {
		
		if(r == 0) {
			
			for(int i = 0; i < combArr.length; i++) {
				sb.append(s[combArr[i]] + " ");
			}
			
			sb.append("\n");
			
		} else if(target == k) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, k, r - 1, index + 1, target + 1, s);
			combination(combArr, k, r, index, target + 1, s);
		}	
	}
}
