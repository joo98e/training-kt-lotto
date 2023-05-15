import domain.cash.Cash
import domain.cashier.Cashier
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.result.LottoResult
import view.collector.ReadlineCollector
import view.OutputView

fun main() {
    val purchaseLottoAmount = ReadlineCollector.getPurchaseLottoAmount()
    val manualTicketAmount = ReadlineCollector.getTicketCount(LottoTicketingMode.MANUAL)

    val cash = Cash(purchaseLottoAmount)
    val gambler = Cashier.purchaseLotto(cash, manualTicketAmount)

    OutputView.printPurchaseHistory(gambler)

    val resultLottoBalls = ReadlineCollector.getResultLottoBallNums()
    val resultBonusBall = ReadlineCollector.getResultBonusNumber()

    val lottoResult = LottoResult(gambler.getTickets(), resultLottoBalls, resultBonusBall)

    OutputView.printLottoResult(lottoResult)
    OutputView.printRevenueRate(gambler, lottoResult.wonLotteries)
}