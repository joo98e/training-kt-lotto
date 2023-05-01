package domain.lotto

import common.exception.ExpectedException
import enums.LottoWinner
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {
    private lateinit var lottoTickets: List<LottoTicket>

    @BeforeEach
    fun setup() {
        lottoTickets = List(10) { LottoTicket() }
    }

    @Test
    fun `지난 주 당첨 번호와 보너스 번호를 받을 때 겹치는 번호가 있는지 확인한다`() {
        val inputWinningNumCase1 = listOf(1, 2, 3, 4, 5, 6)
        val inputBonusNumCase1 = 6


        val exception = shouldThrow<ExpectedException> {
            LottoResult(lottoTickets, inputWinningNumCase1, inputBonusNumCase1)
        }

        exception.message shouldBe "[ERROR]: 당첨 번호에 보너스 번호가 포함될 수 없습니다."
    }

    @Test
    fun `당첨 번호의 길이가 모자랄 경우 (6이어야 함)`() {
        val winningNumsLength5 = listOf(1, 2, 3, 4, 5)
        val bonusNum = 6

        val exception = shouldThrow<ExpectedException> {
            LottoResult(lottoTickets, winningNumsLength5, bonusNum)
        }

        exception.message shouldBe "[ERROR]: 당첨 번호의 size 는 6이어야 합니다."
    }

    @Test
    fun `당첨 번호의 길이가 알맞음`() {
        val winningNumsLength6 = listOf(1, 2, 3, 4, 5, 6)
        val bonusNum = 7

        val exception = shouldNotThrow<ExpectedException> {
            LottoResult(lottoTickets, winningNumsLength6, bonusNum)
        }
    }

    @Test
    fun `당첨 번호의 길이가 넘을 경우 (6이어야 함)`() {
        val winningNumsLength7 = listOf(1, 2, 3, 4, 5, 6, 7)
        val bonusNum = 8

        val exception = shouldThrow<ExpectedException> {
            LottoResult(lottoTickets, winningNumsLength7, bonusNum)
        }

        exception.message shouldBe "[ERROR]: 당첨 번호의 size 는 6이어야 합니다."
    }


    @Test
    fun `당첨 테스트 - 1등(6개 모두 일치)`() {
        val winningNums = listOf(1, 2, 3, 4, 5, 6)
        val allCorrectTicketNums = listOf(1, 2, 3, 4, 5, 6)
        val bonusNum = 8

        val lottoResult = LottoResult(lottoTickets, allCorrectTicketNums, bonusNum)

        val pair = lottoResult.pair(winningNums, bonusNum, allCorrectTicketNums)
        pair shouldBe LottoWinner.FIRST_PLACE
    }

    @Test
    fun `당첨 테스트 - 2등(1개 빼고 일치 + 보너스 번호 일치)`() {
        val winningNums = listOf(1, 2, 3, 4, 5, 6)
        val exceptsForOneTicketNums = listOf(1, 2, 3, 4, 5, 7)
        val bonusNum = 7

        val lottoResult = LottoResult(lottoTickets, winningNums, bonusNum)

        val pair = lottoResult.pair(winningNums, bonusNum, exceptsForOneTicketNums)
        pair shouldBe LottoWinner.SECOND_PLACE
    }

    @Test
    fun `당첨 테스트 - 3등(5개 일치)`() {
        val winningNums = listOf(1, 2, 3, 4, 5, 6)
        val exceptsForTwoTicketNums = listOf(1, 2, 3, 4, 5, 44)
        val bonusNum = 45

        val lottoResult = LottoResult(lottoTickets, winningNums, bonusNum)

        val pair = lottoResult.pair(winningNums, bonusNum, exceptsForTwoTicketNums)
        pair shouldBe LottoWinner.THIRD_PLACE
    }

    @Test
    fun `당첨 테스트 - 4등(4개 일치)`() {
        val winningNums = listOf(1, 2, 3, 4, 5, 6)
        val exceptsForTwoTicketNums = listOf(1, 2, 3, 4, 43, 44)
        val bonusNum = 45

        val lottoResult = LottoResult(lottoTickets, winningNums, bonusNum)

        val pair = lottoResult.pair(winningNums, bonusNum, exceptsForTwoTicketNums)
        pair shouldBe LottoWinner.FOURTH_PLACE
    }

    @Test
    fun `당첨 테스트 - 5등(3개 일치)`() {
        val winningNums = listOf(1, 2, 3, 4, 5, 6)
        val exceptsForTwoTicketNums = listOf(1, 2, 3, 42, 43, 44)
        val bonusNum = 45

        val lottoResult = LottoResult(lottoTickets, winningNums, bonusNum)

        val pair = lottoResult.pair(winningNums, bonusNum, exceptsForTwoTicketNums)
        pair shouldBe LottoWinner.FIFTH_PLACE
    }
}