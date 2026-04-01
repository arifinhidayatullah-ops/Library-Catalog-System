public class member {
    String id;
    String name;
    String email;
    int borrowCount;

    public member(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowCount = 0;
    }

    public void display() {
        System.out.println(name + "(" + email + ")");
    
    }  
}