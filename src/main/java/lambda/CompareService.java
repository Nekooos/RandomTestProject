package lambda;

import models.User;

import java.util.Comparator;
import java.util.List;

public class CompareService {
    public List<User> sortUserByNameThenAge(List<User> userList) {
        userList.sort(Comparator.comparing(User::getName).thenComparingInt(User::getAge));
        return userList;
    }

    public List<User> sortUserByNameReversed(List<User> userList) {
        Comparator<User> comparator = Comparator.comparing(User::getName);
        userList.sort(comparator.reversed());
        return userList;
    }
}
