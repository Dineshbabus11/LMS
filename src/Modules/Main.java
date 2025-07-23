package Modules;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Main {

	static Scanner sc = new Scanner(System.in);
    static Map<String, User> users = new HashMap<>();
    static List<Book> books = new ArrayList<>();
    static Map<String, List<BorrowRecord>> borrowRecords = new HashMap<>();

    public static void main(String[] args) {
        seedData(); 
        while (true) {
            System.out.println("\n=== Library System ===");
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Password: ");
            String pwd = sc.nextLine();

            if (users.containsKey(email) && users.get(email).password.equals(pwd)) {
                User user = users.get(email);
                if (user.role.equals("admin")) adminMenu(user);
                else borrowerMenu(user);
            } else {
                System.out.println("Invalid login.");
            }
        }
    }

    static void seedData() {
        users.put("admin@lib.com", new User("admin@lib.com", "admin123", "Admin", "admin"));
        books.add(new Book("ISBN123", "Java Basics", "James", 500.0, 5));
    }

    static void adminMenu(User admin) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. View Reports");
            System.out.println("5. Logout");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: addUser(); break;
                case 4: viewAdminReports(); break;
                case 5: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void borrowerMenu(User borrower) {
        while (true) {
            System.out.println("\n--- Borrower Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Fines/Deposits");
            System.out.println("5. Logout");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: viewBooks(); break;
                case 2: borrowBook(borrower); break;
                case 3: returnBook(borrower); break;
                case 4: viewDepositAndFines(borrower); break;
                case 5: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addBook() {
        System.out.print("ISBN: "); String isbn = sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Author: "); String author = sc.nextLine();
        System.out.print("Cost: "); double cost = Double.parseDouble(sc.nextLine());
        System.out.print("Quantity: "); int qty = Integer.parseInt(sc.nextLine());
        books.add(new Book(isbn, title, author, cost, qty));
        System.out.println("Book added.");
    }

    static void viewBooks() {
        books.sort(Comparator.comparing(b -> b.title));
        for (Book b : books) {
            System.out.println(b.title + " | " + b.author + " | " + b.quantity + " copies");
        }
    }

    static void addUser() {
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Password: "); String pass = sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Role (admin/borrower): "); String role = sc.nextLine();
        users.put(email, new User(email, pass, name, role));
        System.out.println("User added.");
    }

    static void borrowBook(User borrower) {
        if (borrower.borrowedBooks.size() >= 3) {
            System.out.println("Max 3 books allowed.");
            return;
        }
        System.out.print("Enter book title or ISBN: ");
        String input = sc.nextLine();
        for (Book b : books) {
            if ((b.title.equalsIgnoreCase(input) || b.isbn.equals(input)) && b.quantity > 0) {
                if (borrower.borrowedBooks.contains(b)) {
                    System.out.println("Cannot borrow same book twice.");
                    return;
                }
                if (borrower.deposit < 500) {
                    System.out.println("Maintain Rs.500 as security deposit.");
                    return;
                }
                borrower.borrowedBooks.add(b);
                b.quantity--;
                borrowRecords.computeIfAbsent(borrower.email, k -> new ArrayList<>())
                        .add(new BorrowRecord(b, LocalDate.now(), LocalDate.now().plusDays(15)));
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not found or unavailable.");
    }

    static void returnBook(User borrower) {
        List<BorrowRecord> records = borrowRecords.getOrDefault(borrower.email, new ArrayList<>());
        if (records.isEmpty()) {
            System.out.println("No books borrowed.");
            return;
        }
        for (int i = 0; i < records.size(); i++) {
            BorrowRecord br = records.get(i);
            System.out.println((i + 1) + ". " + br.book.title + " | Due: " + br.dueDate);
        }
        System.out.print("Select book to return: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        if (index >= 0 && index < records.size()) {
            BorrowRecord br = records.remove(index);
            br.book.quantity++;
            borrower.borrowedBooks.remove(br.book);
            long daysLate = ChronoUnit.DAYS.between(br.dueDate, LocalDate.now());
            if (daysLate > 0) {
                double fine = Math.min(daysLate * 2, br.book.cost * 0.8);
                borrower.deposit -= fine;
                System.out.println("Returned with fine of Rs. " + fine);
            } else {
                System.out.println("Book returned on time.");
            }
        }
    }

    static void viewDepositAndFines(User borrower) {
        System.out.println("Deposit Left: Rs. " + borrower.deposit);
    }

    static void viewAdminReports() {
        System.out.println("--- Low Stock Books ---");
        for (Book b : books) {
            if (b.quantity <= 1) {
                System.out.println(b.title + " - Qty: " + b.quantity);
            }
        }
    }

}
