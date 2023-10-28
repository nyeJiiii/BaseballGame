package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader extends CheckException {

    private final String RETRY_GAME = "1";

    protected String readLineForUserNumber() {
        String string = Console.readLine();
        checkWrongUserNumberException(string);
        return string;
    }

    protected boolean readLineForSelectedNumber() {
        String string = Console.readLine();
        checkWrongSelectedValueException(string);
        return string.equals(RETRY_GAME);
    }
}
