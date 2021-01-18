import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class UserSelection  {

    public UserSelection() {

        JFrame selectedUser = new JFrame();

        JRadioButton clientRadio = new JRadioButton("Клиент", true);
        JRadioButton laborRadio = new JRadioButton("Лаборант", false);
        JRadioButton accountRadio = new JRadioButton("Бухгалтер", false);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(laborRadio);
        radioGroup.add(clientRadio);
        radioGroup.add(accountRadio);

        JButton buttonBack = new JButton("Назад");
        JButton buttonNext = new JButton("Дальше");

        clientRadio.setBounds(30, 30, 150, 30);
        laborRadio.setBounds(30, 60, 150, 30);
        accountRadio.setBounds(30, 90, 150, 30);
        buttonBack.setBounds(240, 90, 150, 30);
        buttonNext.setBounds(240, 30, 150, 30);

        selectedUser.add(clientRadio);
        selectedUser.add(laborRadio);
        selectedUser.add(accountRadio);
        selectedUser.add(buttonBack);
        selectedUser.add(buttonNext);

        buttonBack.setBackground(new Color(216, 245, 255));
        buttonNext.setBackground(new Color(216, 245, 255));

        selectedUser.setSize(430, 260);
        selectedUser.setLayout(null);
        selectedUser.setResizable(false);
        selectedUser.setVisible(true);
        selectedUser.setLocationRelativeTo(null);
        selectedUser.setTitle("Регистрация");
        selectedUser.getContentPane().setBackground(new Color(150, 156, 248));
        selectedUser.setDefaultCloseOperation(HIDE_ON_CLOSE);

        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Переход к регистрации rkbytnf
                if (clientRadio.isSelected()) {
                    selectedUser.dispose();
                    System.gc();
                    new RegistrClient();
                }

                // Переход к регистрации эксперта
                if (laborRadio.isSelected()) {
                    selectedUser.dispose();
                    System.gc();
                    new LaborantPassword();
                }

                if (accountRadio.isSelected()) {
                    selectedUser.dispose();
                    System.gc();
                    new AccontentPassword();
                }
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                selectedUser.dispose();
                System.gc();
                new MenuStart();
            }
        });
    }
}



