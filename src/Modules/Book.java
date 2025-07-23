package Modules;

public class Book {
	String isbn, title, author;
    double cost;
    int quantity;

    public Book(String isbn, String title, String author, double cost, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.quantity = quantity;
    }
}
