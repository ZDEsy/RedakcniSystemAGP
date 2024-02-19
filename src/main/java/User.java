public class User extends UserList{
    int ID;
    String username;
    String age;
    String password;
    int privileges;

    public User(String username, String age, String password)
    {
        this.username = username;
        this.age = age;
        this.password = password;
    }
    public User(int ID, String username, String age, String password, int privileges)
    {
        this.ID = ID;
        this.username = username;
        this.age = age;
        this.password = password;
        this.privileges = privileges;
    }

    public String getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrivileges() {
        return privileges;
    }

    public void setPrivileges(int privileges) {
        this.privileges = privileges;
    }
}
