package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2875 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int wTeam = n / 2;
		int max;
		
		if(wTeam >= m) {
			k -= ((wTeam - m) * 2 + n % 2);
			max = m;
		} else {
			k -= ((m - wTeam) + n % 2);
			max = wTeam;
		}
		
		while(k > 0) {
			k -= 3;
			max--;
		}
		
		System.out.println(max);
	}
}
