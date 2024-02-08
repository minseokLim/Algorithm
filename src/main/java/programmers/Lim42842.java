package programmers;

public class Lim42842 {
    public int[] solution(int brown, int yellow) {
        final int sum = brown / 2 + 2;
        for (int i = 3; i <= sum - 3; i++) {
            if ((i - 2) * (sum - i - 2) == yellow) {
                return new int[]{sum - i, i};
            }
        }

        return new int[]{1, 1};
    }
}
