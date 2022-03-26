package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim10845 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<String> queue = new LinkedList<String>();
		String last = null;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			try {			
				if("push".equals(cmd)) {
					last = st.nextToken();
					queue.add(last);
				} else if("pop".equals(cmd)) {
					System.out.println(queue.remove());
				} else if("size".equals(cmd)) {
					System.out.println(queue.size());
				} else if("empty".equals(cmd)) {
					if(queue.isEmpty()) {
						System.out.println("1");
					} else {
						System.out.println("0");
					}
				} else if("front".equals(cmd)) {
					System.out.println(queue.element());
				} else {
					if(queue.isEmpty()) {
						throw new NoSuchElementException();
					} else {
						System.out.println(last);
					}
				}
			} catch (NoSuchElementException e) {
				System.out.println("-1");
			}
		}		
	}
}
