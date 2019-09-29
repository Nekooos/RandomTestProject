package lambda;

import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareServiceTest {

    private CompareService compareService;
    private List<User> userList;

    @BeforeEach
    public void setUp() {
        compareService = new CompareService();
        userList = addUsersToList();
    }

    @Test
    public void sortByNameAndThenAge() {
        List<User> sortedUserList = compareService.sortUserByNameThenAge(userList);
        assertEquals("Anna", sortedUserList.get(0).getName());
        assertEquals(38, sortedUserList.get(1).getAge());
    }

    @Test
    public void sortByNameReversed() {
        List<User> sortedUserList = compareService.sortUserByNameReversed(userList);
        assertEquals("Anna", sortedUserList.get(2).getName());
    }

    public List<User> addUsersToList() {
        var user1 = new User("Leif", 40);
        var user2 = new User("Anna", 39);
        var user3 = new User("Leif", 38);
        return Arrays.asList(user1, user2, user3);
    }

}
