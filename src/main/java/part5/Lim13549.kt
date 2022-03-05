package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val visited = BooleanArray(200_001)

fun main() {
    class Subin(
        val position: Int,
        val time: Int
    ) {
        init {
            visited[position] = true
        }

        fun getNextMoves(): List<Subin> {
            val result = mutableListOf<Subin>()

            setAllDoubles(result)
            setForward(result)
            setBackward(result)

            return result
        }

        private fun setAllDoubles(result: MutableList<Subin>) {
            var subin = this

            while (true) {
                val double = subin.getDouble()

                if (double.isPresent) {
                    subin = double.get()
                    result.add(subin)
                } else {
                    break
                }
            }
        }

        private fun getDouble(): Optional<Subin> {
            if (position * 2 <= 200_000 && visited[position * 2].not()) {
                return Optional.of(Subin(position * 2, time))
            }
            return Optional.empty()
        }

        private fun setForward(result: MutableList<Subin>) {
            if (position + 1 <= 200_000 && visited[position + 1].not()) {
                result.add(Subin(position + 1, time + 1))
            }
        }

        private fun setBackward(result: MutableList<Subin>) {
            if (position - 1 >= 0 && visited[position - 1].not()) {
                result.add(Subin(position - 1, time + 1))
            }
        }
    }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val queue = LinkedList<Subin>()
    queue.offer(Subin(n, 0))

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.position == k) {
            println(polled.time)
            break
        }

        queue.addAll(polled.getNextMoves())
    }
}
