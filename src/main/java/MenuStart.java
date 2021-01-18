import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuStart {


    public MenuStart() {

        JFrame menuStart = new JFrame("Меню");
        menuStart.setSize(640, 480);
        menuStart.setVisible(true);
        menuStart.setResizable(false);
        menuStart.setLocationRelativeTo(null);
        menuStart.getContentPane().setBackground(new Color(150, 156, 248));

        JButton buttonLogin = new JButton("Войти в систему");
        buttonLogin.setBounds(190, 40, 260, 50);
        buttonLogin.setBackground(new Color(216, 245, 255));
        menuStart.getContentPane().add(buttonLogin);

        JButton buttonRegis = new JButton("Зарегестрироваться");
        buttonRegis.setBounds(190, 130, 260, 50);
        buttonRegis.setBackground(new Color(216, 245, 255));
        menuStart.getContentPane().add(buttonRegis);

        JButton buttonRefer = new JButton("Справка");
        buttonRefer.setBounds(190, 210, 260, 50);
        buttonRefer.setBackground(new Color(216, 245, 255));
        menuStart.getContentPane().add(buttonRefer);

        JButton buttonExit = new JButton("Выход");
        buttonExit.setBounds(190, 290, 260, 50);
        buttonExit.setBackground(new Color(216, 245, 255));
        menuStart.getContentPane().add(buttonExit);

        menuStart.getContentPane().setLayout(null);
        menuStart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuStart.dispose();
                System.gc();
                new UserSelection();
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuStart.dispose();
                System.gc();
                new Login();
            }
        });

    }

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(false);
        new MenuStart();
    }
}
