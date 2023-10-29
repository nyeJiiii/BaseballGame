package baseball;

import baseball.participant.*;

import java.util.Arrays;

public class BaseballGame {

    private static BaseballGame baseBallGame;

    GameManager gameManager = GameManager.getInstance();
    Narrator narrator = Narrator.getInstance();
    Computer computer = Computer.getInstance();
    User user = User.getInstance();
    ScoreCalculator scoreCalculator = ScoreCalculator.getInstance();

    private BaseballGame() {
    }

    public static BaseballGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseballGame();
        }
        return baseBallGame;
    }

    public void run() {
        narrator.startGame();
        do {
            playGame();
        } while (replay());
    }

    private void playGame() {
        computer.setComputerNumber();

        // 정답 확인용 임시 코드
        System.out.println(Arrays.toString(computer.getNumber().toArray()));

        do {
            scoreCalculator.initializeScore();
            narrator.enterNumber();
            String userNumber = gameManager.readLineForUserNumber();
            user.setUserNumberFromConsole(userNumber);
            scoreCalculator.calculateScore(computer, user);
            gameManager.printOutScore(
                    scoreCalculator.getNumOfBall(),
                    scoreCalculator.getNumOfStrike());

        } while (scoreCalculator.getNumOfStrike()!=3);
    }

    private boolean replay() {
        narrator.selectReplayOrNot();
        return gameManager.readLineForSelectedValue();
    }

}
