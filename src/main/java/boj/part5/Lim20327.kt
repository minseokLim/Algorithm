package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, r) = br.readLine().split(" ").map { it.toInt() }
    val length = 2.power(n)
    var arr: Array<IntArray> = Array(length) { IntArray(length) }

    for (i in 0 until length) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    class PartialArray(
        arr: Array<IntArray>,
        startI: Int,
        startJ: Int,
        private val increment: Int
    ) {
        private val value = Array(increment) { IntArray(increment) }

        init {
            for (x in 0 until increment) {
                for (y in 0 until increment) {
                    value[x][y] = arr[x + startI][y + startJ]
                }
            }
        }

        fun apply(arr: Array<IntArray>, startI: Int, startJ: Int) {
            for (i in 0 until increment) {
                for (j in 0 until increment) {
                    arr[i + startI][j + startJ] = value[i][j]
                }
            }
        }
    }

    class Operation(
        val k: Int,
        val l: Int
    ) {
        private val increment = 2.power(l)

        fun operate(arr: Array<IntArray>): Array<IntArray> {
            return when (k) {
                1 -> operate(arr) { array, i, _, x, y, increment -> array[increment - 1 - x + 2 * i][y] }
                2 -> operate(arr) { array, _, j, x, y, increment -> array[x][increment - 1 - y + 2 * j] }
                3 -> operate(arr) { array, i, j, x, y, increment -> array[increment - 1 - y + j + i][x - i + j] }
                4 -> operate(arr) { array, i, j, x, y, increment -> array[y - j + i][increment - 1 - x + i + j] }
                5, 6, 7, 8 -> operatePartialArray(arr)
                else -> throw IllegalArgumentException()
            }
        }

        private fun operate(
            arr: Array<IntArray>,
            f: (array: Array<IntArray>, i: Int, j: Int, x: Int, y: Int, increment: Int) -> Int
        ): Array<IntArray> {
            val result = Array(length) { IntArray(length) }

            for (i in 0 until length step increment) {
                for (j in 0 until length step increment) {
                    for (x in i until i + increment) {
                        for (y in j until j + increment) {
                            result[x][y] = f(arr, i, j, x, y, increment)
                        }
                    }
                }
            }

            return result
        }

        private fun operatePartialArray(arr: Array<IntArray>): Array<IntArray> {
            val partials = mutableListOf<List<PartialArray>>()

            for (i in 0 until length step increment) {
                val partialRow = mutableListOf<PartialArray>()
                for (j in 0 until length step increment) {
                    partialRow.add(PartialArray(arr, i, j, increment))
                }
                partials.add(partialRow)
            }

            return operatePartials(partials)
        }

        private fun operatePartials(partials: List<List<PartialArray>>): Array<IntArray> {
            val partialSize = partials.size
            val temp = Array(partialSize) { Array<PartialArray?>(partialSize) { null } }

            when (k) {
                5 -> {
                    for (i in 0 until partialSize) {
                        for (j in 0 until partialSize) {
                            temp[i][j] = partials[partialSize - 1 - i][j]
                        }
                    }
                }
                6 -> {
                    for (i in 0 until partialSize) {
                        for (j in 0 until partialSize) {
                            temp[i][j] = partials[i][partialSize - 1 - j]
                        }
                    }
                }
                7 -> {
                    for (i in 0 until partialSize) {
                        for (j in 0 until partialSize) {
                            temp[i][j] = partials[partialSize - 1 - j][i]
                        }
                    }
                }
                8 -> {
                    for (i in 0 until partialSize) {
                        for (j in 0 until partialSize) {
                            temp[i][j] = partials[j][partialSize - 1 - i]
                        }
                    }
                }
            }

            val result = Array(length) { IntArray(length) }

            for (i in 0 until partialSize) {
                for (j in 0 until partialSize) {
                    temp[i][j]!!.apply(result, i * increment, j * increment)
                }
            }

            return result
        }
    }

    val operations = mutableListOf<Operation>()

    for (i in 0 until r) {
        val (k, l) = br.readLine().split(" ").map { it.toInt() }
        operations.add(Operation(k, l))
    }

    operations.forEach {
        arr = it.operate(arr)
    }

    println(arr.joinToString(System.lineSeparator()) { it.joinToString(" ") })
}

private fun Int.power(n: Int): Int {
    var result = 1

    repeat(n) {
        result *= this
    }

    return result
}
