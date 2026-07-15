import shared.*;

class Main {
    public static void main(String[] args) {

        // test Book
        Book b1 = new Book("001", "Java Basics", "Andi", 2020, true);

        // test Member
        Member m1 = new Member("M01", "Arifin", "arifin@email.com");

        // test br
        BorrowRecord br1 = new BorrowRecord("M01", "001", "2026-03-10");

        b1.display();
        m1.display();
        br1.display();

        // simulasi balik buku
        br1.returnBook("2026-03-15");

        br1.display();
    }
}