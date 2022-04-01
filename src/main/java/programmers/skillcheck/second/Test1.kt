package programmers.skillcheck.second

class Test1 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }

        for (i in arr1.indices) {
            for (j in 0 until arr2[0].size) {
                for (k in 0 until arr1[0].size) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }

        return answer
    }
}
