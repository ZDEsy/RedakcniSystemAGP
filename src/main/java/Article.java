import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Objects;

public class Article {
    int ID;
    String creator;
    String title;
    String text;

    ArrayList<Article> userArticleList = new ArrayList<Article>();
    public Article(String title, String text)
    {
        ID = UserList.articles.size();
        creator = MainSystem.loggedUser.username;
        this.title = title;
        this.text = text;
    }
}
