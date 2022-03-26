package boj.part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1107 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int curCH = 100;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		boolean allBroken = m == 10 ? true : false;
		
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < m; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		if(allBroken) {
			System.out.println(abs(n - curCH));
		} else {
			int targetHigh = -1;
			int temp = n;
			
			// 모든 버튼이 망가지지 않았을 때는 무조건 targetHigh가 존재할 것 같으나, 0번만 남아있는 경우에는 targetHigh가 존재할 수 없다.
			// 따라서 상한선을 반드시 지정해야하는데, targetHigh가 100_0000보다 커질 경우, 무조건 +, - 버튼을 이용한 이동이 더 적은 횟수로 이동할 것이므로 여기까지 상한을 둔다.
			while(temp < 100_0000) {
				if(checkPossible(temp, broken)) {
					targetHigh = temp;
					break;
				}
				
				temp++;
			}
			
			int targetLow = -1;
			temp = n;
			
			while(temp >= 0) {
				if(checkPossible(temp, broken)) {
					targetLow = temp;
					break;
				}
				
				temp--;
			}
			
			int cands1 = targetHigh == -1 ? Integer.MAX_VALUE : String.valueOf(targetHigh).length() + abs(targetHigh - n);
			int cands2 = targetLow == -1 ? Integer.MAX_VALUE : String.valueOf(targetLow).length() + abs(targetLow - n);
			int cands3 = abs(n - curCH);
			
			System.out.println(Math.min(Math.min(cands1, cands2), cands3));
		}
	}
	
	private static boolean checkPossible(int temp, boolean[] broken) {
		if(temp == 0) {
			return !broken[0];
		}
		
		while(temp > 0) {
			int k = temp % 10;
			
			if(broken[k]) {
				return false;
			}
			
			temp /= 10;
		}
		
		return true;
	}

	private static int abs(int n) {
		if(n > 0) {
			return n;
		} else {
			return -n;
		}
	}
}
