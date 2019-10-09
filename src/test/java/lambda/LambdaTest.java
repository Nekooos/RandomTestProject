package lambda;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaTest {
    List<User> userList;
    @BeforeEach
    public void init() {
        User anna = new User("Anna Annasson", 20);
        User anders = new User("Anders", 21);
        User johan = new User("Johan", 25);
        User malin = new User("Malin", 33);
        User sara = new User("Sara", 29);
        User egon = new User("Egon", 33);
        userList = Arrays.asList(anna, anders, johan, malin, sara, egon);
    }

    @Test
    public void testingPredicate() {
        AnotherClass anotherClass = new AnotherClass();
        assertEquals("SS",anotherClass.doSomething("s", "s"));
        List<User> expectedUserList = Arrays.asList( new User("Sara", 29), new User("Sara", 29), new User("Egon", 33));
        assertEquals(expectedUserList.get(0).getAge(), anotherClass.usersSortedByAge(userList, user -> user.getAge() > 25).get(0).getAge());
        IntPredicate greaterThan = age -> age > 28;
        IntPredicate lesserThan = age -> age < 30;
        assertTrue(anotherClass.andPredicate(userList.get(4), greaterThan, lesserThan));
    }

    @Test
    public void testingFunction() {
        Function<User, String> getLastName = (User user) -> user.getName().substring(user.getName().indexOf(' ')+1);
        assertEquals("Annasson", getLastName.apply(userList.get(0)));

        Function<User, String> getFirstName = (User user) -> user.getName().substring(0, user.getName().indexOf(' '));
        assertEquals("Anna", getFirstName.apply(userList.get(0)));

        Function<String, String> toUpperCase = String::toUpperCase;

        Function chainedFunction = getLastName.andThen(toUpperCase);
        assertEquals("ANNASSON", chainedFunction.apply(userList.get(0)));
    }

}

@FunctionalInterface
interface UpperConcat {
    String upperConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething(String st1, String st2) {
        UpperConcat upperConcat = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        return upperConcat.upperConcat(st1, st2);
    }

    public List<User> usersSortedByAge(List<User> users, Predicate<User> ageCondition) {
        List<User> ageConditionList = new ArrayList<>();
        for(User user : users) {
            if(ageCondition.test(user)) {
                ageConditionList.add(user);
            }
        }
        ageConditionList.sort(Comparator.comparing(User::getAge));
        return ageConditionList;
    }

    public boolean andPredicate(User user, IntPredicate greaterThan, IntPredicate lesserThan) {
        return greaterThan.and(lesserThan).test(user.getAge());
    }
}
