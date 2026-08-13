package student3;

import shared.BorrowRecord;

public class ReturnHistoryStack {

    private static class Node {
        BorrowRecord data;
        Node next;

        public Node(BorrowRecord data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public ReturnHistoryStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(BorrowRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public BorrowRecord pop() {
        if (isEmpty()) {
            System.out.println("Error: Tidak ada riwayat pengembalian yang bisa di-undo.");
            return null;
        }
        BorrowRecord temp = top.data;
        top = top.next;
        size--;
        System.out.println("Undo pengembalian: " + temp.memberId + " - buku " + temp.bookIsbn + " kembali ke status dipinjam");
        return temp;
    }

    public BorrowRecord peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void displayHistory() {
        System.out.println("=== Riwayat Pengembalian (terbaru di atas) ===");
        if(isEmpty()) {
            return;
        }

        Node curr = top;
        int i = size;
        while (curr != null) {
            System.out.println(i + ". " + curr.data.memberId + " kembalikan " + curr.data.bookIsbn + " | dikembalikan: " + curr.data.returnDate);
            curr = curr.next;
            i--;
        }
    }
}