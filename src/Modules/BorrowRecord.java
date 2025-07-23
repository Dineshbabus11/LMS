package Modules;
import java.time.*;

public class BorrowRecord {
	Book book;
    LocalDate borrowDate;
    LocalDate dueDate;
    int extensionCount;

    public BorrowRecord(Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.extensionCount = 0;
    }
}
