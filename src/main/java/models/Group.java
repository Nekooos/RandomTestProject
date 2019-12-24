package models;

import java.util.stream.Stream;

public class Group {
    private String name;
    private Stream<User> userStream;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<User> getUserStream() {
        return userStream;
    }

    public void setUserStream(Stream<User> userStream) {
        this.userStream = userStream;
    }
}
