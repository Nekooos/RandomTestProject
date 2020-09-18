package lambda;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaTest {
    private List<User> userList;
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
        LambdaClass lambdaClass = new LambdaClass();
        assertEquals("SS",lambdaClass.upperCase("s", "s"));
        List<User> expectedUserList = Arrays.asList( new User("Sara", 29), new User("Sara", 29), new User("Egon", 33));
        assertEquals(expectedUserList.get(0).getAge(), lambdaClass.usersSortedByAge(userList, user -> user.getAge() > 25).get(0).getAge());
        IntPredicate greaterThan = age -> age > 28;
        IntPredicate lesserThan = age -> age < 30;
        assertTrue(lambdaClass.andPredicate(userList.get(4), greaterThan, lesserThan));

        BiPredicate<Integer, Integer> twoArgument = (num, num2) -> num > num2;
        assertTrue(twoArgument.test(2,1));
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

        BiFunction<String, User, String> concatAge = (String name, User user) -> {
            return name.concat(" " + user.getAge());
        };
        String name = toUpperCase.apply(userList.get(0).getName());
        assertEquals("ANNA ANNASSON 20", concatAge.apply(name, userList.get(0)));
    }

    @Test
    public void functionReturnsPredicate() {
        Function<String, Predicate<String>> functionReturnPredicate = name -> name2 -> name.length() > name2.length();
        boolean AnnaLongerThanArnold = functionReturnPredicate.apply("Anna").test("Arnold");
        assertEquals(false, AnnaLongerThanArnold);
    }

    @Test
    public void functionReturnsFunction() {
        Function<String, Function<String, String>> functionReturnPredicate = name -> name2 -> name.length() > name2.length() ? name : name2;
        String longestName = functionReturnPredicate.apply("Anna").apply("Arnold");
        assertEquals("Arnold", longestName);
    }

    @Test
    public void testConsumer() {
        Consumer<String> toLowerCase = String::toLowerCase;
        Consumer<String> firstLetterUpperCase = string -> string.toUpperCase().charAt(0);
        Consumer<String> printOut = System.out::println;
        toLowerCase.andThen(firstLetterUpperCase).andThen(printOut).accept("heLlO");
        //Void
    }

    @Test
    public void stream() {
        List<String> sortedUserList  = userList.stream()
                .map(User::getName)
                .filter(user -> user.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
        assertEquals(2, sortedUserList.size());

        List<String> sortedUserList2  = userList.stream()
                .map(User::getName)
                .filter(user -> user.startsWith("A"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(2, sortedUserList2.size());
    }
}

@FunctionalInterface
interface UpperConcat {
    String upperConcat(String s1, String s2);
}

class LambdaClass {
    public String upperCase(String st1, String st2) {
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

    public List<User> userSortedByAgeStream(List<User> users, Predicate<User> ageCondition) {
        return users.stream()
                .filter(ageCondition)
                .collect(Collectors.toList());
    }

    public boolean andPredicate(User user, IntPredicate greaterThan, IntPredicate lesserThan) {
        return greaterThan.and(lesserThan).test(user.getAge());
    }
}
