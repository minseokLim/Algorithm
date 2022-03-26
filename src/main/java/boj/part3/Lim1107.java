package boj.part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1107 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] broken = new boolean[10];
			
			for(int i = 0; i < m; i++) { 
				broken[Integer.parseInt(st.nextToken())] = true;
			}
			
			List<Integer> candidates = new ArrayList<Integer>();
			candidates.add(Math.abs(n - 100));
			
			int upperNo = getUpperNo(n, broken);
			int lowerNo = getLowerNo(n, broken);
			
			if(upperNo != -1) {
				candidates.add(String.valueOf(upperNo).length() + upperNo - n);
			}
			
			if(lowerNo != -1) {
				candidates.add(String.valueOf(lowerNo).length() + n - lowerNo);
			}
			
			Collections.sort(candidates);
			
			System.out.println(candidates.get(0));
		} else {
			System.out.println(Math.min(Math.abs(n - 100), String.valueOf(n).length()));
		}	
	}
	
	private static int getUpperNo(int n, boolean[] broken) {
		boolean allBrokenExceptZero = true;
		
		for(int i = 1; i < 10; i++) {
			if(!broken[i]) {
				allBrokenExceptZero = false;
				break;
			}
		}
		
		if(allBrokenExceptZero) {
			return -1;
		}
		
		while(n < 1000_000) {
			
			if(isPossible(n, broken)) {
				return n;
			}
			
			n++;
		}
		
		return -1;
	}
	
	private static int getLowerNo(int n, boolean[] broken) {
		boolean allBroken = true;
		
		for(int i = 0; i < 10; i++) {
			if(!broken[i]) {
				allBroken = false;
				break;
			}
		}
		
		if(allBroken) {
			return -1;
		}
		
		while(n >= 0) {
			
			if(isPossible(n, broken)) {
				return n;
			}
			
			n--;
		}
		
		return -1;
	}
	
	private static boolean isPossible(int n, boolean[] broken) {
		if(n == 0) {
			return !broken[0];
		}
		
		while(n > 0) {
			int tmp = n % 10;
			n /= 10;
			
			if(broken[tmp]) {
				return false;
			}
		}
		
		return true;
	}
}
