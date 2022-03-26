package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val planarFigure = Array(6) { BooleanArray(6) }
    val answer = StringJoiner(System.lineSeparator())

    repeat(3) {
        for (i in 0 until 6) {
            val input = br.readLine().split(" ").map { it == "1" }
            for (j in 0 until 6) {
                planarFigure[i][j] = input[j]
            }
        }

        val visited = Array(6) { BooleanArray(6) }

        outer@ for (i in 0 until 6) {
            for (j in 0 until 6) {
                if (planarFigure[i][j]) {
                    if (Cube().solve(i, j, planarFigure, visited)) {
                        answer.add("yes")
                    } else {
                        answer.add("no")
                    }

                    break@outer
                }
            }
        }
    }

    println(answer)
}

// 0 1 2 3 4 5
// BOTTOM TOP FRONT REAR LEFT RIGHT
private class Cube {
    private var statuses = mutableSetOf(CubeStatus.BOTTOM)

    fun solve(
        i: Int,
        j: Int,
        planarFigure: Array<BooleanArray>,
        visited: Array<BooleanArray>
    ): Boolean {
        search(i, j, planarFigure, visited)

        if (statuses.size == 6) {
            return true
        }

        return false
    }

    fun search(
        i: Int,
        j: Int,
        planarFigure: Array<BooleanArray>,
        visited: Array<BooleanArray>
    ) {
        visited[i][j] = true

        val nextActions = NextAction.getNextActions(i, j)

        nextActions.forEach {
            if (it.i in 0 until 6 && it.j in 0 until 6 && planarFigure[it.i][it.j] && visited[it.i][it.j].not()) {
                val beforeSize = statuses.size

                statuses = mutableSetOf(CubeStatus.BOTTOM).apply {
                    this.addAll(statuses.map { status -> it.rotate(status) })
                }

                val afterSize = statuses.size

                if (beforeSize == afterSize) {
                    return
                }

                search(it.i, it.j, planarFigure, visited)
                statuses = statuses.mapTo(mutableSetOf()) { status -> it.rollback(status) }
            }
        }
    }
}

private enum class CubeStatus {
    BOTTOM, TOP, FRONT, REAR, LEFT, RIGHT;

    fun down(): CubeStatus {
        return when (this) {
            BOTTOM -> REAR
            TOP -> FRONT
            FRONT -> BOTTOM
            REAR -> TOP
            LEFT, RIGHT -> this
        }
    }

    fun up(): CubeStatus {
        return when (this) {
            BOTTOM -> FRONT
            TOP -> REAR
            FRONT -> TOP
            REAR -> BOTTOM
            LEFT, RIGHT -> this
        }
    }

    fun right(): CubeStatus {
        return when (this) {
            BOTTOM -> LEFT
            TOP -> RIGHT
            LEFT -> TOP
            RIGHT -> BOTTOM
            FRONT, REAR -> this
        }
    }

    fun left(): CubeStatus {
        return when (this) {
            BOTTOM -> RIGHT
            TOP -> LEFT
            LEFT -> BOTTOM
            RIGHT -> TOP
            FRONT, REAR -> this
        }
    }
}

private class NextAction private constructor(
    val i: Int,
    val j: Int,
    val rotate: (CubeStatus) -> CubeStatus,
    val rollback: (CubeStatus) -> CubeStatus
) {
    companion object {
        fun getNextActions(i: Int, j: Int): List<NextAction> {
            return listOf(
                NextAction(i + 1, j, { status -> status.down() }, { status -> status.up() }),
                NextAction(i - 1, j, { status -> status.up() }, { status -> status.down() }),
                NextAction(i, j + 1, { status -> status.right() }, { status -> status.left() }),
                NextAction(i, j - 1, { status -> status.left() }, { status -> status.right() }),
            )
        }
    }
}
