package programmers.part2;

import java.util.Arrays;

public class Lim1845 {
    public int solution(int[] nums) {
        return (int) Math.min(nums.length / 2, Arrays.stream(nums).distinct().count());
    }
}
