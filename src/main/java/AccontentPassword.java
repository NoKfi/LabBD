import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccontentPassword extends Component {

    private JPasswordField passwordField;

    public AccontentPassword () {

        JFrame frameVerifycishion = new JFrame();
        frameVerifycishion.getContentPane().setBackground(new Color(150, 156, 248));
        frameVerifycishion.setLayout(null);

        frameVerifycishion.setLocationRelativeTo(null);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 40, 384, 30);
        frameVerifycishion.getContentPane().add(passwordField);

        JButton buttonRegistrationLaborant = new JButton("Перейти к регистрации");
        buttonRegistrationLaborant.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonRegistrationLaborant.setSize(230, 30);
        buttonRegistrationLaborant.setLocation(164, 80);

        JLabel labelRegistration = new JLabel("Введите пароль для регистрации");
        labelRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRegistration.setSize(384, 30);
        labelRegistration.setLocation(10, 10);

        frameVerifycishion.getContentPane().add(labelRegistration);
        frameVerifycishion.getContentPane().add(buttonRegistrationLaborant);

        JButton buttonBack = new JButton("Назад");
        buttonBack.setBounds(10, 80, 144, 30);
        frameVerifycishion.getContentPane().add(buttonBack);

        frameVerifycishion.setSize(420, 158);
        frameVerifycishion.setResizable(false);
        frameVerifycishion.setVisible(true);
        frameVerifycishion.setLocationRelativeTo(null);

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameVerifycishion.dispose();
                System.gc();
                new UserSelection();
            }
        });

        buttonRegistrationLaborant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = "q";
                String passwordCheck;

                char[] charPassword;

                charPassword = passwordField.getPassword();
                passwordCheck = new String(charPassword);

                if (password.equals(passwordCheck)) {
                    frameVerifycishion.dispose();
                    System.gc();
                    new RegistrLaborant();
                }else {
                    JOptionPane.showMessageDialog(AccontentPassword.this, "Неверный пароль доступа",
                            "Предупреждение", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
