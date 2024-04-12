package _template

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    for (i in input.indices) {
        combination(i, input, emptyList(), 3, 1)
    }
}

private fun combination(idx: Int, input: IntArray, numbers: List<Int>, targetCount: Int, depth: Int) {
    val next = numbers + input[idx]
    if (targetCount == depth) {
        println(next)
        return
    }

    for (i in idx + 1 until input.size) {
        combination(i, input, next, targetCount, depth + 1)
    }
}
