package part3;

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
		
		int interval = 1000000;
		
		double aDX = (bX - aX) / interval;
		double aDY = (bY - aY) / interval;
		double cDX = (dX - cX) / interval;
		double cDY = (dY - cY) / interval;
		
		double min = getDistance(aX, aY, cX, cY);
		
		for(int i = 1; i <= interval; i++) {
			double tmp = getDistance(aX + aDX * i, aY + aDY * i, cX + cDX * i, cY + cDY * i);
			
			if(tmp < min) {
				min = tmp;
			}
		}
		
		System.out.println(min);
	}
	
	private static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
