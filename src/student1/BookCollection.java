package student1;

import shared.Book;
import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn.equals(isbn)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public Book findByIsbn(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println("Ditemukan: " + book.getInfo());
                return book;
            }
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.author.equalsIgnoreCase(author)) {
                String status = book.available ? "tersedia" : "tidak tersedia";
                System.out.println("Ditemukan: [" + book.isbn + "] " + book.title + " (" + book.year + ") [" + status + "]");
                result.add(book);
            }
        }
        return result;
    }

    public void listAvailable() {
        System.out.println("=== Buku Tersedia ===");
        for (Book book : books) {
            if (book.available) {
                book.display();
            }
        }
    }

    public int size() {
        return books.size();
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }
}