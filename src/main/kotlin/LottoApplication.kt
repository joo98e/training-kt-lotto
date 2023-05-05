import common.util.StringUtil
import domain.cash.Cash
import domain.cash.Cashier
import domain.lotto.ball.LottoBall
import domain.lotto.result.LottoResult
import domain.lotto.result.LottoResultBallBundle
import domain.lotto.result.LottoResultBonusBall
import view.InputView
import view.OutputView

fun main() {
    val purchaseLottoAmount = InputView.getPurchaseLottoAmount()

    val cash = Cash(purchaseLottoAmount)
    val gambler = Cashier.purchaseLotto(cash)

    OutputView.printPurchaseHistory(gambler)

    val ballNums = StringUtil.split(InputView.getResultLottoBallNums(), ",")
    val resultLottoBalls = LottoResultBallBundle(
        ballNums.map { LottoBall(it) }
    )
    val bonusWinningNumber = LottoResultBonusBall(InputView.getBonusNumber())

    val lottoResult = LottoResult(gambler.getTickets(), resultLottoBalls, bonusWinningNumber)

    OutputView.printLottoResult(lottoResult)
    OutputView.printRevenueRate(gambler, lottoResult.getResult())
}