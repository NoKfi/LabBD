import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class RegistrLaborant extends JFrame {

    private JPasswordField passwordTextPassword;
    private JPasswordField passwordTextRepeatPassword;

    public RegistrLaborant() {
        JFrame frameRegistLaborant = new JFrame();
        JPanel panelRegistLaborant = new JPanel();


        MaskFormatter phoneFormatter = null;
        MaskFormatter dateMask = null;
        try {
            dateMask = new MaskFormatter("####-##-##");
            dateMask.setPlaceholderCharacter('0');

        } catch (
                ParseException ex) {
            ex.printStackTrace();
        }

        try {
            // Определение маски и содание поля ввода мобильного телефона
            phoneFormatter = new MaskFormatter("+7-###-###-##-##");
            phoneFormatter.setPlaceholderCharacter('0');

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel nameWind = new JLabel("Регистрация ");
        JLabel login = new JLabel("Логин для регистрации");
        JLabel password = new JLabel("Введите пароль");
        JLabel passwordRepeat = new JLabel("Повторите пароль");
        JLabel surname = new JLabel("Фамилия");
        JLabel name = new JLabel("Имя");
        JLabel patrnymic = new JLabel("Отчество");
        JLabel dateOfYear = new JLabel("Дата рождения");
        JLabel email = new JLabel("Email");
        JLabel sernumer = new JLabel("Серия и номер");
        JLabel phone = new JLabel("Телефон");
        JLabel numpolice = new JLabel("Номер полиса");
        JLabel typepolice = new JLabel("Тип полиса");

        nameWind.setHorizontalAlignment(SwingConstants.CENTER);
        nameWind.setBounds(10, 10, 322, 30);
        login.setBounds(10, 40, 320, 30);
        password.setBounds(10, 100, 320, 30);
        passwordRepeat.setBounds(10, 160, 320, 30);
        surname.setBounds(10, 220, 320, 30);
        name.setBounds(10, 280, 320, 30);


        JTextField textLogin = new JTextField();
        passwordTextPassword = new JPasswordField();
        passwordTextRepeatPassword = new JPasswordField();
        JTextField textFullName = new JTextField();
        JFormattedTextField textDate = new JFormattedTextField(dateMask);
        JTextField textEmail = new JTextField();


        textLogin.setBounds(10, 70, 320, 30);
        passwordTextPassword.setBounds(10, 130, 320, 30);//textbox
        passwordTextRepeatPassword.setBounds(10, 190, 320, 30);//textbox
        textDate.setBounds(10, 250, 320, 30);
        textEmail.setBounds(10, 310, 320, 30);


        Font fontLabel = new Font("arial", Font.PLAIN, 14);
        nameWind.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameWind.setHorizontalAlignment(SwingConstants.CENTER);
        login.setFont(fontLabel);
        password.setFont(fontLabel);
        passwordRepeat.setFont(fontLabel);
        surname.setFont(fontLabel);
        name.setFont(fontLabel);

        panelRegistLaborant.setLayout(null);
        panelRegistLaborant.add(nameWind);
        panelRegistLaborant.add(login);
        panelRegistLaborant.add(textLogin);
        panelRegistLaborant.add(password);
        panelRegistLaborant.add(passwordTextPassword);
        panelRegistLaborant.add(passwordRepeat);
        panelRegistLaborant.add(passwordTextRepeatPassword);
        panelRegistLaborant.add(surname);
        panelRegistLaborant.add(textFullName);
        panelRegistLaborant.add(name);
        panelRegistLaborant.add(dateOfYear);
        panelRegistLaborant.add(textDate);

        JButton buttonBack = new JButton("Назад");
        buttonBack.setBounds(10, 770, 120, 30);
        buttonBack.setFont(fontLabel);
        panelRegistLaborant.add(buttonBack);

        JButton buttonNext = new JButton("Зарегистрироваться");
        buttonNext.setBounds(140, 770, 190, 30);
        buttonNext.setFont(fontLabel);
        panelRegistLaborant.add(buttonNext);

        frameRegistLaborant.getContentPane().add(panelRegistLaborant);
        frameRegistLaborant.setSize(380, 900);
        frameRegistLaborant.setResizable(false);
        frameRegistLaborant.setVisible(true);
        frameRegistLaborant.getContentPane().setBackground(new Color(150, 156, 248));
        panelRegistLaborant.setBackground(new Color(150, 156, 248));
        frameRegistLaborant.setLocationRelativeTo(null);
        frameRegistLaborant.setTitle("Регистрация Лаборанта");

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRegistLaborant.dispose();
                System.gc();
                new LaborantPanel();
            }
        });
    }

}
