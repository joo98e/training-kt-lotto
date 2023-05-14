import domain.cash.Cash
import domain.cash.Cashier
import domain.lotto.result.LottoResult
import view.InputView
import view.OutputView

fun main() {
    val purchaseLottoAmount = InputView.getPurchaseLottoAmount()

    val cash = Cash(purchaseLottoAmount)
    val gambler = Cashier.purchaseLotto(cash)

    OutputView.printPurchaseHistory(gambler)

    val resultLottoBalls = InputView.getResultLottoBallNums()
    val resultBonusBall = InputView.getResultBonusNumber()

    val lottoResult = LottoResult(gambler.getTickets(), resultLottoBalls, resultBonusBall)

    OutputView.printLottoResult(lottoResult)
    OutputView.printRevenueRate(gambler, lottoResult.wonLotteries)
}