package baseball;

import java.util.Arrays;

public class BaseBallGame extends Scanner {

    private static BaseBallGame baseBallGame;

    Computer computer = Computer.getInstance();
    User user = User.getInstance();
    ScoreCalculator scoreCalculator = ScoreCalculator.getInstance();

    private BaseBallGame() {
    }

    public static BaseBallGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseBallGame();
        }
        return baseBallGame;
    }

    public void run() {
        System.out.print(Narrator.START_GAME);
        do {
            computer.setRandomNumber();

            // 정답 확인용 임시 코드
             System.out.println(Arrays.toString(computer.getRandomNumber().toArray()));

            guessNumber();

            System.out.println(Narrator.ASK_END_OR_NOT);
        } while (!isEnd());
    }

    private void guessNumber() {
        do {
            System.out.print(Narrator.ENTER_NUMBER);
            user.setUserNumberFromConsole();
            scoreCalculator.calculateScore(computer, user);
            scoreCalculator.printOutScore();
        } while (!scoreCalculator.isSuccess());
    }

    public boolean isEnd() {
        return readLineChooseNumber();
    }
}
