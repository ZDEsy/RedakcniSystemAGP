import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUserForm extends JFrame{
    private JPanel tab;
    private JLabel delUserLabel;
    private JComboBox userList;
    private JButton delUserBut;
    private JLabel messageLabel;

    public DeleteUserForm()
    {
        delUserInitComponents();
        delUserBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!MainSystem.loggedUser.username.equals(userList.getSelectedItem()))
                {
                    UserList.users.remove(userList.getSelectedIndex());
                    dispose();
                }
                else
                {
                    messageLabel.setText("Nemůžete vymazat sám sebe.");
                }
            }
        });
    }

    public void FillComboBox()
    {
        for(int i = 0; i < UserList.users.size(); i++)
        {
                userList.addItem(UserList.users.get(i).username);
        }
    }
    private void delUserInitComponents() {
        setContentPane(tab);
        setTitle("Delete User Panel");
        setSize(600, 500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(DeleteUserForm.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        FillComboBox();
    }
}
