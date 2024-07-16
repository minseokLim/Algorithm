package programmers.part2

class Lim178871 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerToIdx = mutableMapOf<String, Int>()
        players.forEachIndexed { idx, player ->
            playerToIdx[player] = idx
        }

        callings.forEach {
            val playerIdx = playerToIdx[it] ?: throw IllegalStateException()

            players[playerIdx] = players[playerIdx - 1]
            players[playerIdx - 1] = it

            playerToIdx[players[playerIdx]] = playerIdx
            playerToIdx[players[playerIdx - 1]] = playerIdx - 1
        }

        return players
    }
}
