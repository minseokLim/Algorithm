package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자료형에 유의해야한다. 
// 랜선의 길이가 2^31 - 1보다 작거나 같은 자연수로 주어지기 때문에, int로 설정해도 될 것 같지만
// 이분탐색은 mid = (left + right) / 2 가 기본이기 때문에
// left와 right 모두 int의 max밸류에 가까워질 경우, 덧셈에서부터 오류가 발생하게 된다.
// 따라서 이분탐색의 연산이 발생하는 left, right, mid의 자료형은 모두 long으로 설정해줘야한다.
// 메모리 최적화를 위해 필요한 것만 long으로 설정하는 것이 가장 좋긴 하지만
// 알고리즘 풀이의 경우, 시간 안에 푸는 것 또한 중요하므로 이런 경우 그냥 모두 long으로 설정해버리는 것도 방법이다.
public class Lim1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());		
		int[] arr = new int[k];
		
		long sum = 0;
		
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		long left = 1;
		long right = sum / n;
		long answer = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			if(checkPossibility(arr, mid, n)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean checkPossibility(int[] arr, long mid, int n) {
		int sum = 0;
		
		for(int elem : arr) {
			sum += elem / mid;
		}
		
		return sum >= n;
	}
}
