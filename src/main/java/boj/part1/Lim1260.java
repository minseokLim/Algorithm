package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Lim1260 {
	
	static boolean[] visitRec;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static StringBuffer dfs = new StringBuffer();
	static StringBuffer bfs = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int nDot = Integer.parseInt(inputs[0]);
		int nLine = Integer.parseInt(inputs[1]);
		int start = Integer.parseInt(inputs[2]);
		
		int[][] matrix = new int[nDot + 1][nDot + 1];
		
		for(int i = 0; i < nLine; i++) {
			String[] lineInfo = br.readLine().split(" ");
			int x = Integer.parseInt(lineInfo[0]);
			int y = Integer.parseInt(lineInfo[1]);
			
			if(x != y) {
				matrix[x][y] = 1;
				matrix[y][x] = 1;
			}		
		}
		
		visitRec = new boolean[nDot + 1];
		dfsMethod(matrix, start);
		
		visitRec = new boolean[nDot + 1];
		visitRec[start] = true;
		queue.add(start);
		bfs.append(start + " ");
		bfsMethod(matrix);
		
		System.out.println(dfs);
		System.out.println(bfs);
	}
	
	private static void dfsMethod(int[][] matrix, int start) {
		dfs.append(start + " ");
		visitRec[start] = true;
				
		for(int i = 1; i < matrix[start].length; i++) {
			
			if(visitRec[i] == false && matrix[start][i] == 1) {
				dfsMethod(matrix, i);
			}
		}
	}
	
	private static void bfsMethod(int[][] matrix) {
				
		while(!queue.isEmpty()) {
			
			int start = queue.poll();
			
			for(int i = 1; i < matrix[start].length; i++) {
				
				if(visitRec[i] == false && matrix[start][i] == 1) {
					visitRec[i] = true;
					queue.add(i);
					bfs.append(i + " ");
				}
			}
		}
		
	}
}
