import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainPage extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MainPage() {

        JFrame frameMainPage = new JFrame();
        // frameContestant.setLayout(new BorderLayout());
        frameMainPage.getContentPane().setBackground(new Color(150, 156, 248));
        frameMainPage.getContentPane().setLayout(null);

        JButton buttonProfile = new JButton("Мой профиль");
        JButton buttonCreateRequest = new JButton("Новый заказ");
        JButton buttonContests = new JButton("Список заказов");
        JButton buttonSignOut = new JButton("Выйти из профиля");
        JButton buttonExit = new JButton("Зыкрыть приложение");

        buttonProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonCreateRequest.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonContests.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonSignOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonExit.setFont(new Font("Tahoma", Font.PLAIN, 14));

        String contestantSurname = null, contestantName = null;

        /*try {
            Statement statement = ConnectionToDatabase.getConnection().createStatement();
            String query = "SELECT * FROM mydb.contestant WHERE (idContestant Like '%" + Login.getIdContestant()
                    + "%')";

            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {

                contestantSurname = resultset.getString(2);
                contestantName = resultset.getString(3);

            }
            resultset.close();
            statement.close();
            ConnectionToDatabase.closeConnection();

            frameMainPage.setTitle("Вы вошли как: " + contestantSurname + " " + contestantName);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        buttonProfile.setBounds(10, 10, 335, 30);
        buttonCreateRequest.setBounds(10, 50, 335, 30);
        buttonContests.setBounds(10, 90, 335, 30);
        buttonSignOut.setBounds(10, 130, 335, 30);
        buttonExit.setBounds(10, 170, 335, 30);

        frameMainPage.getContentPane().add(buttonProfile);
        frameMainPage.getContentPane().add(buttonCreateRequest);
        frameMainPage.getContentPane().add(buttonContests);
        frameMainPage.getContentPane().add(buttonSignOut);
        frameMainPage.getContentPane().add(buttonExit);

        frameMainPage.setSize(364, 250);
        frameMainPage.setResizable(false);
        frameMainPage.setVisible(true);
        frameMainPage.setLocationRelativeTo(null);

       /* buttonCreateRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameMainPage.dispose();
                System.gc();
                new RegistrationRequest();
            }
        });

        buttonContests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameMainPage.dispose();
                System.gc();
                new RequestInformation();
            }
        });

        buttonProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frameMainPage.dispose();
                System.gc();
                new ContestantProfile();
            }
        });

        buttonSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frameMainPage.dispose();
                System.gc();
                Login.setIdContestant(null);
                new HomePage();
            }
        });*/

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(EXIT_ON_CLOSE);
            }
        });

    }

    public MainPage(String expert) {

        JFrame frameExpertMainPage = new JFrame();
        // frameContestant.setLayout(new BorderLayout());
        frameExpertMainPage.getContentPane().setLayout(null);

        JButton buttonProfile = new JButton("Мой профиль");
        JButton buttonAllRequest = new JButton("Просмотреть все проекты");
        JButton buttonSignOut = new JButton("Выйти из профиля");
        JButton buttonExit = new JButton("Зыкрыть приложение");

        buttonProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonAllRequest.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonSignOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonExit.setFont(new Font("Tahoma", Font.PLAIN, 14));

        String expertSurname = null, expertName = null;

        /*try {
            Statement statement = ConnectionToDatabase.getConnection().createStatement();
            String query = "SELECT * FROM mydb.expert WHERE (idExpert Like '%" + Login.getIdExpert()
                    + "%')";

            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {

                expertSurname = resultset.getString(2);
                expertName = resultset.getString(3);

            }
            resultset.close();
            statement.close();
            ConnectionToDatabase.closeConnection();

            frameExpertMainPage.setTitle("Вы вошли как: " + expertSurname + " " + expertName);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        buttonProfile.setBounds(10, 10, 335, 30);
        buttonAllRequest.setBounds(10, 50, 335, 30);
        buttonSignOut.setBounds(10, 90, 335, 30);
        buttonExit.setBounds(10, 130, 335, 30);

        frameExpertMainPage.getContentPane().add(buttonProfile);
        frameExpertMainPage.getContentPane().add(buttonAllRequest);
        frameExpertMainPage.getContentPane().add(buttonSignOut);
        frameExpertMainPage.getContentPane().add(buttonExit);

        frameExpertMainPage.setSize(364, 200);
        frameExpertMainPage.setResizable(false);
        frameExpertMainPage.setVisible(true);
        frameExpertMainPage.setLocationRelativeTo(null);


        /*buttonAllRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameExpertMainPage.dispose();
                System.gc();
                new RequestInformation();
            }
        });

        buttonProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frameExpertMainPage.dispose();
                System.gc();
                new ExpertProfile();
            }
        });

        buttonSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frameExpertMainPage.dispose();
                System.gc();
                Login.setIdExpert(null);
                new HomePage();
            }
        });*/

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
    }
}
