package student3;

import shared.BorrowRecord;

public class ReturnHistoryStackDemo {
    public static void main(String[] args) {
        ReturnHistoryStack stack = new ReturnHistoryStack();

        BorrowRecord r1 = new BorrowRecord("M001", "978-A", "2025-01-10");
        r1.returnBook("2025-01-17");

        BorrowRecord r2 = new BorrowRecord("M002", "978-C", "2025-01-12");
        r2.returnBook("2025-01-18");

        BorrowRecord r3 = new BorrowRecord("M003", "978-B", "2025-01-14");
        r3.returnBook("2025-01-19");

        stack.push(r1);
        stack.push(r2);
        stack.push(r3);

        stack.displayHistory();

        BorrowRecord top = stack.peek();
        if (top != null) {
            System.out.println("Terakhir kembali :" + top.memberId);
        }

        stack.pop();
        stack.displayHistory();

        stack.pop();
        stack.pop();
        stack.pop();
    }
}