package programmers.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Lim150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        final var now = Date.of(today);
        final var periods = new HashMap<String, Integer>();
        for (String input : terms) {
            final var inputs = input.split(" ");
            periods.put(inputs[0], Integer.parseInt(inputs[1]));
        }

        final var answer = new ArrayList<Integer>();
        for (int i = 0; i < privacies.length; i++) {
            final var inputs = privacies[i].split(" ");
            final var dueDate = Date.of(inputs[0]).addMonth((periods.get(inputs[1])));
            if (now.compareTo(dueDate) > 0) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private static class Date implements Comparable<Date> {
        private final int year;
        private final int month;
        private final int day;

        private Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public static Date of(String input) {
            final var elements = Arrays.stream(input.split("\\.")).mapToInt(Integer::parseInt).toArray();
            return new Date(elements[0], elements[1], elements[2]);
        }

        public Date addMonth(int month) {
            if (day == 1) {
                final var newYear = this.year + ((this.month + month - 1) - 1) / 12;
                final var newMonth = (this.month + month - 1) % 12 == 0 ? 12 : (this.month + month - 1) % 12;
                final var newDay = 28;

                return new Date(newYear, newMonth, newDay);
            } else {
                final var newYear = this.year + ((this.month + month) - 1) / 12;
                final var newMonth = (this.month + month) % 12 == 0 ? 12 : (this.month + month) % 12;
                final var newDay = this.day - 1;

                return new Date(newYear, newMonth, newDay);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Date date = (Date) o;
            return year == date.year && month == date.month && day == date.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        @Override
        public int compareTo(Date other) {
            if (this.year != other.year) {
                return this.year - other.year;
            }

            if (this.month != other.month) {
                return this.month - other.month;
            }

            return this.day - other.day;
        }
    }
}
