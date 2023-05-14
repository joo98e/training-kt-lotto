package domain.cash

import domain.cash.exception.CashNotPositiveIntegerException

class Cash(var amount: Int) {

    init {
        if (amount <= 0) {
            throw CashNotPositiveIntegerException("금액은 양의 정수여야 합니다.")
        }
    }
}