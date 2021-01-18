import javax.swing.*;
import java.awt.*;

public class LaborantPanel {

    public LaborantPanel() {

        JFrame windowLaborantPanel = new JFrame();

        JButton registClient = new JButton();
        JButton listClietns =  new JButton();

        windowLaborantPanel.setSize(640, 480);
        windowLaborantPanel.setVisible(true);
        windowLaborantPanel.setResizable(false);
        windowLaborantPanel.setLocationRelativeTo(null);
        windowLaborantPanel.getContentPane().setBackground(new Color(150, 156, 248));
    }
}