package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1107 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nStr = br.readLine();
		int n = Integer.parseInt(nStr);
		int brokenCNT = Integer.parseInt(br.readLine());
		int curCH = 100;
		int answer;
		int answer1 = Integer.MAX_VALUE;
		int answer2 = Math.abs(n - curCH);
		boolean[] broken = new boolean[10];
		
		if(brokenCNT > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < brokenCNT; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
			
			int initMin = 0;
			int initMax = 1000000;
			
			for(int i = initMin; i <= initMax; i++) {
				
				if(checkPossible(broken, i)) {
					int diff = String.valueOf(i).length() + Math.abs(i - n);
					
					if(diff < answer1) {
						answer1 = diff;
					}
				};				
			}	
		} else {
			answer1 = nStr.length();
		}
		
		// 예를 들면 n이 101인데 망가진 키가 없는(brokenCNT = 0) 경우, 숫자의 길이(3)과 +버튼을 눌럿을 때의 최소횟수(1)의 비교가 필요하다는 것을 간과했다.
		answer = Math.min(answer1, answer2);			
		
		System.out.println(answer);
	}
	
	private static boolean checkPossible(boolean[] broken, int channelNo) {
		String chStr = String.valueOf(channelNo);
		boolean ret = true;
		
		for(int i = 0; i < chStr.length(); i++) {
			
			if(broken[chStr.charAt(i) - 48]) {
				ret = false;
				break;
			}
		}
		
		return ret;
	}
}
