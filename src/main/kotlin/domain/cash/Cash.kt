package domain.cash

import domain.cash.exception.CashNotPositiveIntegerException
import domain.cash.exception.CashOverConsumptionException

class Cash(var amount: Int, usedAmount: Int = 0) {
    var usedAmount: Int
        private set

    init {
        if (amount <= 0) {
            throw CashNotPositiveIntegerException("금액은 양의 정수여야 합니다.")
        }

        this.usedAmount = usedAmount
    }

    fun use(willUseAmount: Int) {
        if (willUseAmount > this.amount) throw CashOverConsumptionException("잔액보다 사용 금액이 높습니다.")
        this.amount = this.amount - willUseAmount
        this.usedAmount += willUseAmount
    }
}