package student1;

import shared.*;

public class main {
    public static void main(String[] args) {

        Book b1 = new Book("001", "Java Basics", "Andi", 2020, true);
        Member m1 = new Member("M01", "Abrar", "abrar@email.com");
        BorrowRecord br1 = new BorrowRecord("M01", "001", "2026-03-10");

        b1.display();
        m1.display();
        br1.display();

        br1.returnBook("2026-03-15");

        br1.display();
    }
}