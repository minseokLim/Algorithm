package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Lim2251 {
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] capacity = new int[3];
		
		for(int i = 0; i < 3; i++) {
			capacity[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] water = {0, 0, capacity[2]};
		
		Set<Integer> visited = new HashSet<>();
		dfs(water, capacity, visited);
		
		Collections.sort(list);
		
		StringBuffer sb = new StringBuffer();
		
		for(int elem : list) {
			sb.append(elem + " ");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int[] water, int[] capacity, Set<Integer> visited) {
		visited.add(changeToInt(water));
		
		if(water[0] == 0) {
			list.add(water[2]);
		}
		
		for(int i = 0; i < 3; i++) {
			if(water[i] > 0) {
				for(int j = 0; j < 3; j++) {
					if(i != j && water[j] < capacity[j]) {
						int a = water[i];
						int b = water[j];
						
						if(capacity[j] - water[j] > water[i]) {
							water[j] += water[i];
							water[i] = 0;
						} else {
							water[i] -= capacity[j] - water[j];
							water[j] = capacity[j];
						}
						
						if(!visited.contains(changeToInt(water))) {
							dfs(water, capacity, visited);
						}
						
						water[i] = a;
						water[j] = b;
					}
				}
			}
		}
	}
	
	private static int changeToInt(int[] water) {
		return water[0] * 1000000 + water[1] * 1000 + water[2];
	}
}
