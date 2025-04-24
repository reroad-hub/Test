import java.util.HashMap;

public class Admin {
    private final HashMap<String, String> admins = new HashMap<>();
    String name;
    String phone;

    public Admin() {
        admins.put("aaa", "111");
        admins.put("bbb", "222");
        admins.put("ccc", "333");
    }

    public Admin(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public boolean login(String id, String pw) {
        return admins.containsKey(id) && admins.get(id).equals(pw);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
