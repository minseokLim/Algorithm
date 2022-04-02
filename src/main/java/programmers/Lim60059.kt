package programmers

import java.lang.Integer.max
import java.lang.Integer.min

class Lim60059 {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        if (match(key, lock)) {
            return true
        }

        var rotatedKey = key

        repeat(3) {
            rotatedKey = rotate(rotatedKey)

            if (match(rotatedKey, lock)) {
                return true
            }
        }

        return false
    }

    private fun match(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        for (x in -(key.size - 1) until lock.size) {
            for (y in -(key.size - 1) until lock.size) {
                var result = true
                val checked = Array(lock.size) { BooleanArray(lock.size) }
                outer@ for (i in max(0, -x) until min(lock.size - x, key.size)) {
                    for (j in max(0, -y) until min(lock.size - y, key.size)) {
                        if (key[i][j].xor(lock[i + x][j + y]) != 1) {
                            result = false
                            break@outer
                        }
                        checked[i + x][j + y] = true
                    }
                }
                if (result) {
                    var finalResult = true

                    outer@ for (i in lock.indices) {
                        for (j in lock.indices) {
                            if (lock[i][j] == 0 && checked[i][j].not()) {
                                finalResult = false
                                break@outer
                            }
                        }
                    }

                    if (finalResult) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun rotate(key: Array<IntArray>): Array<IntArray> {
        val result = Array(key.size) { IntArray(key.size) }

        for (i in key.indices) {
            for (j in key.indices) {
                result[i][j] = key[j][key.size - i - 1]
            }
        }
        return result
    }
}
