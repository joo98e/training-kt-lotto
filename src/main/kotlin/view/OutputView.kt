package view

import domain.gambler.Gambler
import domain.lotto.result.LottoResult
import domain.lotto.enums.LottoWonLotteryEnum
import java.text.DecimalFormat

object OutputView {
    fun printPurchaseHistory(gambler: Gambler) {
        val lottoBundle = gambler.ticketBundle
        println("${lottoBundle.tickets.size}개를 구매했습니다.")
        lottoBundle.tickets.forEach { ticket ->
            println("${ticket.lottoBallBundle.getBallNums()}")
        }
        print("\n")
    }

    fun printLottoResult(lottoResult: LottoResult) {
        val lottoWinners = lottoResult.wonLotteries

        println("당첨 통계")
        println("--------------------------")
        LottoWonLotteryEnum.values().forEach {
            val countNum: Int = lottoWinners.count { winner -> it == winner }

            println("${it.desc} (${it.prizeMoney}원) - $countNum 개")
        }
    }

    fun printRevenueRate(revenueRate: String) {
        println("총 수익률은 $revenueRate 입니다.")
    }
}