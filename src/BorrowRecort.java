public class BorrowRecort {
    String memberId;
    String bookIsbn;
    String borrowDate;
    String returnDate;

    public BorrowRecort(String memberId, String bookIsbn, String borrowDate) {
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