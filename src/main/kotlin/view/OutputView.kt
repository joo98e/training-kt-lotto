package view

import domain.gambler.Gambler
import domain.lotto.LottoResult
import enums.LottoWinner

object OutputView {
    fun printPurchaseHistory(gambler: Gambler) {
        val tickets = gambler.getTickets()
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println("${ticket.nums}")
        }
        print("\n")
    }

    fun printLottoResult(lottoResult: LottoResult) {
        val lottoWinners = lottoResult.getResult()

        println("당첨 통계")
        println("--------------------------")
        LottoWinner.values().forEach {
            val countNum: Int = lottoWinners.count { winner -> it == winner }

            println("${it.desc} (${it.prizeMoney}원) - $countNum 개")
        }
    }

    fun printEarningRate(gambler: Gambler, winners: List<LottoWinner>) {
        var result = 0
        winners.forEach { result += it.prizeMoney }
        val earningRate = result / gambler.getPaidAmount() * 100
        return println("총 수익률은 $earningRate % 입니다.")
    }
}