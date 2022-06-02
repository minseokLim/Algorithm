package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l, r, x) = br.readLine().split(" ").map { it.toInt() }
    val difficulties = br.readLine().split(" ").map { it.toInt() }
    val picked = BooleanArray(n)
    var answer = 0

    fun dfs(idx: Int, sum: Int, depth: Int) {
        picked[idx] = true
        val localSum = sum + difficulties[idx]

        if (depth > 1 && localSum in l..r) {
            val pickedDifficulties = difficulties.filterIndexed { index, _ -> picked[index] }.sorted()
            if (pickedDifficulties[pickedDifficulties.size - 1] - pickedDifficulties[0] >= x) {
                answer++
            }
        } else if (localSum > r) {
            return
        }

        for (i in idx + 1 until n) {
            dfs(i, localSum, depth + 1)
            picked[i] = false
        }
    }

    for (i in 0 until n) {
        dfs(i, 0, 1)
        picked[i] = false
    }

    println(answer)
}
