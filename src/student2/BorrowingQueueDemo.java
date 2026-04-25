package student2;

import java.util.HashMap;
import java.util.Map;

import shared.Book;
import shared.Member;
import shared.BorrowRecord;

public class BorrowingQueueDemo {
    public static void main(String[] args) {

        Map<String, Book> books = new HashMap<>();
        Map<String, Member> member = new HashMap<>();

        books.put("010", new Book("010", "majmu' syarif", "sabian", 2018, true)) ;
        books.put("020", new Book("020", "panduan solat lengkap", "KH. Andrew", 1995, true));

        member.put("M010", new Member("M010", "WAFIQ RABANI", "Fiqq89@gmail.com")) ;
        member.put("M020", new Member("M020", "FACHRELLLLLL", "chapler8@gmail.com")) ;

        BorrowingQueue queue = new BorrowingQueue();
        
        queue.enqueue(new BorrowRecord("M010", "010", "2026-04-25"));
        queue.enqueue(new BorrowRecord("M020", "020", "2026-04-15"));

        queue.displayQueue();

        System.out.println("\nProses antrian:");

        while (!queue.isEmpty()) {
            queue.processBorrow(books, member);
        }

        System.out.println("\nStatus buku: ");
        System.out.println("010 : " + books.get("010").available);
        System.out.println("020 : " + books.get("020").available);

        System.out.println("\nTotal meminjam: ");
        System.out.println("M010 : " + member.get("M010").borrowCount);
        System.out.println("M020 : " + member.get("M020").borrowCount);
    }
}
