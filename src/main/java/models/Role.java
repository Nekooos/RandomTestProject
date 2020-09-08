package models;

public enum Role {
    USER("User"),
    ADMIN("Admin");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
