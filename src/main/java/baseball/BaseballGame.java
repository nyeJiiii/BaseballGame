package baseball;

import baseball.participant.Computer;
import baseball.participant.Narrator;
import baseball.participant.ScoreCalculator;
import baseball.participant.User;
import baseball.participant.ExceptionManager;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class BaseballGame {

    private static BaseballGame baseBallGame;
    private final String RETRY_GAME = "1";

    Narrator narrator = Narrator.getInstance();
    Computer computer = Computer.getInstance();
    User user = User.getInstance();
    ScoreCalculator scoreCalculator = ScoreCalculator.getInstance();
    ExceptionManager exceptionManager = ExceptionManager.getInstance();

    private BaseballGame() {
    }

    public static BaseballGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseballGame();
        }
        return baseBallGame;
    }

    public void run() {
        narrator.StartGame();
        do {
            computer.setRandomNumber();

            // 정답 확인용 임시 코드
             System.out.println(Arrays.toString(computer.getRandomNumber().toArray()));

            guessNumber();

            narrator.ChooseEndOrNot();
        } while (retryGame());
    }

    private void guessNumber() {
        do {
            narrator.EnterNumber();
            String userNumber = readLineForUserNumber();
            user.setUserNumberFromConsole(userNumber);
            scoreCalculator.calculateScore(computer, user);
            scoreCalculator.printOutScore();
        } while (!scoreCalculator.isSuccess());
    }

    private String readLineForUserNumber() {
        String userNumber = Console.readLine();
        exceptionManager.checkWrongUserNumberException(userNumber);
        return userNumber;
    }

    private boolean retryGame() {
        return readLineForSelectedValue();
    }

    private boolean readLineForSelectedValue() {
        String selectedValue = Console.readLine();
        exceptionManager.checkWrongSelectedValueException(selectedValue);
        return selectedValue.equals(RETRY_GAME);
    }
}
