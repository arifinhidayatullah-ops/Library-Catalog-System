package student1;

import shared.Book;

public class BookSorter {
    private Book[] books;


    public BookSorter(Book[] books) {
        this.books = books;
    }

    public void sortByTitle() {
        int n = books.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (books[j].title.compareToIgnoreCase(books[minIdx].title) < 0) {
                    minIdx = j;
                }
            }
            Book temp = books[minIdx];
            books [minIdx] = books[i];
            books[i] = temp;
        }
    }

    public void sortByYear() {
        int n = books.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books[j].year > books[j + 1].year) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void printlist(String label) {
        System.out.println("\n=== " + label + " ===\n");
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println((i + 1) + ". " + b.title + " - " + b.author + " (" + b.year + ")");
        }
    }
}