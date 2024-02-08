package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lim42577 {
    public boolean solution(String[] phone_book) {
        if (phone_book.length == 1) {
            return true;
        }

        final List<String> sortedPhones = Arrays.stream(phone_book)
            .sorted()
            .collect(Collectors.toList());

        for (int i = 0; i < sortedPhones.size() - 1; i++) {
            if (sortedPhones.get(i + 1).startsWith(sortedPhones.get(i))) {
                return false;
            }
        }

        return true;
    }
}
