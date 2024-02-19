import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSystem extends JFrame {
    private JPanel tab;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton loginBut;
    private JPasswordField passwordInput;
    private JTextField usernameInput;

    public MainSystem()
    {
        mainInitComponents();
        User AdminUser = new User("Admin","17","Admin",3);
        UserList.users.add(AdminUser);
        loginBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CorrectLogin();
            }
        });
    }

    static User loggedUser;
    public void CorrectLogin()
    {
        for(int i = 0; i < UserList.users.size(); i++)
        {
            if(usernameInput.getText().equals(UserList.users.get(i).username) && String.valueOf(passwordInput.getPassword()).equals(UserList.users.get(i).password))
            {
                System.out.println("Správně");
                loggedUser = UserList.users.get(i);
                new AdminForm();
                dispose();
            }
            else if(i == UserList.users.size()-1)
            {
                usernameInput.setText(null);
                passwordInput.setText(null);
                JOptionPane.showMessageDialog(null,"Špatné přihlašovací údaje.");
            }
        }
    }
    private void mainInitComponents()
    {
        setContentPane(tab);
        setTitle("Redakční systém");
        setSize(600,500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(MainSystem.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainSystem();
    }
}
