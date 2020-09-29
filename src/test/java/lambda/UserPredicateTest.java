package lambda;

import lambda.currying.UserPredicate;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPredicateTest {
    @Test
    public void userPredicateTest() {
        User user1 = new User("user1", 28);
        User user2 = new User("user2", 37);
        User user3 = new User("user3", 41);
        User user4 = new User("user4", 22);
        Boolean user2IsOlder = UserPredicate.isOlder(user1).test(user2);
        Assertions.assertEquals(true, user2IsOlder);
        Boolean user3older1and2 = UserPredicate.isOlder(user1).and(UserPredicate.isOlder(user2)).test(user3);
        Assertions.assertEquals(true, user3older1and2);
        Boolean user2older1not3 = UserPredicate.isOlder(user1).and(UserPredicate.isOlder(user3)).test(user2);
        Assertions.assertEquals(false, user2older1not3);
        Boolean user2older1or3 = UserPredicate.isOlder(user1).or(UserPredicate.isOlder(user3)).test(user2);
        Assertions.assertEquals(true, user2older1or3);
    }
}
