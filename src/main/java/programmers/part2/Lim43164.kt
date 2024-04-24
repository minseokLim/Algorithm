package programmers.part2

class Lim43164 {
    private val answer = mutableListOf<String>()
    private var solved = false

    fun solution(tickets: Array<Array<String>>): Array<String> {
        val ticketMap = mutableMapOf<String, MutableList<Ticket>>()
        tickets.forEach {
            val value = ticketMap[it[0]]
            if (value != null) {
                value.add(Ticket(it[1]))
            } else {
                ticketMap[it[0]] = mutableListOf(Ticket(it[1]))
            }
        }
        ticketMap.values.forEach {
            it.sortBy { it.arrival }
        }

        solve("ICN", ticketMap, mutableListOf<String>(), tickets.size + 1)

        return answer.toTypedArray()
    }

    private fun solve(
        destination: String,
        ticketMap: Map<String, List<Ticket>>,
        temp: MutableList<String>,
        expectedN: Int
    ) {
        if (solved) {
            return
        }

        temp.add(destination)
        if (temp.size == expectedN) {
            solved = true
            answer.addAll(temp)
            return
        }

        ticketMap[destination]?.forEach {
            if (!it.used) {
                it.used = true
                solve(it.arrival, ticketMap, temp.toMutableList(), expectedN)
                it.used = false
            }
        }
    }

    private data class Ticket(
        val arrival: String,
        var used: Boolean = false
    )
}
