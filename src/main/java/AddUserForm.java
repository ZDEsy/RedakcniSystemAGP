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
                if (SameUsernameCheck())
                {
                    UserList.users.add(new User(usernameInput.getText(),ageInput.getText(),passInput.getText(),privsList.getSelectedIndex()));
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Uživatel se stejným jménem již existuje.");
                }
            }
        });
    }
    public boolean SameUsernameCheck()
    {
        for(int i = 0; i < UserList.users.size(); i++)
        {
            if(UserList.users.get(i).username.equals(usernameInput.getText()))
            {
                return false;
            }
        }
        return true;
    }

    public void PrivCheck()
    {
        switch (UserList.users.get(MainSystem.loggedUser.ID).privileges)
        {
            case 0, 1, 2:
                privsList.removeItemAt(3);
                break;
        }
    }

    private void addUserInitComponents()
    {
        setContentPane(tab);
        setTitle("Panel přidání uživatele");
        setSize(600,500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(AddUserForm.DISPOSE_ON_CLOSE);
        setVisible(true);
        PrivCheck();
    }
}
