package student2;

import shared.Member;

class Node {
    Member data;
    Node next;

    Node(Member data) {
        this.data = data;
        this.next = null;
    }
}

public class BorrowingQueue {
    private Node front;
    private Node rear;
    private int size;

    public BorrowingQueue() {
        front = rear = null;
        size = 0;
    }

    // enqueue
    public void enqueue(Member data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // dequeue
    public Member dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Antrian peminjaman sudah kosong.");
            return null;
        }

        Member temp = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return temp;
    }

    // peek
    public Member peek() {
        if (isEmpty()) return null;
        return front.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return front == null;
    }

    // size
    public int size() {
        return size;
    }

    // display
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("=== Antrian Peminjaman (" + size + " anggota) ===");

        Node current = front;
        int i = 1;

        while (current != null) {
            Member m = current.data;
            System.out.println(i + ". [" + m.id + "] " + m.name +
                    " (meminjam: " + m.borrowCount + " buku)");
            current = current.next;
            i++;
        }
    }
}