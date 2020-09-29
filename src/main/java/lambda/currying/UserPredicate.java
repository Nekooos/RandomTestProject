package lambda.currying;

import models.User;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface UserPredicate  {
    boolean test(User user);

    default UserPredicate and(UserPredicate userPredicate) {
        return (User user) -> test(user) && userPredicate.test(user);
    }

    default UserPredicate or(UserPredicate userPredicate) {
        return user -> test(user) || userPredicate.test(user);
    }

    static UserPredicate isOlder(User user2) {
        return user -> user.getAge() > user2.getAge();
    }
}
