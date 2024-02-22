import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminForm extends JFrame {
    private JPanel tab;
    private JLabel adminTitle;
    private JLabel adminPrivilegeNo;
    private JButton addArticleBut;
    private JButton deleteArticleBut;
    private JButton addUserBut;
    private JButton deleteUserBut;

    public AdminForm()
    {
        adminInitComponents();
        PrivCheck();

        addUserBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserForm();
            }
        });
        deleteUserBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteUserForm();
            }
        });
        addArticleBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddArticleForm();
            }
        });
        deleteArticleBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteArticleForm();
            }
        });
    }

    public void PrivCheck()
    {
        switch (UserList.users.get(MainSystem.loggedUser.ID).privileges)
        {
            case 0, 1:
                addUserBut.setVisible(false);
                deleteUserBut.setVisible(false);
                break;
            default:
                break;
        }
    }
    private void adminInitComponents()
    {
        setContentPane(tab);
        setTitle("Admin panel");
        setSize(600,500);
        setMinimumSize(new Dimension(600, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                new MainSystem();
                dispose();
            }
        });
        setVisible(true);
        setLocationRelativeTo(null);
        adminPrivilegeNo.setText("Úroveň: " + UserList.users.get(MainSystem.loggedUser.ID).privileges);
    }
}
