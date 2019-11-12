package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lim1744 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> positives = new ArrayList<Integer>();
		List<Integer> nonPositives = new ArrayList<Integer>();
		long answer = 0;
		
		for(int i = 0; i < n; i++) {
			int elem = Integer.parseInt(br.readLine());
			
			if(elem > 1) {
				// 1보다 큰수들을 모은다
				positives.add(elem);
			} else if(elem == 1) {
				// 1의 경우 두 수로 묶지 않는 편이 더 낫다. 예 ) 1 + 3 > 1 * 3
				answer++;
			} else {
				// 0보다 작거나 같은 수들을 모은다.
				nonPositives.add(elem);
			}
		}
		
		// 절대값 기준으로 큰 수부터 묶기 위해 정렬을 시행한다.
		positives.sort(Comparator.reverseOrder());
		nonPositives.sort(Comparator.naturalOrder());
		
		int positiveSize = positives.size();
		
		for(int i = 0; i + 1 < positiveSize; i += 2) {
			answer += positives.get(i) * positives.get(i + 1);
		}
		
		if(positiveSize % 2 == 1) {
			answer += positives.get(positiveSize - 1); 
		}
		
		int nonPosSize = nonPositives.size();
		
		for(int i = 0; i + 1 < nonPosSize; i += 2) {
			answer += nonPositives.get(i) * nonPositives.get(i + 1);
		}
		
		if(nonPosSize % 2 == 1) {
			answer += nonPositives.get(nonPosSize - 1); 
		}
		
		System.out.println(answer);
	}
}
