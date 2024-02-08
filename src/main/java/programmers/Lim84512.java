package programmers;

public class Lim84512 {
    int answer = 0;
    boolean solved = false;

    public int solution(String word) {
        final String[] vowels = {"A", "E", "I", "O", "U"};
        for (int i = 0; i < vowels.length; i++) {
            solve(i, "", vowels, word, 1);
        }

        return answer;
    }

    private void solve(int idx, String value, String[] vowels, String word, int depth) {
        if (solved) {
            return;
        }
        answer++;
        final String result = value + vowels[idx];
        if (result.equals(word)) {
            solved = true;
            return;
        }
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            solve(i, result, vowels, word, depth + 1);
        }
    }
}
