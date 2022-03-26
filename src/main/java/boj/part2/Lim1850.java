package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1850 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long aLen = Long.parseLong(st.nextToken());
		long bLen = Long.parseLong(st.nextToken());
		
		long gLen = getGcd(aLen, bLen);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < gLen; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
	}

	private static long getGcd(long aLen, long bLen) {
		if(aLen < bLen) {
			return getGcd(bLen, aLen);
		}
		
		if(aLen % bLen == 0) {
			return bLen;
		}
		
		return getGcd(bLen, aLen % bLen);
	}
}
