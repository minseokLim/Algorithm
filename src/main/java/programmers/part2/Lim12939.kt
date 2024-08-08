package programmers.part2

class Lim12939 {
    fun solution(s: String): String {
        val sorted = s.split(" ").map { it.toInt() }.sorted()
        return "${sorted.first()} ${sorted.last()}"
    }
}
