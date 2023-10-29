package baseball.participant;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static Computer computer;
    private List<Integer> number;

    private Computer() {
    }

    public static Computer getInstance() {
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setComputerNumber() {
        number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.number.contains(randomNumber)) {
                this.number.add(randomNumber);
            }
        }
    }
}
