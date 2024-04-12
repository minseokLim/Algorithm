package _template

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val visited = BooleanArray(input.size)

    for (i in input.indices) {
        permutation(i, input, visited, emptyList())
        visited[i] = false
    }
}

private fun permutation(idx: Int, input: IntArray, visited: BooleanArray, numbers: List<Int>) {
    visited[idx] = true
    val next = numbers + input[idx]
    if (next.size == input.size) {
        println(next)
    }

    for (i in input.indices) {
        if (visited[i].not()) {
            permutation(i, input, visited, next)
            visited[i] = false
        }
    }
}
