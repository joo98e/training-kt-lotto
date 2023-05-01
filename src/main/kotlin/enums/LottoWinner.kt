package enums

enum class LottoWinner(val desc: String, val prizeMoney: Int) {
    FIRST_PLACE("6개 일치", 2_000_000_000),
    SECOND_PLACE("5개 일치, 보너스 번호 일치", 30_000_000),
    THIRD_PLACE("5개 일치", 1_500_000),
    FOURTH_PLACE("4개 일치", 50_000),
    FIFTH_PLACE("3개 일치", 5_000),
    NONE("그 외 낙첨", 0)
}