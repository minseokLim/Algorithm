package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lim2776 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        final StringBuilder result = new StringBuilder();
        for(int i = 0; i < T; i++) {
            br.readLine();
            final int[] memo1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
            br.readLine();
            final int[] memo2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int number : memo2) {
                if (binarySearch(memo1, number)) {
                    result.append(1).append("\n");
                } else {
                    result.append(0).append("\n");
                }
            }
        }
        System.out.println(result);
    }

    private static boolean binarySearch(int[] memo, int target) {
        int left = 0;
        int right = memo.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (memo[mid] == target) {
                return true;
            } else if (memo[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
