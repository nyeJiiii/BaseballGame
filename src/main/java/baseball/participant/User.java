package baseball.participant;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static User user;
    private List<Integer> number;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setUserNumberFromConsole(String userNumber) {
        String[] arr = userNumber.split("");
        number = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            number.add(Integer.parseInt(arr[i]));
        }
    }
}
