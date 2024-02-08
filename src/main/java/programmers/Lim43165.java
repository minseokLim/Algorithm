package programmers;

public class Lim43165 {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        solve(0, true, 0, numbers, target);
        solve(0, false, 0, numbers, target);

        return answer;
    }

    private void solve(int idx, boolean positive, int sum, int[] numbers, int target) {
        int result = 0;
        if (positive) {
            result = sum + numbers[idx];
        } else {
            result = sum - numbers[idx];
        }

        if (idx == numbers.length - 1) {
            if (result == target) {
                answer++;
            }
            return;
        }

        solve(idx + 1, true, result, numbers, target);
        solve(idx + 1, false, result, numbers, target);
    }
}
