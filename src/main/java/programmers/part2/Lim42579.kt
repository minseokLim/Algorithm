package programmers.part2

class Lim42579 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val playCountMap = mutableMapOf<String, Int>()
        val songs = mutableListOf<Song>()
        for (i in genres.indices) {
            playCountMap[genres[i]] = playCountMap.getOrDefault(genres[i], 0) + plays[i]
            songs.add(Song(genres[i], plays[i], i))
        }

        return songs.groupBy { it.genre }.entries.sortedByDescending { playCountMap[it.key] }
            .flatMap {
                it.value.sortedWith(
                    Comparator.comparingInt(Song::playCount).reversed().thenComparingInt(Song::idx)
                ).take(2)
            }
            .map { it.idx }
            .toIntArray()
    }

    data class Song(
        val genre: String,
        val playCount: Int,
        val idx: Int,
    )
}
