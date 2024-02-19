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
    private JButton addAdminBut;
    private JButton deleteAdminBut;

    public AdminForm()
    {
        adminInitComponents();

        addUserBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserForm();
            }
        });
    }
    private void adminInitComponents()
    {
        setContentPane(tab);
        setTitle("Admin panel");
        setSize(600,500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(AdminForm.DISPOSE_ON_CLOSE);
        setVisible(true);
        adminPrivilegeNo.setText("Úroveň: " + UserList.users.get(MainSystem.userNum).privileges);
    }
}
