package student3;

import shared.Book;

public class CatalogBSTDemo {
    public static void main(String[] args) {
        CatalogBST bst = new CatalogBST();

        Book b1 = new Book("978-B", "Algoritma Modern", "Citra Dewi", 2021, true);
        Book b2 = new Book("978-A", "Pemrograman Java", "Andi Sulistyo", 2020, true);
        Book b3 = new Book("978-D", "Basis Data Modern", "Andi Sulistyo", 2018, false);
        Book b4 = new Book("978-C", "Struktur Data", "Budi Raharjo", 2019, true);

        bst.insert(b1);
        bst.insert(b2);
        bst.insert(b3);
        bst.insert(b4);

        Book found1 = bst.search("978-B");
        System.out.println("Cari 978-B: " + (found1 != null ? found1.title : "null"));

        Book found2 = bst.search("978-Z");
        System.out.println("Cari 978-Z: " + (found2 != null ? found2.title : "null"));

        bst.inOrderTraversal();

        String firstIsbn = bst.getFirstIsbn();
        if (firstIsbn != null) {
            System.out.println("ISBN pertama: " + firstIsbn);
        }
    }
}

