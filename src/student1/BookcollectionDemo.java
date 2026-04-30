package student1;

import shared.Book;

public class BookCollectionDemo {
    public static void main(String[] args) {

        BookCollection col = new BookCollection();

        col.addBook(new Book("978-A", "Pemrograman Java", "Andi Sulistyo", 2020, true));
        col.addBook(new Book("978-B", "Struktur Data", "Budi Raharjo", 2019, false));
        col.addBook(new Book("978-C", "Algoritma Modern", "Andi Sulistyo", 2021, true));

        System.out.println("Total: " + col.size());

        col.findByIsbn("978-B");

        col.findByAuthor("Andi Sulistyo");

        col.listAvailable();
    }
}
