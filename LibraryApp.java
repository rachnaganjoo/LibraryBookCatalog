import java.util.*;

public class LibraryApp {
    static class Book {
        int id;
        String title;
        String author;
        String isbn;
        boolean available;

        Book(int id, String title, String author, String isbn, boolean available) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.available = available;
        }

        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Author: " + author +
                   ", ISBN: " + isbn + ", Available: " + available;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int nextId = 1;
        int choice;

        System.out.println("Welcome to Library Book Catalog Manager");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Get Book by ID");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Availability");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                System.out.print("Available (true/false): ");
                boolean available = sc.nextBoolean();
                Book book = new Book(nextId, title, author, isbn, available);
                books.add(book);
                System.out.println("Book added with ID " + nextId);
                nextId++;
            }

            else if (choice == 2) {
                if (books.isEmpty()) {
                    System.out.println("No books.");
                } else {
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(books.get(i));
                    }
                }
            }

            else if (choice == 3) {
                System.out.print("Enter book ID: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < books.size(); i++) {
                    Book b = books.get(i);
                    if (b.id == id) {
                        System.out.println(b);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }
            }

            else if (choice == 4) {
                System.out.print("Enter book ID to delete: ");
                int id = sc.nextInt();
                boolean removed = false;
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).id == id) {
                        books.remove(i);
                        removed = true;
                        break;
                    }
                }
                if (removed) {
                    System.out.println("Book deleted.");
                } else {
                    System.out.println("Book not found.");
                }
            }

            else if (choice == 5) {
                System.out.print("Enter book ID to update availability: ");
                int id = sc.nextInt();
                boolean updated = false;
                for (int i = 0; i < books.size(); i++) {
                    Book b = books.get(i);
                    if (b.id == id) {
                        System.out.print("New availability (true/false): ");
                        boolean status = sc.nextBoolean();
                        b.available = status;
                        updated = true;
                        System.out.println("Availability updated.");
                        break;
                    }
                }
                if (!updated) {
                    System.out.println("Book not found.");
                }
            }

        } while (choice != 6);

        System.out.println("Library closed.");
        sc.close();
    }
}
