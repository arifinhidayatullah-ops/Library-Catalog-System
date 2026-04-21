package student4;

import shared.BorrowRecord;

public class MemberLoanIndexDemo {
  public static void main(String[] args) {

    MemberLoanIndex index = new MemberLoanIndex();

    //data contoh
    index.put("M010", new BorrowRecord("M010", "BK-101", "2026-03-01", null));
    index.put("M020", new BorrowRecord("M020", "BK-102", "2026-03-05", null));
    index.put("M030", new BorrowRecord("M030", "BK-103", "2026-03-10", null));
    
    //test size
    System.out.println("Total peminjam: " + index.size());

    //contains
    System.out.println("Apakah M020 sedang meminjam? " + index.containsKey("M020"));
    

    //test get
    BorrowRecord r = index.get("M010");
    if (r != null) {
        System.out.println("Data ditemukan " + r.memberId + " meminjam [" + r.bookIsbn + "] pada " + r.borrowDate);
    }

    //test list
    index.listAllKeys();

    //test remove
    index.remove("M020");
    System.out.println("Data M020 sudah dihapus.");

    //size lagi
    System.out.println("Sisa peminjam: " + index.size ());
  }
}
