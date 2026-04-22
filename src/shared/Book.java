package shared;

public class Book {
    public String isbn;
    public String title;
    public String author;
    public int year;
    public boolean available;

    public Book(String isbn, String title, String author, int year, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public void display() {
        System.out.println(title + " by " + author + " (" + year + ")");
    }
}