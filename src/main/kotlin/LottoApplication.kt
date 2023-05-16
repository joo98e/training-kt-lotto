import domain.cash.Cash
import domain.cashier.Cashier
import domain.gambler.Gambler
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.result.LottoResult
import view.OutputView
import view.collector.ReadlineCollector

fun main() {
    val purchaseLottoAmount = ReadlineCollector.getCashAmount()
    val cash = Cash(purchaseLottoAmount)
    val gambler = Gambler(cash)

    val autoTicketCount = ReadlineCollector.getInt("자동으로 구매할 로또 티켓의 개수를 입력하세요")
    Cashier.purchaseLottoTickets(LottoTicketingMode.AUTO, gambler, autoTicketCount)

    val manualTicketCount = ReadlineCollector.getInt("수동으로 구매할 로또 티켓의 개수를 입력하세요")
    Cashier.purchaseLottoTickets(LottoTicketingMode.MANUAL, gambler, manualTicketCount)

    OutputView.printPurchaseLottoHistory(gambler)

    val resultLottoBalls = ReadlineCollector.getResultLottoBallNums()
    val resultBonusBall = ReadlineCollector.getResultBonusNumber()

    val lottoResult = LottoResult(gambler.ticketBundle, resultLottoBalls, resultBonusBall)

    val revenueRate = lottoResult.getRevenueRate(gambler.cash.usedAmount)
    OutputView.printLottoResult(lottoResult)
    OutputView.printRevenueRate(revenueRate)
}