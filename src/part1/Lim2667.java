package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lim2667 {
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		List<Integer> answer = new ArrayList<Integer>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				if(map[i][j] == '1') {
					answer.add(search(map, i, j));
				}
			}
		}
		
		sb.append(answer.size() + "\n");
		answer.sort(Comparator.naturalOrder());

		for(int x : answer) {
			sb.append(x + "\n");
		}
		
		System.out.println(sb);
	}

	private static int search(char[][] map, int i, int j) {
		int cnt = 1;
		map[i][j] = '0';
		
		if(j + 1 < n && map[i][j + 1] == '1') {
			cnt += search(map, i, j + 1);
		}
		
		if(i + 1 < n && map[i + 1][j] == '1') {
			cnt += search(map, i + 1, j);
		}
		
		if(j - 1 >= 0 && map[i][j - 1] == '1') {
			cnt += search(map, i, j - 1);
		}
		
		if(i - 1 >= 0 && map[i - 1][j] == '1') {
			cnt += search(map, i - 1, j);
		}
		
		return cnt;
	}
}