import java.util.ArrayList;

public class UserList {
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Article> articles = new ArrayList<Article>();

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setArticles(ArrayList<Article> articles) {
        UserList.articles = articles;
    }

    public void setUsers(ArrayList<User> users) {
        UserList.users = users;
    }
}
