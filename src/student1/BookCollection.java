package student1;

import shared.Book;

public class BookCollection {
    private Book[] books;
    private int size;

    public BookCollection() {
        books = new Book[2];
        size = 0;
    }

    private void resize() {
        Book[] newBooks = new Book[books.length * 2];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        books = newBooks;
    }

    public void addBook(Book book) {
        if (size == books.length) {
            resize();
        }
        books[size] = book;
        size++;
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].isbn.equals(isbn)) {
                for (int j = i; j < size - 1; j++) {
                    books[j] = books[j + i];
                }
                books[size -1] = null;
                size--;
                System.out.prinln("Buku" + isbn + "berhasil dihapus".);
                return;

            }
        }
        System.out.println("Tidak ditemukan ISBN" + isbn);
    }

    public void findByIsbn(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].isbn.equals(isbn)) {
                Book b = books[i];
                String status = b.available ? "[tersedia]" : "[tidak tersedia]";
                System.out.println("Ditemukan: [" + b.isbn + "] "
                        + b.title + " - " + b.author
                        + " (" + b.year + ") " + status);
                return;
            }
        }
        System.out.println("Tidak ditemukan: ISBN" + isbn);
    }

    public void findByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].author.equalsIgnoreCase(author)) {
                Book b = books[i];
                String status = b.available ? "[tersedia]" : "[tidak tersedia]";
                System.out.println("Ditemukan: [" + b.isbn + "] "
                        + b.title + "  (" + b.year + ") " + status);
                found = true;
            }
    }
        if (!found) {
        System.out.println("Tidak ditemukan buku oleh: " + author);
        }
    }

    public void listAvailable() {
        System.out.println("=== Buku Tersedia ===");
        for (int i = 0; i < size; i++) {
            if (books[i].available) {
                Book b = books[i];
                System.out.println("[" + b.isbn + "] "
                        + b.title + " - " + b.author
                        + " (" + b.year + ")");

             }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
