package programmers.part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lim42577 {
    public boolean solution(String[] phone_book) {
        final List<String> phones = Arrays.stream(phone_book)
            .sorted()
            .collect(Collectors.toList());

        for (int i = 0; i < phones.size() - 1; i++) {
            if (phones.get(i + 1).startsWith(phones.get(i))) {
                return false;
            }
        }

        return true;
    }
}
