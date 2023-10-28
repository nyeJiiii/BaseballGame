package baseball.participant;

public class ScoreCalculator {

    private static ScoreCalculator scoreCalculator;
    private int numOfBall;
    private int numOfStrike;

    private ScoreCalculator() {
    }

    public static ScoreCalculator getInstance() {
        if (scoreCalculator == null) {
            scoreCalculator = new ScoreCalculator();
        }
        return scoreCalculator;
    }

    public void calculateScore(Computer computer, User user) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getRandomNumber().get(i).equals(user.getInputNumber().get(j))) {
                    if (i == j) {
                        numOfStrike++;
                        break;
                    } else {
                        numOfBall++;
                        break;
                    }
                }
            }
        }
    }

    public void printOutScore() {
        if (numOfBall == 0 && numOfStrike == 0) {
            System.out.print("낫싱");
        } else {
            if (!(numOfBall == 0)) {
                System.out.printf("%d볼 ", numOfBall);
            }
            if (!(numOfStrike == 0)) {
                System.out.printf("%d스트라이크", numOfStrike);
            }
        }
    }

    public boolean isSuccess() {
        if (numOfStrike == 3) {
            initializeScore();
            return true;
        }
        initializeScore();
        return false;
    }

    private void initializeScore() {
        numOfBall = 0;
        numOfStrike = 0;
    }
}
