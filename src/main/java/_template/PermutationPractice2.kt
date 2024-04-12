package _template

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val visited = BooleanArray(input.size)

    for (i in input.indices) {
        permutation(i, input, visited, emptyList(), 3, 1)
        visited[i] = false
    }
}

private fun permutation(
    idx: Int,
    input: IntArray,
    visited: BooleanArray,
    numbers: List<Int>,
    targetCount: Int,
    depth: Int
) {
    visited[idx] = true
    val next = numbers + input[idx]
    if (targetCount == depth) {
        println(next)
        return
    }

    for (i in input.indices) {
        if (visited[i].not()) {
            permutation(i, input, visited, next, targetCount, depth + 1)
            visited[i] = false
        }
    }
}
