import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            BookGenre genre = readGenre();
            System.out.println("Selected genre: " + genre);

            String title = readString("Title: ");
            String author = readString("Author: ");
            int publicationYear = readYear("Publication Year (yyyy): ");
            int quantity = readQuantity("Quantity: ");

            Book newBook = new Book(title, author, genre, publicationYear, quantity);
            books.add(newBook);

            System.out.println("New Book Information:\n" + newBook);

            System.out.print("Do you want to register another book? (yes/no): ");
            String continueInput = scanner.nextLine().toLowerCase();
            if (!continueInput.equals("yes")) {
                break;
            }
        }

        System.out.println("All registered books:");
        for (Book book : books) {
            System.out.println(book);
        }

        scanner.close();
    }

    private static BookGenre readGenre() {
        System.out.print("Enter Book Genre (MYSTERY, SCIENCE_FICTION, ROMANCE, THRILLER, COMEDY): ");
        String genreInput = scanner.nextLine().toUpperCase();
        return BookGenre.valueOf(genreInput);
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readYear(String prompt) {
        int year = 0;
        while (year <= 0) {
            try {
                System.out.print(prompt);
                year = Integer.parseInt(scanner.nextLine());
                if (year <= 0) {
                    System.out.println("Year must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Please enter a valid number.");
            }
        }
        return year;
    }

    private static int readQuantity(String prompt) {
        int quantity = 0;
        while (quantity <= 0) {
            try {
                System.out.print(prompt);
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity format. Please enter a valid number.");
            }
        }
        return quantity;
        }

    public enum BookGenre {
        MYSTERY,
        SCIENCE_FICTION,
        ROMANCE,
        THRILLER,
        COMEDY,
    }

    public static class Book {
        private String title;
        private String author;
        private BookGenre genre;
        private int publicationYear;
        private int quantity;

        public Book(String title, String author, BookGenre genre, int publicationYear, int quantity) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationYear = publicationYear;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Book(" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre=" + genre +
                    ", publicationYear=" + publicationYear +
                    ", quantity=" + quantity +
                    ')';
        }
    }
}