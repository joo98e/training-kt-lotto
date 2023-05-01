package view

import domain.lotto.LottoResult
import enums.LottoWinner

object OutputView {
    fun printLottoResult(lottoResult: LottoResult) {
        val lottoWinners = lottoResult.getResult()

        println("당첨 통계")
        println("--------------------------")
        LottoWinner.values().forEach {
            val countNum: Int = lottoWinners.count { winner -> it == winner }

            println("${it.desc} (${it.prizeMoney}원) - $countNum 개")
        }
    }
}