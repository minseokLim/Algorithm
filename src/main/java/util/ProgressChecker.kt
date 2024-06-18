package util

import java.io.File

class ProgressChecker(
    private val currentDirectory: String,
    private val targetFileName: String
) {
    fun check() {
        val solvedProblemNumbers = extractSolvedProblemNumbers()
        println("푼 문제 수 : ${solvedProblemNumbers.size}")

        val targetProblemNumbers = File("$currentDirectory/$targetFileName").readLines().mapNotNull { it.toIntOrNull() }
        val unsolvedProblems = targetProblemNumbers - solvedProblemNumbers.toSet()
        println("안 푼 문제 수 : ${unsolvedProblems.size}")
        println("안 푼 문제 번호 : $unsolvedProblems")
    }

    private fun extractSolvedProblemNumbers(): List<Int> {
        return File(currentDirectory).listFiles()
            ?.map { it.name }
            ?.filter { it.startsWith("Lim") }
            ?.mapNotNull { "\\d+".toRegex().find(it)?.value?.toInt() }
            ?: emptyList()
    }

    private fun String.toIntOrNull(): Int? {
        return try {
            toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
}
