package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Lim10866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<String> deque = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			try {
				if("push_front".equals(cmd)) {
					deque.addFirst(st.nextToken());
				} else if("push_back".equals(cmd)) {
					deque.addLast(st.nextToken());
				} else if("pop_front".equals(cmd)) {
					System.out.println(deque.removeFirst());
				} else if("pop_back".equals(cmd)) {
					System.out.println(deque.removeLast());
				} else if("size".equals(cmd)) {
					System.out.println(deque.size());
				} else if("empty".equals(cmd)) {
					System.out.println(deque.isEmpty() ? 1 : 0);
				} else if("front".equals(cmd)) {
					System.out.println(deque.getFirst());
				} else {
					System.out.println(deque.getLast());
				}
			} catch (NoSuchElementException e) {
				System.out.println("-1");
			}
			
		}
	}
}
