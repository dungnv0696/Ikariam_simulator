package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class MenuButton extends JButton {

    public MenuButton() {
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu.PNG")));
        setContentAreaFilled(false);
        setBorder(null);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            }

            public void mouseExited(MouseEvent e) {
                setBorder(null);
            }
        });
    }

}
