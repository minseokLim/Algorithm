package part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val wheels = Array(t) { BooleanArray(8) }

    for (i in 0 until t) {
        val input = br.readLine()
        for (j in 0 until 8) {
            wheels[i][j] = input[j] == '1'
        }
    }

    val k = br.readLine().toInt()

    repeat(k) {
        val (idx, direction) = br.readLine().split(" ").map { it.toInt() }
        val realIdx = idx - 1
        val rotation = mutableListOf(realIdx to direction)
        rights(wheels, realIdx, direction, t, rotation)
        lefts(wheels, realIdx, direction, t, rotation)

        rotation.forEach {
            rotate(wheels[it.first], it.second)
        }
    }


    println(wheels.count { it[0] })
}

private fun lefts(
    wheels: Array<BooleanArray>,
    idx: Int,
    direction: Int,
    t: Int,
    rotation: MutableList<Pair<Int, Int>>
) {
    if (idx - 1 < 0) {
        return
    }

    if (wheels[idx][6].xor(wheels[idx - 1][2])) {
        rotation.add(idx - 1 to direction * -1)
        lefts(wheels, idx - 1, direction * -1, t, rotation)
    }
}

private fun rights(
    wheels: Array<BooleanArray>,
    idx: Int,
    direction: Int,
    t: Int,
    rotation: MutableList<Pair<Int, Int>>
) {
    if (idx + 1 >= t) {
        return
    }

    if (wheels[idx][2].xor(wheels[idx + 1][6])) {
        rotation.add(idx + 1 to direction * -1)
        rights(wheels, idx + 1, direction * -1, t, rotation)
    }
}

private fun rotate(wheel: BooleanArray, direction: Int) {
    when (direction) {
        1 -> clockwise(wheel)
        -1 -> counterClockwise(wheel)
    }
}

private fun clockwise(wheel: BooleanArray) {
    val tmp = wheel[7]

    for (i in 7 downTo 1) {
        wheel[i] = wheel[i - 1]
    }

    wheel[0] = tmp
}

private fun counterClockwise(wheel: BooleanArray) {
    val tmp = wheel[0]

    for (i in 0 until 7) {
        wheel[i] = wheel[i + 1]
    }

    wheel[7] = tmp
}
