import javax.swing.JPanel;
import java.awt.Color;

public class Tile extends JPanel {
    public Tile(int x, int y, float perlinScale, int size) {
        setLayout(null);
        int rgb = (int) perlinScale * 10;
        rgb = 255 - rgb;

        if (rgb > 255) rgb = 255;
        else if (rgb < 0) rgb = 0;

        setBackground(new Color(rgb, rgb, rgb));
        setBounds(x * size, y * size, size, size);
    }
}
