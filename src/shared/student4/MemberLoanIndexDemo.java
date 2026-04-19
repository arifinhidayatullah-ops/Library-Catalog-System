package student4;

import shared.BorrowRecord;

public class MemberLoanIndexDemo {
  public static void main(String[] args) {

    MemberLoanIndex map = new MemberLoandIndex();

    //data contoh
    BorrowRecord r1 = new BorrowRecord("M001", "B001", "2026-04-01", "-");
    BorrowRecord r2 = new BorrowRecord("M002", "B002", "2026-04-02", "-");

    //test put
    map.put("M001", r1);
    map.put("M002", r2);

    //test size
    System.out.println("Size: " + map.size());

    //test get
    BorrowRecord result = map.get("M001");
    if (result != null) {
        System.out.println("FOund: " + result.memberId + " - " + result/bookIsbn);
    }

    //test list
    map.listAllKeys();

    //test remove
    map.remove("M001");

    System.out.println("After remove:");
    map.listAllKeys();
  }
}
