# kotlin-lotto

## 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 기능 명세

---
- InputView
  - ~~구입 금액을 입력 받는다.~~
  - ~~당첨 번호와 보너스 볼을 입력 받는다.~~
  - ~~당첨 번호와 보너스 볼을 입력 받는다.~~
- Cashier
  - [ ] Gambler 와 Int 인자를 받아 로또 티켓 구매를 할 수 있다. Gambler 를 리턴한다.
  - 로또 티켓의 가격을 상수(companion Object)로 보유한다. 
- Gambler(Cashier > Internal Class) 
  - ~~소비 금액을 보유한다.~~
  - [x] List<LottoTicket>를 보유한다.
- LottoTicket
  - [x] 오직 이곳에서만 로또 머신이 호출되며 init에서 호출한다.
  - [x] 티켓은 로또 머신을 호출한 결과를 보유한다. (List<Int>)
- LottoMachine
  - [x] 번호 리스트를 가진다. (1 ~ 45)
  - [x] 자동 번호 리스트(List<Int>)를 산출한다.
  - [x] 보너스 번호(Int)를 산출한다.
  - [x] 서로 겹치지 않는 번호를 산출한다.
- LottoResult
  - [x] 초기화 시 생성자에서 지난 주의 당첨 번호, 보너스 번호와 List<LottoTicket>을 받고 보유한다.
  - [x] 지난 주의 당첨 번호와 보너스 번호를 받을 때, validate 를 한다.
  - [ ] 보유하고 있는 티켓들의 당첨 금액을 계산하여 리턴한다.
  - [ ] 상수로 티켓의 legnth와 보너스 번호를 보유한다.
- NumberUtil
  - [ ] 랜덤 번호 1개를 산출하는 기능
  - [ ] 내부의 랜덤 번호 추출 메서드를 통해 n개 만큼 산출하는 기능
  - [ ] total Value 와 Current Value 를 통해 비율을 계산하는 기능
- Validation
  - [ ] 입력 값이 숫자인지 확인하는 기능 => 그렇지 않을 경우 예외를 던지는 기능
  - [ ] 입력 값이 로또를 정량 구매 가능한 단위의 숫자인지 확인하는 기능 => 그렇지 않을 경우 예외를 던지는 기능
  - [ ] 입력 값이 콤마를 딜리미터로 하여금 숫자로 나눠질 수 있는지 확인한다.
  - [ ] 인자로 받는 List<Int>와 length를 체크한다.
- OutputView
  - [ ] Gambler 의 소비 내역을 전달 받고 당첨 금액을 비교하여 수익률을 리턴한다.
  
[^1] : readln 의 결과를 테스트하기에는 "입력을 받는다"라는 어려움이 있어, Validation 으로 검증  
[^2] : readln 의 결과를 테스트하기에는 "입력을 받는다"라는 어려움이 있어, Validation 으로 검증  