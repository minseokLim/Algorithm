package part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] wires = new int[k];
		long sum = 0;
		
		for(int i = 0; i < k; i++) {
			wires[i] = Integer.parseInt(br.readLine());
			sum += wires[i];
		}
		
		long answer = 1;
		long left = 1;
		long right = sum / n;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = checkPossibleLineNo(wires, mid, k);
			
			if(cnt >= n) {
				left = mid + 1;
				
				if(mid > answer) {
					answer = mid;
				}
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

	private static int checkPossibleLineNo(int[] wires, long mid, int k) {
		int cnt = 0;
		
		for(int i = 0; i < k; i++) {
			cnt += wires[i] / mid;
		}
		
		return cnt;
	}
}
