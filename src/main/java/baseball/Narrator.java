package baseball;

public class Narrator {

    private static Narrator narrator;
    private final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private final String ENTER_NUMBER = "\n숫자를 입력해주세요 : ";
    private final String ASK_END_OR_NOT = """
            \n3개의 숫자를 모두 맞히셨습니다! 게임 종료
            게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.""";

    private final String USER_NUM_REG_EX = "1부터 9사이의 숫자로 이루어진, 중복되지 않는 숫자 세자리를 입력하세요.";
    private final String END_OR_NOT = "숫자 '1' 또는 '2'를 입력하세요.";

    private Narrator() {}

    public static Narrator getInstance() {
        if (narrator == null) {
            narrator = new Narrator();
        }
        return narrator;
    }

}
