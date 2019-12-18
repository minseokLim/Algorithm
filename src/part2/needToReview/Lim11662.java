package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11662 {
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
		
		int t = 1000_000;
		
		double dx1 = (bX - aX) / t;
		double dy1 = (bY - aY) / t;
		double dx2 = (dX - cX) / t;
		double dy2 = (dY - cY) / t;
		
		double min = Double.MAX_VALUE;
		int lo = 0;
		int hi = t;
		
		while(hi - lo >= 3) {
			int p = (2 * lo + hi) / 3;
			int q = (lo + 2 * hi) / 3;
			
			double distP = getDistance(aX + dx1 * p, aY + dy1 * p, cX + dx2 * p, cY + dy2 * p);
			double distQ = getDistance(aX + dx1 * q, aY + dy1 * q, cX + dx2 * q, cY + dy2 * q);
			
			if(distP < distQ) {
				hi = q;
			} else {
				lo = p;
			}
		}
		
		while(lo <= hi) {
			double distance = getDistance(aX + dx1 * lo, aY + dy1 * lo, cX + dx2 * lo, cY + dy2 * lo);
			
			if(distance < min) {
				min = distance;
			}
			
			lo++;
		}
				
		System.out.println(min);
	}
	
	private static double getDistance(double x1, double y1, double x2, double y2) {
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return distance;
	}
}
