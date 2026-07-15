package student1;

import shared.Book;

public class BookSorterDemo {
    public static void main(String[] args) {
        Book[] books = new Book[] {
            new Book("978-A","Pemrograman Java","Andi Sulistyo",2020, true),
            new Book("978-B","Struktur Data","Budi Raharjo",2019,true),
            new Book("978-C","Basis Data Modern","Andi Sulistyo",2018,true),
            new Book("978-D","Algoritma Modern","Citra Dewi",2021,true),
        };

        BookSorter sorter = new BookSorter(books);

        sorter.sortByTitle();
        sorter.printlist("Urut Judul");

        sorter.sortByYear();
        sorter.printlist("Urut Tahun");
    }
}