package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val nList = (1..t).map { br.readLine().toInt() }
    var max = nList.maxOrNull()!!
    if(max < 3) max = 3
    val counts = LongArray(max + 1)
    counts[1] = 1
    counts[2] = 2
    counts[3] = 4

    for (i in 4..max) {
        counts[i] = (counts[i - 1] + counts[i - 2] + counts[i - 3]) % 1_000_000_009
    }


    println(nList.map { counts[it] }.joinToString("\n"))
}
