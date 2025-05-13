package advancequizgame.Utilities;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddHoverEffect {

    public static void addHoverEffect(JButton button, Color hoverBg, Color hoverFg, Color defaultBg, Color defaultFg) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverBg);
                button.setForeground(hoverFg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultBg);
                button.setForeground(defaultFg);
            }
        });
    }
}
