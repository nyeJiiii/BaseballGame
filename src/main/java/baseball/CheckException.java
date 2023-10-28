package baseball;

import static baseball.ErrorMessage.ERROR_WRONG_SELECTED_VALUE;
import static baseball.ErrorMessage.ERROR_WRONG_USER_NUMBER;

public class CheckException {
    private final String USER_NUM_REG_EX = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
    private final String END_OR_NOT = "[12]";

    public void guessNumberException(String st) {
        if (!st.matches(USER_NUM_REG_EX)) {
            throw new IllegalArgumentException(ERROR_WRONG_USER_NUMBER);
        }
    }

    public void endNumberException(String st) {
        if (!st.matches(END_OR_NOT)) {
            throw new IllegalArgumentException(ERROR_WRONG_SELECTED_VALUE);
        }
    }
}
