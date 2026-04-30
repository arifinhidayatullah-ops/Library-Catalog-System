package shared;

public class Member {
    public String id;
    public String name;
    public String email;
    public int borrowCount;

    public Member(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowCount = 0;
    }

    public Member(String id, String name, String email, int borrowCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowCount = borrowCount;
    }

    public void display() {
        System.out.println(name + " (" + email + ")");
    }
}