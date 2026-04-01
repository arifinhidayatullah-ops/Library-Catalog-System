public class main {
    public static void main(String[] args) {

        // test Book
        Book b1 = new Book("001", "Java Basics", "Andi", 2020, true);
        b1.display();

        // test Member
        member m1 = new member("M01", "Arifin", "arifin@email.com");
        m1.display();
    }
}