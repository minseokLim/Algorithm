package _template

fun main() {
    val primeNumbers = getPrimeNumbers(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println(primeNumbers.contentToString())
}

private fun getPrimeNumbers(input: IntArray): IntArray {
    val inputMax = input.max()
    val isNotPrime = BooleanArray(inputMax + 1)
    isNotPrime[0] = true
    isNotPrime[1] = true
    for (i in 2..inputMax) {
        if (isNotPrime[i]) {
            continue
        }
        for (j in i * 2..inputMax step i) {
            isNotPrime[j] = true
        }
    }

    return input.filter { !isNotPrime[it] }.toIntArray()
}
