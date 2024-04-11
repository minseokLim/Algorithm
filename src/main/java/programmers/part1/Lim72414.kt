package programmers.part1

class Lim72414 {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        if (play_time == adv_time) {
            return "00:00:00"
        }

        val playTimeSeconds = play_time.toSeconds()
        val advTimeSeconds = adv_time.toSeconds()

        val times = IntArray(playTimeSeconds)
        logs.forEach {
            val arr = it.split("-")
            val start = arr[0].toSeconds()
            val end = arr[1].toSeconds()

            for (i in start until end) {
                times[i]++
            }
        }

        val sums = LongArray(playTimeSeconds + 1)
        var sum = 0L
        for (i in times.indices) {
            sum += times[i]
            sums[i + 1] = sum
        }

        var max = 0L
        var maxI = 0
        for (i in 0..times.size - advTimeSeconds) {
            val timeSum = sums[i + advTimeSeconds] - sums[i]
            if (timeSum > max) {
                max = timeSum
                maxI = i
            }
        }

        return maxI.toTimeString()
    }

    private fun String.toSeconds(): Int {
        val arr = this.split(":")
        return arr[0].toInt() * 3600 + arr[1].toInt() * 60 + arr[2].toInt()
    }

    private fun Int.toTimeString(): String {
        var tmp = this

        val hour = (tmp / 3600).toString().padStart(2, '0')
        tmp %= 3600

        val minute = (tmp / 60).toString().padStart(2, '0')
        tmp %= 60

        val second = tmp.toString().padStart(2, '0')

        return "$hour:$minute:$second"
    }
}
