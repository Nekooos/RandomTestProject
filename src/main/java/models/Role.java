package models;

public enum UserRole {

    private String role;

    USER("User"),


    UserRole(String role) {
        this.role = role;
    }
}
