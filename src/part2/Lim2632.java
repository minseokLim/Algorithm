package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2632 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int want = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] pizzaA = new int[m];
		int[] pizzaB = new int[n];
		
		for(int i = 0; i < m; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < n; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
		}
		
		int[] subSetA = new int[m * (m - 1) + 2];
		int[] subSetB = new int[n * (n - 1) + 2];
		
		getSubSet(pizzaA, m, subSetA);
		getSubSet(pizzaB, n, subSetB);
		
		Arrays.sort(subSetA);
		Arrays.sort(subSetB);
		
		int left = 0;
		int right = subSetB.length - 1;
		int cnt = 0;
		
		while(left < subSetA.length && right >= 0) {
			int leftVal = subSetA[left];
			int rightVal = subSetB[right];
			int temp = leftVal + rightVal;
			
			if(temp < want) {
				while(++left < subSetA.length && subSetA[left] == leftVal) {
					
				}
			} else if(temp > want) {
				while(--right >= 0 && subSetB[right] == rightVal) {
					
				}
			} else {
				int leftCnt = 1;
				int rightCnt = 1;
				
				while(++left < subSetA.length && subSetA[left] == leftVal) {
					leftCnt++;
				}
				
				while(--right >= 0 && subSetB[right] == rightVal) {
					rightCnt++;
				}
				
				cnt += leftCnt * rightCnt;
			}
		}
		
		System.out.println(cnt);
	}

	private static void getSubSet(int[] pizzaA, int m, int[] subSetA) {
		subSetA[0] = 0;
		int index = 1;
		
		for(int i = 0; i < m; i++) {
			int sum = 0;
			int k = i;
			
			for(int j = 0; j < m - 1; j++) {
				sum += pizzaA[k];
				subSetA[index++] = sum;
				
				k++;
				
				if(k == m) {
					k = 0;
				}
			}
		}
		
		int totSum = 0;
		
		for(int i = 0; i < m; i++) {
			totSum += pizzaA[i];
		}
		
		subSetA[index] = totSum;
	}
}
