package domain.lotto


class LottoTicket {
    var nums: List<Int> = emptyList()
    var bonusNum: Int? = null

    init {
        val (resultNums, resultBonusNum) = LottoMachine.execute()
        this.nums = resultNums
        this.bonusNum = resultBonusNum
    }
}