package domain.cash

import common.exception.ExpectedException
import common.validation.Validation

class Cash {
    var amount: Int

    constructor(amount: String) {
        if (Validation.isNotNumeric(amount)) {
            throw ExpectedException("금액을 정확히 입력해 주세요. 금액은 숫자여야 합니다.")
        }
        if (Validation.isNonPositiveNumeric(amount)) {
            throw ExpectedException("금액은 양의 정수여야 합니다.")
        }
        this.amount = amount.toInt()
    }

    constructor(amount: Int) {
        if (amount <= 0) {
            throw ExpectedException("금액은 양의 정수여야 합니다.")
        }
        this.amount = amount
    }
}