package programmers.part2

class Lim12951 {
    fun solution(s: String): String {
        var answer = ""
        if (s[0] in 'a'..'z') {
            answer += s[0].uppercase()
        } else {
            answer += s[0]
        }
        for (i in 1 until s.length) {
            if (s[i - 1] == ' ' && s[i] in 'a'..'z') {
                answer += s[i].uppercase()
            } else if (s[i - 1] != ' ' && s[i] in 'A'..'Z') {
                answer += s[i].lowercase()
            } else {
                answer += s[i]
            }
        }

        return answer
    }
}
