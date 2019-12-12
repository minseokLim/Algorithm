package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1991 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] leftArr = new int[26];
		int[] rightArr = new int[26];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 65;
			int left = st.nextToken().charAt(0) - 65;
			int right = st.nextToken().charAt(0) - 65;
			leftArr[root] = left;
			rightArr[root] = right;
		}
		
		StringBuffer sb = new StringBuffer();
		
		method1(leftArr, rightArr, 0, sb);
		sb.append("\n");
		method2(leftArr, rightArr, 0, sb);
		sb.append("\n");
		method3(leftArr, rightArr, 0, sb);
		
		System.out.println(sb);
	}

	private static void method1(int[] leftArr, int[] rightArr, int root, StringBuffer sb) {
		sb.append((char) (root + 65));
		
		if(leftArr[root] > 0) {
			method1(leftArr, rightArr, leftArr[root], sb);
		}
		
		if(rightArr[root] > 0) {
			method1(leftArr, rightArr, rightArr[root], sb);
		}
	}
	
	private static void method2(int[] leftArr, int[] rightArr, int root, StringBuffer sb) {
		if(leftArr[root] > 0) {
			method2(leftArr, rightArr, leftArr[root], sb);
		}
		
		sb.append((char) (root + 65));
		
		if(rightArr[root] > 0) {
			method2(leftArr, rightArr, rightArr[root], sb);
		}
	}
	
	private static void method3(int[] leftArr, int[] rightArr, int root, StringBuffer sb) {
		if(leftArr[root] > 0) {
			method3(leftArr, rightArr, leftArr[root], sb);
		}
		
		if(rightArr[root] > 0) {
			method3(leftArr, rightArr, rightArr[root], sb);
		}
		
		sb.append((char) (root + 65));
	}
}
