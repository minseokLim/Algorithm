package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private var m = 0
private lateinit var scores: Array<IntArray>
private var max = Integer.MIN_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val firstInput = br.readLine().split(" ").map { it.toInt() }
    n = firstInput[0]
    m = firstInput[1]
    scores = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until m) {
            scores[i][j] = input[j] - '0'
        }
    }

    for (i in 0 until (1 shl n * m)) {
        var sum = 0


        for (j in 0 until n) {

            var rowSum = 0
            for (k in 0 until m) {
                val idx = j * m + k

                if (i and (1 shl idx) == 0) {
                    rowSum = rowSum * 10 + scores[j][k]
                } else {
                    sum += rowSum
                    rowSum = 0
                }
            }
            sum += rowSum
        }



        for (j in 0 until m) {

            var colSum = 0
            for (k in 0 until n) {
                val idx = k * m + j

                if (i and (1 shl idx) != 0) {
                    colSum = colSum * 10 + scores[k][j]
                } else {
                    sum += colSum
                    colSum = 0
                }
            }
            sum += colSum
        }

        if (max < sum) {
            max = sum
        }
    }

    println(max)
}
