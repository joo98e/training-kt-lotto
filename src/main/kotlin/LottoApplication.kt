import domain.cash.Cashier
import domain.lotto.LottoResult
import view.InputView
import view.OutputView

fun main() {
    val purchaseLottoAmount = InputView.getPurchaseLottoAmount()

    val gambler = Cashier.purchaseLotto(purchaseLottoAmount.toInt())

    OutputView.printPurchaseHistory(gambler)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusWinningNumber = InputView.getBonusNumber()

    val lottoResult = LottoResult(gambler.getTickets(), winningNumbers, bonusWinningNumber)

    OutputView.printLottoResult(lottoResult)
    OutputView.printEarningRate(gambler, lottoResult.getResult())
}