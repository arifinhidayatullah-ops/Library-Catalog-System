package student4;

import shared.BorrowRecord;

public class MemberLoanIndex {

  private Entry[] table;
  private int size;
  private int capacity = 10;

  public MemberLoanIndex() {
    table = new Entry[capacity];
    size = 0;
  }

  private class Entry {
    String key;
    BorrowRecord value;
    Entry next;

    Entry(String key, BorrowRecord value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }
  private int hash(String key) {
    return Math.abs(key.hashCode()) % capacity; 
  }
  public void put(String key, BorrowRecord value) {
    int index = hash(key);
 
    Entry newEntry = new Entry(key, value);

    if (table[index] == null) {
        table[index] = newEntry;
    } else {
      Entry current = table[index];

      while (current.next != null) {
        if (current.key.equals(key)) {
            current.value = value;
            return;
        }
        current = current.next;
      }

      current.next = newEntry;
    }

    size++;
  }
  public BorrowRecord get(String key) {
    int index = hash(key);

    Entry current = table[index];

    while (current != null){
      if (current.key.equals(key)) {
          return current.value;
      }
      current = current.next;
    }

    return null;
  }  
  public void remove(String key) {
    int index = hash(key); 

    Entry current= table[index];
    Entry prev = null;

    while (current != null) {
      if (current.key.equals(key)) {
        if (prev == null) {
            table[index] = current.next;
        } else {
          prev.next = current.next;
        }
        size--;
        return;
      }
      prev = current;
      current = current.next;
    }
  }
  public boolean containsKey(String key) {
    return get(key) != null;
  }
  public int size() {
    return size;
  }
  public void listAllKeys() {
    System.out.println("=== Semua Member ID ===")

      for (int i = 0 i < capacity; i++) {
          Entry current = table [i];

          while (current != null) {
            System.out.println(current.key);
            current = current.next;
          }
    }
      
  }
                  
}
