package Modules;
import java.util.*;

public class User {
    String email;
    String password;
    String name;
    String role;
    double deposit = 1500.0;
    List<Book> borrowedBooks = new ArrayList<>();

    public User(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}

