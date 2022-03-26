package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2873 {
	private static int minI;
	private static int minJ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		StringBuffer sb = new StringBuffer();	
		
		if(r % 2 == 1) {
			skipReadLine(br, r);			
			makeSimpleAnswer(r, c, 'R', 'L', 'D', sb);
		} else if(c % 2 == 1) {
			skipReadLine(br, r);
			makeSimpleAnswer(c, r, 'D', 'U', 'R', sb);
		} else {				
			getMinScoreSpot(br, r, c);
			
			int midR = minI % 2 == 0 ? minI : minI - 1;			
			makeZigZag(midR, c, 'R', 'L', 'D', sb);
			
			int midC = minJ;
			
			for(int i = 0; i < midC; i++) {
				
				if(i % 2 == 0) {
					sb.append("DR");
				} else {
					sb.append("UR");
				}
			}
			
			for(int i = midC; i < c - 1; i++) {
				if(i % 2 == 0) {
					sb.append("RD");
				} else {
					sb.append("RU");
				}
			}
			
			sb.append('D');		
			makeZigZag(r - (midR + 2), c, 'L', 'R', 'D', sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		
		System.out.println(sb.toString());
		System.out.println(sb.length());
		checkMemory();
	}

	private static void checkMemory() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Used Memory : " + ((runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)) + "MB");
	}

	private static void getMinScoreSpot(BufferedReader br, int r, int c) throws IOException {
		StringTokenizer st;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < c; j++) {
				int score = Integer.parseInt(st.nextToken());
				
				if((i + j) % 2 == 1 && min > score) {
					min = score;
					minI = i;
					minJ = j;
				}
			}
		}
	}

	private static void skipReadLine(BufferedReader br, int r) throws IOException {
		for(int i = 0; i < r; i++) {
			br.readLine();
		}
	}

	private static void makeSimpleAnswer(int r, int c, char d1, char d2, char p, StringBuffer sb) {
		makeZigZag(r, c, d1, d2, p, sb);	
		sb.deleteCharAt(sb.length() - 1);		
	}

	private static void makeZigZag(int r, int c, char d1, char d2, char p, StringBuffer sb) {
				
		for(int i = 0; i < r; i++) {
			char direction;
			
			if(i % 2 == 0) {
				direction = d1;
			} else {
				direction = d2;
			}
			
			for(int j = 0; j < c - 1; j++) {
				sb.append(direction);
			}
			
			sb.append(p);
		}		
	}
}
