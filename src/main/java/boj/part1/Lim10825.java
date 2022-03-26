package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim10825 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Student[] students = new Student[n];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			students[i] = new Student(name, korean, english, math);
		}
		
		Arrays.sort(students);
		Arrays.stream(students).forEach(e -> sb.append(e + "\n"));
		
		System.out.println(sb);
	}
	
	static class Student implements Comparable<Student> {
		private String name;
		private int korean;
		private int english;
		private int math;
		
		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo(Student o) {
			int ret = o.korean - this.korean;
			
			if(ret == 0) {
				ret = this.english - o.english;
			}
			
			if(ret == 0) {
				ret = o.math - this.math;
			}
			
			if(ret == 0) {
				ret = this.name.compareTo(o.name);
			}
			
			return ret;
		}		
	}
}
