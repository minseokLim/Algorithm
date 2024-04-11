package programmers.part1;

import java.util.Arrays;

public class Lim1845 {
    public int solution(int[] nums) {
        final int distinctCount = (int) Arrays.stream(nums).distinct().count();
        return Math.min(nums.length / 2, distinctCount);
    }
}
