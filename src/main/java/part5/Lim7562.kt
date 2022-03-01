package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringJoiner

private val transitions = listOf(-1 to 2, -2 to 1, -2 to -1, -1 to -2, 1 to 2, 2 to 1, 2 to -1, 1 to -2)
private lateinit var checked: Array<BooleanArray>
private var maxIdx = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val answer = StringJoiner(System.lineSeparator())

    repeat(t) {
        val l = br.readLine().toInt()
        val (initI, initJ) = br.readLine().split(" ").map { it.toInt() }
        val (destI, destJ) = br.readLine().split(" ").map { it.toInt() }
        checked = Array(l) { BooleanArray(l) }
        maxIdx = l - 1

        val queue = LinkedList<KnightPoint>()
        queue.push(KnightPoint(initI, initJ, 0))
        val dest = KnightPoint(destI, destJ)

        while (true) {
            val knight = queue.poll()
            if (knight == dest) {
                answer.add(knight.count.toString())
                return@repeat
            }

            queue.addAll(knight.getNextPoints())
        }
    }

    println(answer)
}

private class KnightPoint(
    val i: Int,
    val j: Int,
    val count: Int? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KnightPoint

        if (i != other.i) return false
        if (j != other.j) return false

        return true
    }

    override fun hashCode(): Int {
        var result = i
        result = 31 * result + j
        return result
    }

    fun getNextPoints(): List<KnightPoint> {
        return transitions
            .filter { i + it.first in 0..maxIdx && j + it.second in 0..maxIdx && checked[i + it.first][j + it.second].not() }
            .map {
                checked[i + it.first][j + it.second] = true
                KnightPoint(i + it.first, j + it.second, count?.plus(1))
            }
    }
}
