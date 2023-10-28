package baseball.participant;

import camp.nextstep.edu.missionutils.Console;

import static baseball.util.ErrorMessage.ERROR_WRONG_SELECTED_VALUE;
import static baseball.util.ErrorMessage.ERROR_WRONG_USER_NUMBER;

public class GameManager {

    private static GameManager gameManager;
    private final String REPLAY_NUMBER = "1";
    private final String USER_NUMBER_REGULAR_EXPRESSION = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
    private final String SELECTED_VALUE_REGULAR_EXPRESSION = "[12]";
    private final String NOTHING = "낫싱";
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";

    private GameManager() {}

    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public String readLineForUserNumber() {
        String userNumber = Console.readLine();
        checkWrongUserNumberException(userNumber);
        return userNumber;
    }

    private void checkWrongUserNumberException(String userNumber) {
        if (!userNumber.matches(USER_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ERROR_WRONG_USER_NUMBER);
        }
    }

    public void printOutScore(int numOfBall, int numOfStrike) {
        if (numOfBall == 0 && numOfStrike == 0) {
            System.out.print(NOTHING);
        } else {
            if (!(numOfBall == 0)) {
                System.out.print(numOfBall + BALL + " ");
            }
            if (!(numOfStrike == 0)) {
                System.out.print(numOfStrike + STRIKE);
            }
        }
    }

    public boolean readLineForSelectedValue() {
        String selectedValue = Console.readLine();
        checkWrongSelectedValueException(selectedValue);
        return selectedValue.equals(REPLAY_NUMBER);
    }

    private void checkWrongSelectedValueException(String selectedValue) {
        if (!selectedValue.matches(SELECTED_VALUE_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ERROR_WRONG_SELECTED_VALUE);
        }
    }
}
