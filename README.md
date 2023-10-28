# 숫자 야구 게임

## ❓ 숫자 야구 게임은

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.


## 📝구현할 기능 목록

- [X] 숫자 야구 실행시 세자리 숫자를 랜덤의 컴퓨터 수(사용자가 맞춰야 하는 수)를 생성한다.
    - 위 세자리 숫자는 각각 다른 숫자이다.
- [X] 사용자가 세자리 숫자를 입력 할 시 컴퓨터의 수와 비교해 결과값을 출력한다.
    - ex) `1볼 1스트라이크`
- [X] 사용자가 정답을 맞힐 경우 게임을 새로 시작하거나 완전히 종료할 수 있도록 한다.
    - 1을 입력하면 게임을 새로 시작한다.
    - 2를 입력하면 게임을 완전히 종료한다.
- [X] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 사용자가 세자리 숫자를 입력할 때
        - 숫자가 아닌 값을 입력할 때
        - 숫자의 자리수가 세자리가 아닐 때
        - 입력한 숫자 중 중복된 수가 있을 때
    - 정답을 맞춘 후 게임을 다시 시작할지 의사를 입력할 때
        - 1 또는 2가 아닌 다른 값을 입력할 때


## 🚀 게임 진행

#### 입력한 수에 대한 출력값

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```
