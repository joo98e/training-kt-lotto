package view.collector

import common.util.StringUtil
import common.validation.Validation
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.result.LottoResultBallBundle
import domain.lotto.result.LottoResultBonusBall
import view.exception.ReadlineFormatException

object ReadlineCollector {
    fun getInt(message: String? = "숫자를 입력하세요"): Int {
        println(message)
        val inputValue = readln()
        if (Validation.isNotNumeric(inputValue)) throw ReadlineFormatException("숫자 형식이 잘못 되었습니다.")
        return inputValue.toInt()
    }

    fun getListInt(): List<Int> {
        val inputValue = readln()

        val intValues = StringUtil.split(inputValue)
        return intValues.map {
            if (Validation.isNotNumeric(it)) throw ReadlineFormatException("숫자 형식이 잘못 되었습니다.")
            it.toInt()
        }
    }

    fun getCashAmount(): Int {
        println("충전 금액을 입력해 주세요.")
        val amount = readln()

        if (Validation.isNotNumeric(amount)) throw ReadlineFormatException("금액은 숫자여야 합니다.")
        return amount.toInt()
    }

    fun getManualLottoBallBundleList(count: Int): List<LottoBallBundle> {
        val result = mutableListOf<LottoBallBundle>()

        while (result.size < count) {
            println("수동 로또 번호를 입력하세요")
            val inputValue = readln()
            val stringList = StringUtil.split(inputValue)

            val condition = stringList.all { Validation.isNumeric(it) }
            if (!condition) throw ReadlineFormatException("입력 값은 숫자 형식이어야 합니다.")

            result.add(LottoBallBundle(stringList.map { LottoBall(it.toInt()) }))
        }

        return result
    }

    fun getResultLottoBallNums(): LottoResultBallBundle {
        println("지난 주 당첨 번호를 콤마로 분리하여 입력해 주세요.")
        val inputValue = readln()

        val ballNums = StringUtil.split(inputValue)
        return LottoResultBallBundle(LottoBallBundle(ballNums.map { LottoBall(it.toInt()) }))
    }

    fun getResultBonusNumber(): LottoResultBonusBall {
        println("지난 주 보너스 번호를 입력해 주세요.")
        val inputValue = readln()

        if (Validation.isNotNumeric(inputValue)) println("번호는 숫자 형식이어야 합니다. 다시 입력해 주세요.")

        return LottoResultBonusBall(LottoBall(inputValue.toInt()))
    }
}