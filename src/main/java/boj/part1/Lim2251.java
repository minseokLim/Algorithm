package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Lim2251 {
	private static Set<Integer> set = new HashSet<Integer>();
	private static int[] capacity = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		capacity[0] = Integer.parseInt(st.nextToken());
		capacity[1] = Integer.parseInt(st.nextToken());
		capacity[2] = Integer.parseInt(st.nextToken());
		
		Set<Status> visited = new HashSet<Status>();
		int[] init = {0, 0, capacity[2]};
		dfs(new Status(init), visited);
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		for(int elem : list) {
			sb.append(elem + " ");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(Status status, Set<Status> visited) {
		visited.add(status);		
		int[] water = status.getWater();
		
		if(water[0] == 0) {
			set.add(water[2]);
		}
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(i != j && water[i] != 0 && water[j] < capacity[j]) {
					Status newStatus = status.swapWater(i, j);
					
					if(!visited.contains(newStatus)) {
						dfs(newStatus, visited);
					}
				}
			}
		}
	}

	private static class Status {
		private int[] water;	
		
		public Status(int[] water) {
			this.water = water;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(water);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Status other = (Status) obj;
			if (!Arrays.equals(water, other.water))
				return false;
			return true;
		}

		public int[] getWater() {
			return water;
		}
		
		public Status swapWater(int i, int j) {
			int[] newWater = new int[3];
			System.arraycopy(water, 0, newWater, 0, 3);
			
			if(water[i] + water[j] > capacity[j]) {
				newWater[i] = water[i] + water[j] - capacity[j];
				newWater[j] = capacity[j];
			} else {
				newWater[i] = 0;
				newWater[j] = water[i] + water[j];
			}
			
			return new Status(newWater);
		}
	}
}
