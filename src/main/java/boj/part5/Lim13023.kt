package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var found = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val relationGroups = mutableMapOf<Int, MutableSet<Int>>()
    val checked = BooleanArray(n)

    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }

        if (relationGroups.containsKey(i)) {
            relationGroups[i]?.add(j)
        } else {
            relationGroups[i] = mutableSetOf(j)
        }

        if (relationGroups.containsKey(j)) {
            relationGroups[j]?.add(i)
        } else {
            relationGroups[j] = mutableSetOf(i)
        }
    }

    relationGroups.toSortedMap().forEach {
        solve(it.key, relationGroups, checked, 1)
        checked[it.key] = false
    }

    if (found) {
        println(1)
    } else {
        println(0)
    }
}

private fun solve(key: Int, relationGroups: Map<Int, Set<Int>>, checked: BooleanArray, count: Int) {
    if (found) {
        return
    }
    if (count == 5) {
        found = true
        return
    }

    checked[key] = true

    relationGroups[key]?.forEach {
        if (checked[it].not()) {
            solve(it, relationGroups, checked, count + 1)
            checked[it] = false
        }
    }
}
