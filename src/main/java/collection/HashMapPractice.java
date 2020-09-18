package collection;

import models.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashMapPractice {


    public Map<String, User> convertListToMap(final List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(User::getName, Function.identity()));
    }

    public Map<String, User> convertAndSortByAge(final List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toMap(User::getName, Function.identity(),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    public Map<String, User> sortByValue(Map<String, User> users) {
        return users.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    public Map<String, Long> convertListCountNames(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.counting()));
    }

    public User getOrDefault(Map<String, User> users, String key) {
        User defaultUser = new User("defaultUser", 30);
        return users.getOrDefault(key, defaultUser);
    }
}
