package boj.part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int two = get(n, 2) - get(n - m, 2) - get(m, 2);
		int five = get(n, 5) - get(n - m, 5) - get(m, 5);
		
		System.out.println(Math.min(two, five));
	}
	
	// 예를 들어 생각해보면, 59! = 59 * 58 * 57 .... * 2 * 1 여기에서 5의 배수의 개수는 59 / 5 = 11이다.
	// 즉, 55, 50, 45, 40, ..... 5, 1 의 개수가 11개라는 건데, 이 수들 중에서 5를 중복으로 가지고 있는 애들도 있을 것이다. 걔네들의 개수를 구하는 방법은
	// 모든 수를 5로 나누면 11, 10, 9, 8, .... 1 에서 5의 배수의 개수를 구하는 건데, 결국 11 / 5 = 2가 된다.
	// 이런 식으로 n 팩토리얼에 있는 5의 개수를 구할 수 있게 된다.
	
	// n 팩토리얼에 있는 k의 갯수를 구하는 함수
	private static int get(int n, int k) {
		int cnt = 0;
		
		while(n > 0) {
			cnt += n / k;
			n /= k;
		}
		
		return cnt;
	}
}
