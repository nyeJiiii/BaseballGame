package baseball;

import baseball.participant.Computer;
import baseball.participant.Narrator;
import baseball.participant.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class BaseBallGame {

    private static BaseBallGame baseBallGame;
    private final String RETRY_GAME = "1";

    Narrator narrator = Narrator.getInstance();
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
            String st = readLineForUserNumber();
            user.setUserNumberFromConsole(st);
            scoreCalculator.calculateScore(computer, user);
            scoreCalculator.printOutScore();
        } while (!scoreCalculator.isSuccess());
    }

    private String readLineForUserNumber() {
        String string = Console.readLine();
        checkWrongUserNumberException(string);
        return string;
    }

    public boolean retryGame() {
        return readLineForSelectedValue();
    }

    protected boolean readLineForSelectedValue() {
        String string = Console.readLine();
        checkWrongSelectedValueException(string);
        return string.equals(RETRY_GAME);
    }
}
