package programmers.part2

class Lim42578 {
    fun solution(clothes: Array<Array<String>>): Int {
        val closet = clothes.groupBy({ it[1] }) { it[0] }
        var answer = 1;

        closet.forEach {
            answer *= (it.value.size + 1)
        }

        return answer - 1
    }
}
