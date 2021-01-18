import com.sun.deploy.util.SessionState;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;


public class RegistrClient extends JFrame {

    private JPasswordField passwordTextPassword;
    private JPasswordField passwordTextRepeatPassword;

    public RegistrClient() {

        JFrame frameRegistClient = new JFrame();
        JPanel panelRegistrClient = new JPanel();

        getContentPane().setLayout(null);

        MaskFormatter phoneFormatter = null;
        MaskFormatter dateMask = null;
        try {
            dateMask  = new MaskFormatter("####-##-##");
            dateMask.setPlaceholderCharacter('0');

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        try {
            // Определение маски и содание поля ввода мобильного телефона
            phoneFormatter = new MaskFormatter("+7-###-###-##-##");
            phoneFormatter.setPlaceholderCharacter('0');

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel nameWind = new JLabel("Регистрация");
        JLabel login = new JLabel("Логин для регистрации");
        JLabel password = new JLabel("Введите пароль");
        JLabel passwordRepeat = new JLabel("Повторите пароль");
        JLabel surname = new JLabel("Фамилия");
        JLabel name = new JLabel("Имя");
        JLabel patrnymic = new JLabel("Отчество");
        JLabel dateOfYear = new JLabel("Дата рождения" );
        JLabel email = new JLabel("Email");
        JLabel sernumer = new JLabel("Серия и номер");
        JLabel phone = new JLabel("Телефон");
        JLabel numpolice = new JLabel("Номер полиса");
        JLabel typepolice = new JLabel("Тип полиса");

        //nameWind.setHorizontalAlignment(SwingConstants.CENTER);
        nameWind.setBounds(10, 10, 322, 30);
        login.setBounds(10, 40, 320, 30);
        password.setBounds(10, 100, 320, 30);
        passwordRepeat.setBounds(10,160,320,30);
        surname.setBounds(10,220,320,30);
        name.setBounds(10,280, 320,30);
        patrnymic.setBounds(10,340,320,30);
        dateOfYear.setBounds(10,400, 320,30);
        email.setBounds(10,460, 320,30);
        sernumer.setBounds(10, 520, 320, 30);
        phone.setBounds(10, 580, 320, 30);
        numpolice.setBounds(10, 640, 320, 30);
        typepolice.setBounds(10, 700, 320, 30);

        JTextField textClientLogin = new JTextField();
        passwordTextPassword = new JPasswordField();
        passwordTextRepeatPassword = new JPasswordField();
        JTextField textClientSurname = new JTextField();
        JTextField textClietName = new JTextField();
        JTextField textClientPatrnymic = new JTextField();
        JFormattedTextField textClientYear = new JFormattedTextField(dateMask);
        JTextField textClientEmail = new JTextField();
        JTextField textClientSerNum = new JTextField();
        JFormattedTextField textClientPhone = new JFormattedTextField(phoneFormatter);
        JTextField textClientNumPolice = new JTextField();
        JTextField textClientTypeP = new JTextField();

        textClientLogin.setBounds(10, 70, 320, 30);
        passwordTextPassword.setBounds(10,130,320,30);//textbox
        passwordTextRepeatPassword.setBounds(10,190,320,30);//textbox
        textClientSurname.setBounds(10, 250, 320, 30);
        textClietName.setBounds(10, 310, 320, 30);
        textClientPatrnymic.setBounds(10, 370, 320, 30);
        textClientYear.setBounds(10, 430, 320, 30);
        textClientEmail.setBounds(10, 490, 320, 30);
        textClientSerNum.setBounds(10, 550, 322, 30);
        textClientPhone.setBounds(10,610,320,30);
        textClientNumPolice.setBounds(10, 670, 322, 30);
        textClientTypeP.setBounds(10, 730, 322, 30);

        Font fontLabel = new Font("arial",Font.PLAIN, 14);
        nameWind.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameWind.setHorizontalAlignment(SwingConstants.CENTER);
        login.setFont(fontLabel);
        password.setFont(fontLabel);
        passwordRepeat.setFont(fontLabel);
        surname.setFont(fontLabel);
        name.setFont(fontLabel);
        patrnymic.setFont(fontLabel);
        dateOfYear.setFont(fontLabel);
        email.setFont(fontLabel);
        sernumer.setFont(fontLabel);
        phone.setFont(fontLabel);
        numpolice.setFont(fontLabel);
        typepolice.setFont(fontLabel);

        panelRegistrClient.setLayout(null);
        panelRegistrClient.add(nameWind);
        panelRegistrClient.add(login);
        panelRegistrClient.add(textClientLogin);
        panelRegistrClient.add(password);
        panelRegistrClient.add(passwordTextPassword);
        panelRegistrClient.add(passwordRepeat);
        panelRegistrClient.add(passwordTextRepeatPassword);
        panelRegistrClient.add(surname);
        panelRegistrClient.add(textClientSurname);
        panelRegistrClient.add(name);
        panelRegistrClient.add(textClietName);
        panelRegistrClient.add(patrnymic);
        panelRegistrClient.add(textClientPatrnymic);
        panelRegistrClient.add(dateOfYear);
        panelRegistrClient.add(textClientYear);
        panelRegistrClient.add(email);
        panelRegistrClient.add(textClientEmail);
        panelRegistrClient.add(textClietName);
        panelRegistrClient.add(sernumer);
        panelRegistrClient.add(textClientSerNum);
        panelRegistrClient.add(phone);
        panelRegistrClient.add(textClientPhone);
        panelRegistrClient.add(numpolice);
        panelRegistrClient.add(textClientNumPolice);
        panelRegistrClient.add(typepolice);
        panelRegistrClient.add(textClientTypeP);

        JButton buttonBack = new JButton("Назад");
        buttonBack.setBounds(10, 770, 120, 30);
        buttonBack.setFont(fontLabel);
        panelRegistrClient.add(buttonBack);

        JButton buttonNext = new JButton("Зарегистрироваться");
        buttonNext.setBounds(140, 770, 190, 30);
        buttonNext.setFont(fontLabel);
        panelRegistrClient.add(buttonNext);

        frameRegistClient.getContentPane().add(panelRegistrClient);
        frameRegistClient.setSize(380,900);
        frameRegistClient.setResizable(false);
        frameRegistClient.setVisible(true);
        frameRegistClient.getContentPane().setBackground(new Color(150, 156, 248));
        panelRegistrClient.setBackground(new Color(150, 156, 248));
        frameRegistClient.setLocationRelativeTo(null);
        frameRegistClient.setTitle("Регистрация пользователя");

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRegistClient.dispose();
                System.gc();
                new UserSelection();

            }
        });

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login, password = "", repeatPassword = "", surname, name, patronymic, dateYear, email, serNum, phone,
                        numPolice, typePolice;
                char[] charPasswordClient;
                char[] charRepeatPasswordClient;

                login = textClientLogin.getText();
                charPasswordClient = passwordTextPassword.getPassword();
                charRepeatPasswordClient = passwordTextRepeatPassword.getPassword();
                surname = textClientSurname.getText();
                name = textClietName.getName();
                patronymic = textClientPatrnymic.getText();
                dateYear = textClientYear.getText();
                email = textClientEmail.getText();
                serNum = textClientSerNum.getText();
                phone = textClientPhone.getText();
                numPolice = textClientNumPolice.getText();
                typePolice = textClientTypeP.getText();

                if(!(login.equals("")) && !(password.equals("")) && !(surname.equals("")) && !(name.equals(""))
                        && !(patronymic.equals("")) && !(email.equals(""))
                            && !(serNum.equals("")) && !(phone.equals("")) && !(numPolice.equals(""))) {
                    if (Double.parseDouble(dateYear.replace("-", "")) > 18900101
                            && Double.parseDouble(dateYear.replace("-", "")) < 20200101) {
                        if (login.length()<=45){
                            if (password.length() <= 45){
                                if (password.equals(repeatPassword)){
                                    if (surname.length() <= 45){
                                        if (name.length() <= 45){
                                            if (patronymic.length() <= 45){
                                                if (email.length() <= 45){
                                                    if (serNum.length() <= 45){
                                                        if (numPolice.length() <= 45){
                                                            if (typePolice.length() <= 45){
                                                                try {

                                                                    String query = "INSERT INTO mddb.patients (pLogin,"
                                                                            + "pPassword, pSurname, pName, pPatronymic,"
                                                                            + "pDateoyear, pEmail, pSerialnum, pPhone,"
                                                                            + "pNumpolice, pTypepolice) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                                                                    try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(query);) {

                                                                        Date utilDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dateYear);
                                                                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                                                                        preparedStatement.setString(1, login);
                                                                        preparedStatement.setString(2, Verific.getHash(password));
                                                                        preparedStatement.setString(3, surname);
                                                                        preparedStatement.setString(4, name);
                                                                        preparedStatement.setString(5, patronymic);
                                                                        preparedStatement.setString(6, email);
                                                                        preparedStatement.setDate(7, sqlDate);
                                                                        preparedStatement.setString(7, email);
                                                                        preparedStatement.setString(8, serNum);
                                                                        preparedStatement.setString(9, phone);
                                                                        preparedStatement.setString(10, numPolice);
                                                                        preparedStatement.setString(11, typePolice);

                                                                        int rows = preparedStatement.executeUpdate();
                                                                        System.out.printf("%d rows added", rows);

                                                                        preparedStatement.close();
                                                                        ConnectionDB.closeConnection();

                                                                        JOptionPane.showMessageDialog(RegistrClient.this, "Регистрация прошла успешно!",
                                                                                "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                                                                        frameRegistClient.dispose();
                                                                        System.gc();
                                                                        new MenuStart();
                                                                    }
                                                                } catch (Exception ex) {
                                                                    System.out.println("ERROR CONNECTION...");

                                                                    System.out.println(ex);

                                                                }{}
                                                           /* } else {
                                                                JOptionPane.showMessageDialog(RegistrClient.this, "Слишком большая длина поля " , JOptionPane.ERROR_MESSAGE);
                                                            }*/
                                                        } else {
                                                            JOptionPane.showMessageDialog(RegistrClient.this, "Слишком длиный логин", "Предупреждение",
                                                                    JOptionPane.ERROR_MESSAGE);
                                                        }


                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
