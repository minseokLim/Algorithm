package programmers.part2

class Lim42895 {
    fun solution(N: Int, number: Int): Int {
        val dp = Array(9) { mutableSetOf<Int>() }
        for (i in 1 until 9) {
            dp[i].add(N.toString().repeat(i).toInt())
        }

        for (i in 2 until 9) {
            for (j in 1..i / 2) {
                for (x in dp[i - j]) {
                    for (y in dp[j]) {
                        dp[i].add(x + y)
                        dp[i].add(x - y)
                        dp[i].add(y - x)
                        dp[i].add(x * y)
                        if (y != 0) {
                            dp[i].add(x / y)
                        }
                    }
                }
            }
        }

        for (i in 1 until 9) {
            for (x in dp[i]) {
                if (x == number) {
                    return i
                }
            }
        }

        return -1
    }
}
