package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lim1744 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> minusZeroList = new ArrayList<Integer>();
		List<Integer> plusExceptOneList = new ArrayList<Integer>();
		long answer = 0;
		
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp > 1) {
				plusExceptOneList.add(tmp);
				// 이 문제에서는 이 부분이 포인트. 
				// 양수는 일반적으로는 서로 곱하는게 더 값이 커지지만
				// 1의 경우, 1 * 3 < 1 + 3
			} else if(tmp == 1) {
				answer++;
			} else {
				minusZeroList.add(tmp);
			}
		}
		
		Collections.sort(minusZeroList);
		Collections.sort(plusExceptOneList, Comparator.reverseOrder());
		
		
		Queue<Integer> queue = new LinkedList<>(minusZeroList);	
		answer = solve(queue, answer);
		
		queue = new LinkedList<Integer>(plusExceptOneList);	
		answer = solve(queue, answer);
		
		System.out.println(answer);
	}

	private static long solve(Queue<Integer> queue, long answer) {
		
		while(queue.size() > 1) {
			answer += queue.poll() * queue.poll();
		}
		
		if(!queue.isEmpty()) {
			answer += queue.poll();
		}
		
		return answer;
	}
}
