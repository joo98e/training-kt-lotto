package view

object InputView {
    fun getPurchaseLottoAmount(): String {
        println("구입 금액을 입력해 주세요.")
        return readln()
    }

    fun getResultLottoBallNums(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumber(): String {
        println("지난 주 보너스 번호를 입력해 주세요.")
        return readln()
    }
}