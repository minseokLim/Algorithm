// https://m.blog.naver.com/PostView.nhn?blogId=kks227&logNo=221432986308&proxyReferer=https%3A%2F%2Fwww.google.com%2F

package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aX = Integer.parseInt(st.nextToken());
		int aY = Integer.parseInt(st.nextToken());
		int bX = Integer.parseInt(st.nextToken());
		int bY = Integer.parseInt(st.nextToken());
		int cX = Integer.parseInt(st.nextToken());
		int cY = Integer.parseInt(st.nextToken());
		int dX = Integer.parseInt(st.nextToken());
		int dY = Integer.parseInt(st.nextToken());
		
//		long tolerance = 10_0000_0000;
//		long time = max(abs(aX - bX), abs(cX - dX)) * tolerance;
		long time = 100000000000L;
		
		int a = aX - cX;
		int b = (bX - aX) - (dX - cX);	
		int c = aY - cY;
		int d = (bY - aY) - (dY - cY);
		
		long left = 0;
		long right = time;
		double min = Double.MAX_VALUE;
		
		while(true) {
			long lo = (right + 2 * left) / 3;
			long hi = (2 * right + left) / 3;
			
			double d1 = getDistance(a, b, c, d, time, lo);
			double d2 = getDistance(a, b, c, d, time, hi);
			
			double distance = Math.min(d1, d2);
			
			if(distance < min) {
				min = distance;
			}
			
			if((right - left) <= 2) {
				break;
			}
			
			if(d1 > d2) {
				left = lo;
			} else {
				right = hi;
			}
		}
		
		System.out.println(min);
	}
	
	private static double getDistance(int a, int b, int c, int d, long time, long t) {
		return Math.sqrt(square(a + ((double) (b * t) / time)) + square(c + ((double) (d * t) / time)));
	}
	
	private static double square(double n) {
		return n * n;
	}
	
//	private static int abs(int n) {
//		if(n < 0) {
//			return -n;
//		} else {
//			return n;
//		}
//	}
//	
//	private static int max(int a, int b) {
//		if(a > b) {
//			return a;
//		} else {
//			return b;
//		}
//	}
}
