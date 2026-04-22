package shared;

public class BorrowRecord {
    public String memberId;
    public String bookIsbn;
    public String borrowDate;
    public String returnDate;

    public BorrowRecord(String memberId, String bookIsbn, String borrowDate) {
        this.memberId = memberId;
        this.bookIsbn = bookIsbn;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public void returnBook(String returnDate) {
        this.returnDate = returnDate;
    }

    public void display() {
        System.out.println("Member: " + memberId +
                ", Book: " + bookIsbn +
                ", Borrow Date: " + borrowDate +
                ", Return Date: " + returnDate);
    }
}
