package baseball.participant;

import static baseball.util.ErrorMessage.ERROR_WRONG_SELECTED_VALUE;
import static baseball.util.ErrorMessage.ERROR_WRONG_USER_NUMBER;

public class ExceptionManager {

    private static ExceptionManager exceptionManager;
    private final String USER_NUMBER_REGULAR_EXPRESSION = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
    private final String SELECTED_VALUE_REGULAR_EXPRESSION = "[12]";

    private ExceptionManager() {}

    public static ExceptionManager getInstance() {
        if (exceptionManager == null) {
            exceptionManager = new ExceptionManager();
        }
        return exceptionManager;
    }

    public void checkWrongUserNumberException(String userNumber) {
        if (!userNumber.matches(USER_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ERROR_WRONG_USER_NUMBER);
        }
    }

    public void checkWrongSelectedValueException(String selectedValue) {
        if (!selectedValue.matches(SELECTED_VALUE_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ERROR_WRONG_SELECTED_VALUE);
        }
    }
}
