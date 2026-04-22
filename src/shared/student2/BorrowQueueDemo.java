package student2;

import java.util.HashMap;
import java.util.Map;

import shared.Book;
import shared.Member;
import shared.BorrowRecort;

public class BorrowQueueDemo {
    public static void main (string[] args) {
        Map<String, Book> books = new HashMap<>();
        Map<String, Member> members = new HashMap<>();

        books.put("010", new Book("010", "majmu syarif", "sabian", 2024, true ));
        books.put("020", new Book("020", "panduan solat lengkap", "fachrel", 2023, true ));
        books.put("030", new Book("030", "tiktok affiliate", "hanif", 2025, true ));

        members.put("M010", new Member("M010", "andre", "andrew66@gmail.com"));
        members.put("M020", new Member("M020", "wafiq", "fiqqq12@gmail.com"));
        members.put("M030", new Member("M030", "maul", "maulanaking@gmail.com"));

        BorrowQueue queue = new BorrowQueue();

        queue.enqueue(new BorrowRecort("M010", "BK-101", "2026-03-01"));
        queue.enqueue(new BorrowRecort("M020", "BK-102", "2026-03-05"));
        queue.enqueue(new BorrowRecort("M030", "BK-103", "2026-03-10"));

        queue.displayQueue();

        System.out.println("\nproses: ");
        queue.proscessBorrow(books, members);

        System.out.prinln("\nstatus setelah proses:");
        System.out.println("buku 020 tersedia: " + books.get("020").available);
        System.out.println("total pinjam buku 020: " + members.get("M020").BorrowCount);

    }
}