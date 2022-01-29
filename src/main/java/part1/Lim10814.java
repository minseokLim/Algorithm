package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim10814 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		User[] users = new User[n];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());			
			users[i] = new User(age, st.nextToken(), i);
		}
		
		Arrays.sort(users);
		Arrays.stream(users).forEach(e -> sb.append(e + "\n"));
		
		System.out.println(sb);
	}
	
	static class User implements Comparable<User> {
		private int age;
		private String name;
		private int idx;
		
		
		public User(int age, String name, int idx) {
			this.age = age;
			this.name = name;
			this.idx = idx;
		}

		
		@Override
		public String toString() {
			return age + " " + name ;
		}

		@Override
		public int compareTo(User o) {
			int ret = this.age - o.age;
			
			if(ret != 0) {
				return ret;
			} else {
				return this.idx - o.idx;
			}
		}
		
	}
}
