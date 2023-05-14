package domain.cash

import domain.cashier.exception.CashierMoneyException
import domain.cashier.Cashier
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CashierTest {

    @Test
    fun `Cashier 에게 구매를 하면 Gambler 가 리턴되며 소비한 금액과 티켓 개수를 포함한다`() {
        val paidAmountCase1 = 14000
        val cash = Cash(paidAmountCase1)
        val gambler = Cashier.purchaseLotto(cash)
        gambler.cash.amount shouldBe paidAmountCase1
        gambler.getTickets().tickets.size shouldBe cash.amount / Cashier.PRICE_LOTTO
    }

    @Test
    fun `Cashier 에게 1개도 구매하지 못하는 금액을 인자로 보내면 예외가 발생한다`() {
        val paidAmountCase1 = 900

        val expectedException = shouldThrow<CashierMoneyException> {
            Cashier.purchaseLotto(Cash(paidAmountCase1))
        }

        expectedException.message shouldBe "[ERROR]: 금액은 천원 단위로 사용 가능합니다."
    }

    @Test
    fun `Cashier 에게 1000원 단위가 아닌 금액을 인자로 보내면 예외가 발생한다`() {
        val paidAmountCase1 = 9900

        val expectedException = shouldThrow<CashierMoneyException> {
            Cashier.purchaseLotto(Cash(paidAmountCase1))
        }

        expectedException.message shouldBe "[ERROR]: 금액은 천원 단위로 사용 가능합니다."
    }
}