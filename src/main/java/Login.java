import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Login extends JFrame {

    /**
     *
     */
    private static String idContestant;
    private static String idExpert;
    private static int idAdmin;

    public static String getIdContestant() {
        return idContestant;
    }

    public static void setIdContestant(String idContestant) {
        Login.idContestant = idContestant;
    }

    public static String getIdExpert() {
        return idExpert;
    }

    public static void setIdExpert(String idExpert) {
        Login.idExpert = idExpert;
    }

    public static int getIdAdmin() {
        return idAdmin;
    }

    public static void setIdAdmin(int idAdmin) {
        Login.idAdmin = idAdmin;
    }

    private static final long serialVersionUID = 1L;

    private int counter = 0;
    private JPasswordField textPassword;

    public Login() {

        JFrame frameLogin = new JFrame("Вход в учетную запись");
        frameLogin.getContentPane().setLayout(null);
        frameLogin.getContentPane().setBackground(new Color(150, 156, 248));

        JRadioButton radioButtonClient= new JRadioButton("Пациент", true);
        JRadioButton radioButtonLaborant = new JRadioButton("Лаборант", false);
        JRadioButton radioButtonAcc = new JRadioButton("Бухгалтер");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButtonLaborant);
        radioGroup.add(radioButtonClient);
        radioGroup.add(radioButtonAcc);

        JLabel labelLogin = new JLabel("Адрес электронной почты");
        JLabel labelPassword = new JLabel("Пароль");
        JLabel labelForgotPassword = new JLabel("Забыли пароль?", SwingConstants.LEFT);

        JTextField textLogin = new JTextField();

        JButton buttonLogin = new JButton("Войти");
        JButton buttonBack = new JButton("Назад");

        radioButtonClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radioButtonLaborant.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radioButtonAcc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

        radioButtonClient.setBounds(10, 200, 100, 30);
        radioButtonLaborant.setBounds(140, 200, 100, 30);
        radioButtonAcc.setBounds(270,200, 100, 30);
        labelLogin.setBounds(10, 10, 364, 30);
        labelPassword.setBounds(10, 90, 364, 30);
        labelForgotPassword.setBounds(10, 160, 254, 30);
        textLogin.setBounds(10, 50, 364, 30);
        buttonLogin.setBounds(270, 240, 100, 30);
        buttonBack.setBounds(140, 240, 100, 30);

        frameLogin.getContentPane().add(labelLogin);
        frameLogin.getContentPane().add(labelPassword);
        frameLogin.getContentPane().add(textLogin);
        frameLogin.getContentPane().add(radioButtonClient);
        frameLogin.getContentPane().add(radioButtonLaborant);
        frameLogin.getContentPane().add(radioButtonAcc);
        frameLogin.getContentPane().add(buttonBack);
        frameLogin.getContentPane().add(buttonLogin);
        frameLogin.getContentPane().add(labelForgotPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(10, 130, 364, 30);
        frameLogin.getContentPane().add(textPassword);

        frameLogin.setSize(400, 322);
        frameLogin.setResizable(false);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setVisible(true);

        labelForgotPassword.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(++counter);
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameLogin.dispose();
                System.gc();
                new MenuStart();
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonLaborant.isSelected()){
                    frameLogin.dispose();
                    System.gc();
                    new MainPage();
                }
            }
        });
    }
}