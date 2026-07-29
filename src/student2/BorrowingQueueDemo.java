package student2;

import shared.Member;

public class BorrowingQueueDemo {
    public static void main(String[] args) {

        BorrowingQueue queue = new BorrowingQueue();

        queue.enqueue(new Member("M01", "Sabian Mugis", "mugis88@gmail.com", 3));
        queue.enqueue(new Member("M02", "Andreww jung", "dre123@gmail.com", 2));
        queue.enqueue(new Member("M03", "Dinda", "DINDAAAAAAA@gmail.com", 5));

        queue.displayQueue();

        System.out.println("Berikutnya: " + queue.peek().name);

        System.out.println("DIlayani: " + queue.dequeue().name);
        queue.displayQueue();

        System.out.println("Dilayani: " + queue.dequeue().name);
        System.out.println("Dilayani: " + queue.dequeue().name);

        queue.dequeue();
    }
}