package boj.part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그리디 문제는... 정말... 어렵다기 보단 짜증난다고 해야하나-_- 푸는데 시간이 너무 오래 걸림
public class Lim2873 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] scores = new int[r][c];
		int min = Integer.MAX_VALUE;
		int[] minIdx = {0, 0};
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < c; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
				
				if(((i + j) & 1) == 1 && scores[i][j] < min) {
					min = scores[i][j];
					minIdx[0] = i;
					minIdx[1] = j;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		if((r & 1) == 1) {
			makeZigZag('R', 'L', 'D', c, r, sb);
			sb.deleteCharAt(sb.length() - 1);
		} else if((c & 1) == 1) {
			makeZigZag('D', 'U', 'R', r, c, sb);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			makeZigZag('R', 'L', 'D', c, minIdx[0] - (minIdx[0] % 2), sb);
			makeZigZag('D', 'U', 'R', 2, minIdx[1], sb);
			
			if((minIdx[1] & 1) == 1) {
				sb.append("R");
				makeZigZag('U', 'D', 'R', 2, c - minIdx[1] - 1, sb);
			} else {
				sb.append("R");
				makeZigZag('D', 'U', 'R', 2, c - minIdx[1] - 1, sb);
			}
			
			sb.deleteCharAt(sb.length() - 1);
			
			int currentR = (minIdx[0] & 1) == 1 ? minIdx[0] : minIdx[0] + 1;
			
			if(currentR < r - 1) {
				sb.append('D');
				makeZigZag('L', 'R', 'D', c, r - currentR - 1, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		
		System.out.println(sb);
	}

	private static void makeZigZag(char char1, char char2, char char3, int width, int height, StringBuffer sb) {
		
		for(int i = 0; i < height; i++) {
			char mark = (i & 1) == 0 ? char1 : char2;
			
			for(int j = 0; j < width - 1; j++) {
				sb.append(mark);
			}
			
			sb.append(char3);
		}
	}
}
