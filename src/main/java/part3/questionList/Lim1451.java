package part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어렵다기보단, 집중해서 풀어야하는 문제... 좀 짜증나는 문제라고나 할까
public class Lim1451 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				matrix[i][j] = input[j] - '0';
			}
		}
		
		long max = Long.MIN_VALUE;
		
		for(int i = 0; i <= m - 3; i++) {
			long a = sum(matrix, 0, 0, n - 1, i);
			
			for(int j = i + 1; j <= m - 2; j++) {
				long b = sum(matrix, 0, i + 1, n - 1, j);
				long c = sum(matrix, 0, j + 1, n - 1, m - 1);
				
				long tmp = a * b * c;
				
				if(max < tmp) {
					max = tmp;
				}
			}	
		}
		
		for(int i = 0; i <= m - 2; i++) {
			long a = sum(matrix, 0, 0, n - 1, i);
			
			for(int j = 0; j <= n - 2; j++) {
				long b = sum(matrix, 0, i + 1, j, m - 1);
				long c = sum(matrix, j + 1, i + 1, n - 1, m - 1);
				
				long tmp = a * b * c;
				
				if(max < tmp) {
					max = tmp;
				}
			}
			
			a = sum(matrix, 0, m - 1 - i, n - 1, m - 1);
			
			for(int j = 0; j <= n - 2; j++) {
				long b = sum(matrix, 0, 0, j, m - 2 - i);
				long c = sum(matrix, j + 1, 0, n - 1, m - 2 - i);
				
				long tmp = a * b * c;
				
				if(max < tmp) {
					max = tmp;
				}
			}	
		}
		
		for(int i = 0; i <= n - 3; i++) {
			long a = sum(matrix, 0, 0, i, m - 1);
			
			for(int j = i + 1; j <= n - 2; j++) {
				long b = sum(matrix, i + 1, 0, j, m - 1);
				long c = sum(matrix, j + 1, 0, n - 1, m - 1);
				
				long tmp = a * b * c;
				
				if(max < tmp) {
					max = tmp;
				}
			}
		}
		
		for(int i = 0; i <= n - 2; i++) {
			long a = sum(matrix, 0, 0, i, m - 1);
			
			for(int j = 0; j <= m - 2; j++) {
				long b = sum(matrix, i + 1, 0, n - 1, j);
				long c = sum(matrix, i + 1, j + 1, n - 1, m - 1);
				
				long tmp = a * b * c;
				
				if(max < tmp) {
					max = tmp;
				}
			}
			
			a = sum(matrix, n - 1 - i, 0, n - 1, m - 1);
			
			for(int j = 0; j <= m - 2; j++) {
				long b = sum(matrix, 0, 0, n - 2 - i, j);
				long c = sum(matrix, 0, j + 1, n - 2 - i, m - 1);
				
				long tmp = a * b * c;
				
				if(max < tmp) {
					max = tmp;
				}
			}
		}
		
		System.out.println(max);
	}

	private static long sum(int[][] matrix, int sI, int sJ, int eI, int eJ) {
		long sum = 0;
		
		for(int i = sI; i <= eI; i++) {
			for(int j = sJ; j <= eJ; j++) {
				sum += matrix[i][j];
			}
		}
		
		return sum;
	}	
}
