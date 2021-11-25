package miPresentacion;

import javax.swing.*;
import java.awt.*;

public class Titulos extends JLabel {
    public Titulos(String titulo, Color colorFondo) {
        this.setText(titulo);
        this.setBackground(colorFondo);
        this.setForeground(Color.black);
        this.setFont(new Font(Font.MONOSPACED,Font.ITALIC+Font.BOLD,12));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}