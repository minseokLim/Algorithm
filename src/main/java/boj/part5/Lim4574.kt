package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private const val PUZZLE_PREFIX = "Puzzle "
private val answer = StringJoiner(System.lineSeparator())
private var gameSequence = 1
private var solved = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val n = br.readLine().toInt()

        if (n == 0) {
            break
        }

        solved = false
        val dominoUsed = Array(10) { BooleanArray(10) }
        val puzzle = readPuzzle(br, n, dominoUsed)
        val zeroPositions = puzzle.getZeroPositions()

        solve(0, zeroPositions, puzzle, dominoUsed)

        gameSequence++
    }

    println(answer)
}

private fun solve(
    zeroPositionIdx: Int,
    zeroPositions: List<Pair<Int, Int>>,
    puzzle: Array<IntArray>,
    dominoUsed: Array<BooleanArray>
) {
    if (solved) {
        return
    }

    if (zeroPositionIdx == zeroPositions.size) {
        answer.add(puzzle.toAnswer(gameSequence))
        solved = true
        return
    }

    val zeroIdx = zeroPositions[zeroPositionIdx]

    if (puzzle[zeroIdx.first][zeroIdx.second] != 0) {
        solve(zeroPositionIdx + 1, zeroPositions, puzzle, dominoUsed)
    } else {
        val unoccupiedNumbers = getUnoccupiedNumbers(zeroIdx.first, zeroIdx.second, puzzle)

        setDomino(
            zeroPositionIdx,
            zeroIdx.first,
            zeroIdx.second,
            zeroIdx.first + 1,
            zeroIdx.second,
            zeroPositions,
            unoccupiedNumbers,
            puzzle,
            dominoUsed
        )

        setDomino(
            zeroPositionIdx,
            zeroIdx.first,
            zeroIdx.second,
            zeroIdx.first,
            zeroIdx.second + 1,
            zeroPositions,
            unoccupiedNumbers,
            puzzle,
            dominoUsed
        )
    }
}

private fun setDomino(
    zeroPositionIdx: Int,
    thisI: Int,
    thisJ: Int,
    nextI: Int,
    nextJ: Int,
    zeroPositions: List<Pair<Int, Int>>,
    unoccupiedNumbers: List<Int>,
    puzzle: Array<IntArray>,
    dominoUsed: Array<BooleanArray>
) {
    if (nextI < 9 && nextJ < 9 && puzzle[nextI][nextJ] == 0) {
        val nextUnoccupiedNumbers = getUnoccupiedNumbers(nextI, nextJ, puzzle)
        unoccupiedNumbers.forEach { x ->
            nextUnoccupiedNumbers.forEach { y ->
                if (x != y && dominoUsed[x][y].not()) {
                    puzzle[thisI][thisJ] = x
                    puzzle[nextI][nextJ] = y
                    dominoUsed[x][y] = true
                    dominoUsed[y][x] = true

                    solve(zeroPositionIdx + 1, zeroPositions, puzzle, dominoUsed)

                    puzzle[thisI][thisJ] = 0
                    puzzle[nextI][nextJ] = 0
                    dominoUsed[x][y] = false
                    dominoUsed[y][x] = false
                }
            }
        }
    }
}

private fun readPuzzle(br: BufferedReader, n: Int, dominoUsed: Array<BooleanArray>): Array<IntArray> {
    val puzzle = Array(9) { IntArray(9) }

    for (i in 0 until n) {
        val input = br.readLine().split(" ")

        val a = input[0].toInt()
        val firstIdx = input[1].toIdx()
        puzzle[firstIdx.first][firstIdx.second] = a

        val b = input[2].toInt()
        val secondIdx = input[3].toIdx()
        puzzle[secondIdx.first][secondIdx.second] = b

        dominoUsed[a][b] = true
        dominoUsed[b][a] = true
    }

    val input = br.readLine().split(" ")
    for (i in 0 until 9) {
        val idx = input[i].toIdx()
        puzzle[idx.first][idx.second] = i + 1
    }

    return puzzle
}

private fun String.toIdx(): Pair<Int, Int> = this[0] - 'A' to this[1] - '1'

private fun Array<IntArray>.getZeroPositions(): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until this.size) {
        for (j in 0 until this[0].size) {
            if (this[i][j] == 0) {
                result.add(i to j)
            }
        }
    }

    return result
}

private fun getUnoccupiedNumbers(iIdx: Int, jIdx: Int, puzzle: Array<IntArray>): List<Int> {
    val startI = iIdx / 3 * 3
    val startJ = jIdx / 3 * 3
    val endI = startI + 2
    val endJ = startJ + 2

    val occupied = BooleanArray(9 + 1)

    for (i in startI..endI) {
        for (j in startJ..endJ) {
            occupied[puzzle[i][j]] = true
        }
    }

    for (k in 0 until 9) {
        occupied[puzzle[iIdx][k]] = true
        occupied[puzzle[k][jIdx]] = true
    }

    return (1..9).filter { occupied[it].not() }
}

private fun Array<IntArray>.toAnswer(gameSequence: Int): String {
    return PUZZLE_PREFIX + gameSequence + System.lineSeparator() +
            this.joinToString(System.lineSeparator()) { it.joinToString("") }
}
