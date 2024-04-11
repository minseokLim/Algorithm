package programmers.part1

import kotlin.math.ceil

class Lim77486 {
    private class Seller(
        val name: String,
        val parent: Seller?,
        var money: Int = 0
    ) {
        fun addMoney(income: Int) {
            if (parent == null) {
                money += ceil(income * 0.9).toInt()
            } else {
                val mine = ceil(income * 0.9).toInt()
                money += mine
                parent.addMoney(income - mine)
            }
        }
    }

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val sellers = mutableMapOf<String, Seller>()

        enroll.forEachIndexed { i, name ->
            val parentName = referral[i]
            val parent =
                if (parentName != "-") {
                    sellers[parentName]
                } else {
                    null
                }
            sellers[name] = Seller(name, parent)
        }

        seller.forEachIndexed { i, name ->
            val member = sellers[name]
            val income = amount[i] * 100
            member!!.addMoney(income)
        }

        return enroll.map { sellers[it]!!.money }.toIntArray()
    }
}
