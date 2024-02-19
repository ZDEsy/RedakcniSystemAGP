import java.util.ArrayList;

public class UserList {
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<User> articles = new ArrayList<User>();

    public ArrayList<User> getArticles() {
        return articles;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setArticles(ArrayList<User> articles) {
        UserList.articles = articles;
    }

    public void setUsers(ArrayList<User> users) {
        UserList.users = users;
    }
}
