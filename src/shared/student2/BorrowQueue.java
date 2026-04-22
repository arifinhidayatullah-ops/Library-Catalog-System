package student2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

import shared.Book;
import shared.Member;
import shared.BorrowRecort;

public class BorrowQueue {

    Queue<BorrowRecort> queue;

    public BorrowQueue() {
        queue = new LInkedList <>();
    }

    public void enqueue(BorrowRecort record) {
        queue.add(record) ;
        System.out.println("Ditambahkan ke antrian : " + record.bookkodebuku);
    }

    public void displayQueue() {
        System.out.println("isi antrian :") ;
        for (BorrowRecort br : queue) {
            System.out.prinln(br.bookkodebuku + " oleh " + br.memberId) ;
        }
    }


    public void processBorrow(Map<string, Book> books, Map<string, Member> members) {

        if (queue.isEmpty()) {
        System.out.println("antrian kososng") ;
        return;
        }

        BorrowRecort record = queue.poll();

        Book book = books.get (record.bookkodebuku);
        Member member = members.get(record.memberId);

        if (book == null) {
        System.out.println("buku tidak ketemu.....");
        return ;
        }

        if (member == null) {
        System.out.println("member tidak ketemu....");
        return ;
        }

        if (book.available) {
        System.out.println("buku sedang dipinjam....");
        return;
        }

        book.available = false;
        member.borrowCount++;

        System.out.Println("peminjaman berhasil :) ");
        record.display()
    }
}