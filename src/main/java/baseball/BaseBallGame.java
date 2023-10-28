package baseball;

import java.util.Arrays;

public class BaseBallGame extends ConsoleReader {

    private static BaseBallGame baseBallGame;

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
            user.setUserNumberFromConsole();
            scoreCalculator.calculateScore(computer, user);
            scoreCalculator.printOutScore();
        } while (!scoreCalculator.isSuccess());
    }

    public boolean retryGame() {
        return readLineForSelectedNumber();
    }
}
