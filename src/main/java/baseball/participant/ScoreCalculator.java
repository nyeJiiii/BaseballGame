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

    public int getNumOfBall() {
        return numOfBall;
    }

    public int getNumOfStrike() {
        return numOfStrike;
    }

    public void calculateScore(Computer computer, User user) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getNumber().get(i).equals(user.getNumber().get(j))) {
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
