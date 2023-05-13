package domain.cash

import common.exception.ExpectedException

class Cash(var amount: Int) {

    init {
        if (amount <= 0) {
            throw ExpectedException("금액은 양의 정수여야 합니다.")
        }
    }
}