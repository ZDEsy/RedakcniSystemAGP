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
    private JPasswordField passInput;
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
                if (SameUsernameCheck() && AllFilled() && OnlyDigits())
                {
                    UserList.users.add(new User(usernameInput.getText(),ageInput.getText(),String.valueOf(passInput.getPassword()),privsList.getSelectedIndex()));
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Chyba. Ujistěte se, že jste vyplnili všechny pole, zadali číslo do položky věku a že se vaše uživatelské jméno neshoduje s jiným uživatelem.");
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

    public boolean AllFilled()
    {
        return !(usernameInput.getText().isEmpty() || ageInput.getText().isEmpty() || String.valueOf(passInput.getPassword()).isEmpty());
    }
    public boolean OnlyDigits()
    {
        String toCheck = ageInput.getText().replaceAll("[^\\d.]", "");
        return !toCheck.isEmpty();
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
        setLocationRelativeTo(null);
        PrivCheck();
    }
}
