public class Book {
    String kodebuku;
    String title;
    String penulis;
    int year;
    boolean available;

    public Book(String kodebuku, String title, String penulis, int year, boolean available) {
        this.kodebuku = kodebuku;
        this.title = title;
        this.penulis = penulis;
        this.year = year;
        this.available = available;
    }

    public void display() {
        System.out.println(title + " by " + penulis + " (" + year + ")");
    }
}