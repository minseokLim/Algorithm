package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이것도 통과하긴 하였으나 삼분탐색으로 풀어봅시다.
public class _Lim11662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double aX = Double.parseDouble(st.nextToken());
		double aY = Double.parseDouble(st.nextToken());
		double bX = Double.parseDouble(st.nextToken());
		double bY = Double.parseDouble(st.nextToken());
		double cX = Double.parseDouble(st.nextToken());
		double cY = Double.parseDouble(st.nextToken());
		double dX = Double.parseDouble(st.nextToken());
		double dY = Double.parseDouble(st.nextToken());
		
//		long t = (long) (Math.abs(aX - bX) * 1000_000);
		int t = 1000_000;
		
		double dx1 = (bX - aX) / t;
		double dy1 = (bY - aY) / t;
		double dx2 = (dX - cX) / t;
		double dy2 = (dY - cY) / t;
		
		double min = getDistance(aX, aY, cX, cY);
		
		for(int i = 1; i <= t; i++) {
			double distance = getDistance(aX + dx1 * i, aY + dy1 * i, cX + dx2 * i, cY + dy2 * i);
			
			if(min > distance) {
				min = distance;
			}
		}
		
		System.out.println(min);
	}
	
	private static double getDistance(double x1, double y1, double x2, double y2) {
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return distance;
	}
}
