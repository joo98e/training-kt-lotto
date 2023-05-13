package view

import domain.gambler.Gambler
import domain.lotto.result.LottoResult
import domain.lotto.enums.LottoWonLotteryEnum
import java.text.DecimalFormat

object OutputView {
    fun printPurchaseHistory(gambler: Gambler) {
        val lottoBundle = gambler.getTickets()
        println("${lottoBundle.tickets.size}개를 구매했습니다.")
        lottoBundle.tickets.forEach { ticket ->
            println("${ticket.lottoBallBundle.getBallNums()}")
        }
        print("\n")
    }

    fun printLottoResult(lottoResult: LottoResult) {
        val lottoWinners = lottoResult.getWonLotteries()

        println("당첨 통계")
        println("--------------------------")
        LottoWonLotteryEnum.values().forEach {
            val countNum: Int = lottoWinners.count { winner -> it == winner }

            println("${it.desc} (${it.prizeMoney}원) - $countNum 개")
        }
    }

    fun printRevenueRate(gambler: Gambler, winners: List<LottoWonLotteryEnum>) {
        var result = 0.0
        winners.forEach { result += it.prizeMoney }
        val earningRate = result / gambler.cash.amount
        val decimalFormat = DecimalFormat("#.##")
        return println("총 수익률은 ${decimalFormat.format(earningRate)} 입니다.")
    }
}