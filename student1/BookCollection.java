package student1;

import shared.Book;

public class BookCollection {
    private Book[] books;
    private int size;

    public BookCollection() {
        books = new Book[10];
        size = 0;
    }

    // tambah buku
    public void addBook(Book book) {
        if (size == books.length) resize();

        // ❗ validasi ISBN biar ga duplikat
        if (isIsbnExist(book.isbn)) {
            System.out.println("ISBN sudah ada: " + book.isbn);
            return;
        }

        books[size++] = book;
    }

    // cek ISBN sudah ada
    private boolean isIsbnExist(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i] != null && books[i].isbn.equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    // hapus buku
    public void removeBook(String isbn) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (books[i] != null && books[i].isbn.equals(isbn)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Tidak ditemukan ISBN: " + isbn);
            return;
        }

        for (int i = index; i < size - 1; i++) {
            books[i] = books[i + 1];
        }

        books[--size] = null;
    }

    // cari ISBN
    public Book findByIsbn(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i] != null && books[i].isbn.equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    // tampilkan hasil ISBN
    public void showByIsbn(String isbn) {
        Book b = findByIsbn(isbn);

        if (b != null) {
            printBook(b);
        } else {
            System.out.println("Tidak ditemukan ISBN: " + isbn);
        }
    }

    // cari author
    public void findByAuthor(String author) {
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (books[i] != null &&
                books[i].author.equalsIgnoreCase(author)) {

                printBook(books[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada buku dari: " + author);
        }
    }

    // tampil semua buku
    public void listAll() {
        System.out.println("=== Semua Buku ===");

        if (isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }

        for (int i = 0; i < size; i++) {
            if (books[i] != null) {
                printBook(books[i]);
            }
        }
    }

    // tampil buku tersedia
    public void listAvailable() {
        System.out.println("=== Buku Tersedia ===");

        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (books[i] != null && books[i].available) {
                printBook(books[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada buku tersedia.");
        }
    }

    // ✅ method biar gak ulang-ulang print
    private void printBook(Book b) {
        String status = b.available ? "tersedia" : "dipinjam";

        System.out.println("[" + b.isbn + "] " + b.title +
                " - " + b.author +
                " (" + b.year + ") [" + status + "]");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        books = newBooks;
    }
}