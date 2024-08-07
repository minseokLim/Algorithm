package programmers.part2

class Lim147355 {
    fun solution(t: String, p: String): Int {
        var answer = 0
        val pNumber = p.toLong()
        for (i in 0..t.length - p.length) {
            if (t.substring(i, i + p.length).toLong() <= pNumber) {
                answer++
            }
        }

        return answer
    }
}
