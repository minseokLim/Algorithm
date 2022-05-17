package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    val map = mutableListOf<List<Space>>()
    val visited = Array(m) { BooleanArray(n) }
    val roomNumbers = Array(m) { IntArray(n) }
    val roomSizes = mutableListOf<Int>()

    repeat(m) {
        map.add(br.readLine().split(" ").map { Space(it.toInt()) })
    }

    val queue: Queue<Tracer> = LinkedList()
    var roomCount = 0
    var maxSize = 0
    var roomNumber = 0

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                queue.offer(Tracer(i, j))
                visited[i][j] = true

                var size = 0
                while (queue.isNotEmpty()) {
                    val polled = queue.poll()
                    roomNumbers[polled.i][polled.j] = roomNumber
                    size++
                    polled.setQueue(queue, map, visited)
                }

                roomSizes.add(size)
                roomCount++
                roomNumber++

                if (maxSize < size) {
                    maxSize = size
                }
            }
        }
    }

    val roomVisited = BooleanArray(roomSizes.size)
    var maxBrokenSize = 0

    fun dfs(i: Int, j: Int, initialRoomNumber: Int, visited: Array<BooleanArray>) {
        visited[i][j] = true

        directions.forEach {
            val nextI = i + it.first
            val nextJ = j + it.second

            if (nextI in 0 until m && nextJ in 0 until n && !visited[nextI][nextJ]) {
                if (initialRoomNumber == roomNumbers[nextI][nextJ]) {
                    dfs(nextI, nextJ, initialRoomNumber, visited)
                } else if (roomSizes[initialRoomNumber] + roomSizes[roomNumbers[nextI][nextJ]] > maxBrokenSize) {
                    maxBrokenSize = roomSizes[initialRoomNumber] + roomSizes[roomNumbers[nextI][nextJ]]
                }
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!roomVisited[roomNumbers[i][j]]) {
                roomVisited[roomNumbers[i][j]] = true
                val visited2 = Array(m) { BooleanArray(n) }
                dfs(i, j, roomNumbers[i][j], visited2)
            }
        }
    }

    println(roomCount)
    println(maxSize)
    println(maxBrokenSize)
}

private val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

private class Space(
    input: Int
) {
    val walls = BooleanArray(4)

    init {
        walls[0] = input.and(1) != 0
        walls[1] = input.and(2) != 0
        walls[2] = input.and(4) != 0
        walls[3] = input.and(8) != 0
    }
}

private class Tracer(
    val i: Int,
    val j: Int
) {
    fun setQueue(queue: Queue<Tracer>, map: List<List<Space>>, visited: Array<BooleanArray>) {
        directions.forEachIndexed { idx, direction ->
            val nextI = i + direction.first
            val nextJ = j + direction.second

            if (nextI in 0 until m && nextJ in 0 until n && !visited[nextI][nextJ] && !map[nextI][nextJ].walls[idx]) {
                visited[nextI][nextJ] = true
                queue.offer(Tracer(nextI, nextJ))
            }
        }
    }
}
