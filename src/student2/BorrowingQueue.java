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
        queue = new LinkedList<>();
    }

    public void enqueue(BorrowRecord record) {
        queue.add(record);
        System.out.println("Masuk antrian.....");
    }

    public boolean isEmpty() {
    return queue.isEmpty();
    }

    public void displayQueue() {
        System.out.println(" Isi antrian: ");
        for (BorrowRecord br : queue) {
            System.out.println(br.bookIsbn + " oleh " + br.memberId);
        }
    }



public void processBorrow(Map<String, Book> books, Map<String, Member> members) {
    if (queue.isEmpty()) {
        System.out.println("Antrian kosong.....");
    }

    BorrowRecord record = queue.poll() ;

    Book book = books.get(record.bookIsbn);
    Member member = members.get(record.memberId);

    if (book == null) {
        System.out.println("BUku sedang tidak tersedia! ");
        return;
    }

    if (member == null) {
        System.out.println("Member tidak ditemukan! ");
        return;
    }

    if (!book.available) {
        System.out.println("Buku sedang dipinjam. ");
        return;
    }

    book.available = false;
    member. borrowCount++;

    System.out.println(" Peminjaman telah berhasil :) ");
    record.display();
    }

}