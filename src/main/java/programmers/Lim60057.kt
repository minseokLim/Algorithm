package programmers

class Lim60057 {
    fun solution(s: String): Int {
        var answer = s.length

        for (i in 1..s.length / 2) {
            val length = compress(s, i)

            if (length < answer) {
                answer = length
            }
        }

        return answer
    }

    private fun compress(s: String, length: Int): Int {
        var before = s.substring(0, length)
        var count = 1
        var result = 0

        for (i in length until s.length step (length)) {
            val after = s.substring(i, (i + length).coerceAtMost(s.length))

            if (after == before) {
                count++
            } else {
                if (count == 1) {
                    result += before.length
                } else {
                    result += (count.length() + before.length)
                    count = 1
                }
                before = after
            }
        }

        result += if (count == 1) {
            before.length
        } else {
            (count.length() + before.length)
        }

        return result
    }

    private fun Int.length(): Int {
        var result = 0
        var tmp = this

        while (tmp != 0) {
            tmp /= 10
            result++
        }
        return result
    }
}
