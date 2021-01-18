import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminPanel extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AdminPanel() {
        JFrame frameAdmin = new JFrame("Панель управления");

        frameAdmin.getContentPane().setLayout(null);

        JButton buttonReserveCopyBD = new JButton("Резервное копирование базы данных");
        JButton buttonRequestInfo = new JButton("Список проектов");
        JButton buttonRating = new JButton("Оценки проектов");
        JButton buttonContestantInfo = new JButton("Список конкурсантов");
        JButton buttonSignOut = new JButton("Выйти в меню");
        JButton buttonExit = new JButton("Закрыть приложение");

        buttonRequestInfo.setBounds(10, 10, 274, 30);
        buttonContestantInfo.setBounds(10, 50, 274, 30);
        buttonRating.setBounds(10, 90, 274, 30);
        buttonReserveCopyBD.setBounds(10, 130, 274, 30);
        buttonSignOut.setBounds(10, 170, 274, 30);
        buttonExit.setBounds(10, 210, 274, 30);

        frameAdmin.getContentPane().add(buttonRequestInfo);
        frameAdmin.getContentPane().add(buttonContestantInfo);
        frameAdmin.getContentPane().add(buttonRating);
        frameAdmin.getContentPane().add(buttonReserveCopyBD);
        frameAdmin.getContentPane().add(buttonSignOut);
        frameAdmin.getContentPane().add(buttonExit);

        frameAdmin.setSize(300, 284);
        frameAdmin.setVisible(true);
        frameAdmin.setResizable(false);
        frameAdmin.setLocationRelativeTo(null);

        buttonRequestInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdmin.dispose();
                System.gc();
                new MenuStart();//requestInfo
            }
        });

        buttonContestantInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdmin.dispose();
                System.gc();
                new MenuStart();//contestantsInfrometion
            }
        });

        buttonRating.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdmin.dispose();
                System.gc();
                new MenuStart();//ruqestrating
            }
        });

        buttonReserveCopyBD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Backupdbtosql();
            }
        });

        buttonSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdmin.dispose();
                System.gc();
                Login.setIdAdmin(0);
                new MenuStart();//homepage
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });



    }

    public static void Backupdbtosql() {
        try {

            File file = new File("backup/backup.sql");
            if (file.delete()) {
                System.out.println("backup.sql удален");
            } else
                System.out.println("Файл не обнаружен");
            /* NOTE: Getting path to the Jar file being executed */
            /* NOTE: YourImplementingClass-> replace with the class executing the code */
            CodeSource codeSource = AdminPanel.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            System.out.println(jarDir);

            /* NOTE: Creating Database Constraints */
            String dbName = "mydb";
            String dbUser = "root";
            String dbPass = "root";

            /* NOTE: Creating Path Constraints for folder saving */
            /* NOTE: Here the backup folder is created for saving inside it */

            /* NOTE: Creating Path Constraints for backup saving */
            /*
             * NOTE: Here the backup is saved in a folder called backup with the name
             * backup.sql
             */
            String savePath = jarDir + "\\backup\\" + "backup.sql";
            System.out.println(savePath);
            /* NOTE: Used to create a cmd command */
            String executeCmd = "cmd /c cd C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\ && mysqldump -u" + dbUser
                    + " -p" + dbPass + " " + dbName + " > " + savePath;
            System.out.println(executeCmd);

            /* NOTE: Executing the command here */
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*
             * NOTE: processComplete=0 if correctly executed, will contain other values if
             * not
             */
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure" + processComplete);
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }

}
