package student2;

import java.util.HashMap;
import java.util.Map;

import shared.Book;
import shared.Member;
import shared.BorrowRecord;

public class BorrowingQueueDemo {
    public static void main(String[] args) {
        Map<String, Book>books =  new HashMap<>();
        Map<String, member>members = new HashMap<>();

        books.put("010", new Book("010", "Majmu' syarif", "sabian", 2019, true));
        books.put("020", new Book("020", "Panduan solat lengkap", "andrew", 2015, true));
        books.put("030", new Book("030", "Tiktok affiliate", "hanif", 2024, true));

        members.put("M010", new member("M010", "fachrel", "chapler32@gmail.com"));
        members.put("M020", new member("M020", "apta", "aptazzz@gmail.com"));
        members.put("M030", new member("M030", "hanif", "alhanif45@gmail.com"));

        BorrowingQueue queue = new BorrowingQueue();

        queue.enqueue(new BorrowRecord("M010", "BK-101", "2026-03-01"));
        queue.enqueue(new BorrowRecord("M020", "BK-102", "2026-03-05"));
        queue.enqueue(new BorrowRecord("M030", "BK-103", "2026-03-10"));

        queue.displayQueue();

        queue.processBorrow(books, members);

        System.out.println(" Status buku :" + books.get("010").available);
        System.out.println(" Status buku :" + books.get("020").available);
        System.out.println(" Status buku :" + books.get("030").available);
        System.out.println(" Banyak buku dipinjam : :" + members.get("M010").borrowCount);
    }
}