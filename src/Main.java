import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BookGenre genre = readGenre();
        System.out.println("Selected genre: " + genre);

        Book newBook = readData();
        System.out.println("New Book Information:\n" + newBook);
    }

    private static BookGenre readGenre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book Genre (MYSTERY, SCIENCE_FICTION, ROMANCE, THRILLER, COMEDY): ");
        String genreInput = scanner.nextLine().toUpperCase();

        return BookGenre.valueOf(genreInput);
    }

    private static Book readData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Book Information:");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        BookGenre genre = readGenre();

        System.out.print("Publication Date (yyyy-MM-dd): ");
        LocalDate publicationDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        return new Book(title, author, genre, publicationDate, quantity);
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
        private LocalDate publicationDate;
        private int quantity;

        public Book(String title, String author, BookGenre genre, LocalDate publicationDate, int quantity) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationDate = publicationDate;
            this.quantity = quantity;
        }

        public String toString() {
            return "Book(" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre=" + genre +
                    ", publicationDate=" + publicationDate +
                    ", quantity=" + quantity +
                    ')';
        }
    }
}
