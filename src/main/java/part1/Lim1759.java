package part1;

// https://onsil-thegreenhouse.github.io/programming/algorithm/2018/04/05/permutation_combination/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1759 {
	private static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int L = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());
		String input = br.readLine().replace(" ", "");
		char[] alphabet = input.toCharArray();
		
		// 선택할 alphabet 배열의 idx를 저장할 배열
		int[] combArr = new int[L];
		combination(combArr, C, L, 0, 0, alphabet);
		
		Collections.sort(list);
		
		StringBuffer sb = new StringBuffer();
		
		for(String str : list) {
			sb.append(str + "\n");
		}
		
		System.out.println(sb);
	}

	private static void combination(int[] combArr, int n, int r, int index, int target, char[] alphabet) {
		
		if(r == 0) {
			char[] charArr = new char[combArr.length];
			
			for(int i = 0; i < combArr.length; i++) {
				charArr[i] = alphabet[combArr[i]];
			}
			
			if(validPassword(charArr)) {
				Arrays.sort(charArr);
				list.add(new String(charArr));
			}		
		} else if(target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, alphabet);
			combination(combArr, n, r, index, target + 1, alphabet);
		}
	}
	
	private static boolean validPassword(char[] charArr) {
		int vowel = 0;
		int nonVowel = 0;
		
		for(int i = 0; i < charArr.length; i++) {
			
			if(charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u') {
				vowel++;
			} else {
				nonVowel++;
			}
		}
		
		return vowel >= 1 && nonVowel >= 2;
	}
}
