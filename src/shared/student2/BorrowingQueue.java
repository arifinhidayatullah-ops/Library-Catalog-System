package student2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

import shared.Book;
import shared.Member;
import shared.BorrowRecord;

public class BorrowingQueue {
    private Queue<BorrowRecord> queue;

    public BorrowingQueue() {
        queue = new LinkedList<>() ;
    }

    public void enqueue(BorrowRecord record) {
        queue.add(record);
        System.out.println("Masuk antrian....");
    } 

    public void displayQueue() {
        System.out.println("Isi antrian : ");
        for(BorrowRecord br : queue) {
            System.out.println(br.bookIsbn + " oleh " + br.memberId);
        }
    }
}

public void processBorrow(Map<String, Book> books, Map< String, Member> members) {
    if (queue.isEmpaty()) {
        System.out.println("Antrian kososng...");
        return ;
    }

    BorrowRecord record = queue.poll();

    Book book = books.get(record.bookIsbn);
    Member member = members.get(record.memberId);

    if (book == null) {
        System.out.println("Buku tidak ketemu....");
        return;
    }

    if (member == null) {
        System.out.println("Member tidak ketemu.....");
        return;
    }

    if (book.available){
        System.out.println("Buku sedang dipinjam...");
        return;
    }

    book.available = false;
    member.borrowcount ++;

    System.out.println("Peminjaman berhasil :)");
    record.display();

}