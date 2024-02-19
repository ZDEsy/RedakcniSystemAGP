import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddUserForm extends JFrame {
    private JPanel tab;
    private JLabel addUserTitle;
    private JButton submitBut;
    private JComboBox privsList;
    private JTextField passInput;
    private JTextField ageInput;
    private JTextField usernameInput;
    private JLabel usernameLabel;
    private JLabel ageLabel;
    private JLabel passwordLabel;
    private JLabel privLabel;


    public AddUserForm()
    {
        addUserInitComponents();
        submitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserList.users.add(new User(UserList.users.size(),usernameInput.getText(),ageInput.getText(),passInput.getText(),privsList.getSelectedIndex()));
                System.out.println(UserList.users.get(0).username + " " + UserList.users.get(1).username);
            }
        });
    }
    private void addUserInitComponents()
    {
        setContentPane(tab);
        setTitle("Panel přdání uživatele");
        setSize(600,500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(AddUserForm.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
