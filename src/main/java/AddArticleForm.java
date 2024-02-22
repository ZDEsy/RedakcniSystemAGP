import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddArticleForm extends JFrame{
    private JPanel tab;
    private JTextField titleInput;
    private JTextArea textInput;
    private JButton addArticleBut;
    private JLabel addArticleLabel;
    private JLabel titleLabel;
    private JLabel textLabel;
    private JLabel separatorLabel;

    public AddArticleForm()
    {
        addArticleInitComponents();
        addArticleBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserList.articles.add(new Article(titleInput.getText(),textInput.getText()));
                dispose();
            }
        });
    }
    private void addArticleInitComponents()
    {
        setContentPane(tab);
        setTitle("Panel přidání článku");
        setSize(600,500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(AddArticleForm.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
