import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val arr = IntArray(10000).map { -1 }.toIntArray()
    var left = 0
    var right = 0

    val sb = StringBuilder()

    while(n-- > 0) {
        val command = br.readLine().split(" ")

        when(command[0]) {
            "push" -> arr[right++] = command[1].toInt()
            "pop" ->
                if (left < right) {
                    sb.append(arr[left]).append("\n")
                    arr[left++] = -1
                } else {
                    sb.append(-1).append("\n")
                }
            "size" -> sb.append(right - left).append("\n")
            "empty" -> if (right - left == 0) sb.append(1).append("\n") else sb.append(0).append("\n")
            "front" -> sb.append(arr[left]).append("\n")
            "back" ->
                if (right > 0) sb.append(arr[right - 1]).append("\n") else sb.append(-1).append("\n")
        }
    }

    println(sb)
}
