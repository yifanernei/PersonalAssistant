package xyz.yifanernei.personalassistant.Enity;

public class UserInfo {
    private String id = null;
    private String name = null;
    private String email = null;

    public UserInfo(String n, String e) {
        name = n;
        email = e;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
