package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim1644 {
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				list.add(i);
			}
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			try {
				if(sum < n) {
					sum += list.get(right++);
				} else {
					if(sum == n) {
						cnt++;
					}
					
					sum -= list.get(left++);
				}
			} catch (IndexOutOfBoundsException e) {
				break;
			}		
		}
		
		System.out.println(cnt);
	}

	private static boolean isPrime(int x) {
		boolean ret = true;
		
		for(int elem : list) {
			if(elem * elem > x) {
				break;
			}
			
			if(x % elem == 0) {
				ret = false;
				break;
			}
		}
		
		return ret;
	}
}
