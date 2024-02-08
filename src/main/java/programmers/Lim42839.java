package programmers;

import java.util.HashSet;
import java.util.Set;

public class Lim42839 {
    final boolean[] isNotPrime = new boolean[10000000];
    final Set<Integer> primes = new HashSet<>();

    public int solution(String numbers) {
        computePrime();
        final boolean[] visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            solve(i, "", numbers, visited);
            visited[i] = false;
        }

        return primes.size();
    }

    private void computePrime() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        final int max = (int) Math.sqrt(10000000);
        for (int i = 2; i < max; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i + i; j < 10000000; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    private void solve(int idx, String value, String numbers, boolean[] visited) {
        visited[idx] = true;

        final String result = value + numbers.charAt(idx);
        final int output = Integer.parseInt(result);
        if (!isNotPrime[output]) {
            primes.add(output);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                solve(i, result, numbers, visited);
                visited[i] = false;
            }
        }
    }
}
