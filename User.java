package kr.hs.dgsw.web_01_319;

public class User {
    private String id;
    private String name;
    private String email;

    public User(){

    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() { return id+'\\'+name+'\\'+email; }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setid(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

}
