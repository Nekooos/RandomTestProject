package lambda.currying;

import models.User;

import java.util.function.Predicate;

@FunctionalInterface
public interface UserPredicate  {
    boolean test(User user);

    default UserPredicate compare(User user1) {
        return user -> {
            return user.getAge() > user1.getAge();
        };
    }
}
