package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1759 {
	private static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	private static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[] cands = br.readLine().replaceAll("\\s", "").toCharArray();
		Arrays.sort(cands);
		int[] chosen = new int[l];
		
		combination(cands, c, l, chosen, 0, 0);
		
		Collections.sort(list);
		
		StringBuffer sb = new StringBuffer();
		
		for(String str : list) {
			sb.append(str + "\n");
		}
		
		System.out.println(sb);
	}

	private static void combination(char[] cands, int n, int r, int[] chosen, int target, int depth) {
		if(depth == r) {
			StringBuffer sb = new StringBuffer();
			int vowelCnt = 0;
			
			for(int i = 0; i < r; i++) {
				sb.append(cands[chosen[i]]);
				
				if(isVowel(cands[chosen[i]])) {
					vowelCnt++;
				}
			}
			
			if(vowelCnt >= 1 && r - vowelCnt >= 2) {
				list.add(sb.toString());
			}
		} else if(target < n) {
			chosen[depth] = target;
			combination(cands, n, r, chosen, target + 1, depth + 1);
			combination(cands, n, r, chosen, target + 1, depth);
		}	
	}
	
	private static boolean isVowel(char c) {
		
		for(int i = 0; i < 5; i++) {
			if(vowels[i] == c) {
				return true;
			}
		}
		
		return false;
	}
}
