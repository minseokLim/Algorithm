package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Lim4375 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringJoiner result = new StringJoiner(System.lineSeparator());

        String input;
        while ((input = br.readLine()) != null) {
            final int n = Integer.parseInt(input);
            result.add(String.valueOf(computeAnswer(n)));
        }

        System.out.println(result);
    }

    private static int computeAnswer(int n) {
        int mod = 1;
        int count = 1;

        while ((mod = mod % n) != 0) {
            mod = mod * 10 + 1;
            count++;
        }

        return count;
    }
}
