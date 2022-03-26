package programmers

class Lim77485 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val matrix = Array(rows + 1) { IntArray(columns + 1) }
        var number = 1

        for (i in 1..rows) {
            for (j in 1..columns) {
                matrix[i][j] = number++
            }
        }

        return queries.map { rotate(matrix, it) }.toIntArray()
    }

    fun rotate(matrix: Array<IntArray>, query: IntArray): Int {
        val i1 = query[0]
        val j1 = query[1]
        val i2 = query[2]
        val j2 = query[3]

        val tmp = matrix[i1][j1]
        var min = tmp

        for (i in i1 until i2) {
            matrix[i][j1] = matrix[i + 1][j1]

            if (matrix[i][j1] < min) {
                min = matrix[i][j1]
            }
        }

        for (j in j1 until j2) {
            matrix[i2][j] = matrix[i2][j + 1]

            if (matrix[i2][j] < min) {
                min = matrix[i2][j]
            }
        }

        for (i in i2 downTo i1 + 1) {
            matrix[i][j2] = matrix[i - 1][j2]

            if (matrix[i][j2] < min) {
                min = matrix[i][j2]
            }
        }

        for (j in j2 downTo j1 + 2) {
            matrix[i1][j] = matrix[i1][j - 1]

            if (matrix[i1][j] < min) {
                min = matrix[i1][j]
            }
        }

        matrix[i1][j1 + 1] = tmp
        return min
    }
}
