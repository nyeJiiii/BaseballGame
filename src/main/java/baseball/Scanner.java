package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Scanner extends CheckException {

    private final String END_NUM = "2";

    protected String readLineGuessNumber() {
        String string = Console.readLine();
        checkWrongUserNumberException(string);
        return string;
    }

    protected boolean readLineChooseNumber() {
        String string = Console.readLine();
        checkWrongSelectedValueException(string);
        return string.equals(END_NUM);
    }
}
