package domain.cash

import common.exception.ExpectedException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CashierTest {

    @Test
    fun `Cashier 에게 구매를 하면 Gambler 가 리턴되며 소비한 금액과 티켓 개수를 포함한다`() {
        val paidAmountCase1 = 14_000
        val gambler = Cashier.purchase(paidAmountCase1)
        gambler.getPaidAmount() shouldBe paidAmountCase1
        gambler.getTickets().size shouldBe paidAmountCase1 / Cashier.PRICE_LOTTO
    }

    @Test
    fun `Cashier 에게 1개도 구매하지 못하는 금액을 인자로 보내면 예외가 발생한다`() {
        val paidAmountCase1 = 900

        val expectedException = shouldThrow<ExpectedException> {
            Cashier.purchase(paidAmountCase1)
        }

        expectedException.message shouldBe "[ERROR]: 금액은 천원 단위로 사용 가능합니다."
    }

    @Test
    fun `Cashier 에게 1000원 단위가 아닌 금액을 인자로 보내면 예외가 발생한다`() {
        val paidAmountCase1 = 9900

        val expectedException = shouldThrow<ExpectedException> {
            Cashier.purchase(paidAmountCase1)
        }

        expectedException.message shouldBe "[ERROR]: 금액은 천원 단위로 사용 가능합니다."
    }
}