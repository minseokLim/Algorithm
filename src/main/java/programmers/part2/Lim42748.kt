package programmers.part2

class Lim42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.asList().subList(it[0] - 1, it[1]).sorted()[it[2] - 1]
        }.toIntArray()
    }
}
