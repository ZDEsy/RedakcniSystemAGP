import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteArticleForm extends JFrame{
    private JPanel tab;
    private JComboBox articleList;
    private JButton delArtBut;
    private JLabel delArtLabel;
    private JLabel messageLabel;

    public DeleteArticleForm()
    {
        delArticleInitComponents();


        delArtBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(!(MainSystem.loggedUser.privileges == 0 && !(UserList.articles.get(articleList.getSelectedIndex()).creator.equals(MainSystem.loggedUser.username))))
                    {
                        UserList.articles.remove(articleList.getSelectedIndex());
                        dispose();
                    }
                    else
                    {
                        messageLabel.setText("Nemáte oprávnění mazat články ostatních uživatelů");
                    }
                }
                catch (Exception y)
                {
                    messageLabel.setText("Žádný článek k odstranění.");
                }


            }
        });
    }

    public void FillComboBox()
    {
        for(int i = 0; i < UserList.articles.size(); i++)
        {
            articleList.addItem("Titulek: " + UserList.articles.get(i).title + ", Autor: " + UserList.articles.get(i).creator);
        }
    }
    private void delArticleInitComponents() {
        setContentPane(tab);
        setTitle("Delete Article Panel");
        setSize(600, 500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(DeleteUserForm.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        FillComboBox();
    }
}
