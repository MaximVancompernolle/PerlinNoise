import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launcher {
    static PerlinNoise noise;
    static Vector3[] coordinates;
    static int lengthOfMap = 100;

    public static void main(String[] args) {
        noise = new PerlinNoise(lengthOfMap);
        coordinates = noise.generateCoordinates(3, .2f, 5);

        new Game(coordinates);
    }
}

class Game extends JFrame {
    int TILE_SIZE = 5;
    int LENGTH;

    JPanel background;
    Tile[] tiles;

    public Game(Vector3[] coordinates) {
        LENGTH = (int) Math.sqrt(coordinates.length);
        tiles = new Tile[coordinates.length];

        setSize(LENGTH * TILE_SIZE, LENGTH * TILE_SIZE);
        setTitle("Perlin Noise");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        background = new JPanel();
        background.setLayout(null);
        background.setBounds(0, 0, LENGTH * TILE_SIZE, LENGTH * TILE_SIZE);

        int id = 0;
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < LENGTH; y++) {
                tiles[id] = new Tile(x, y, coordinates[id].y, TILE_SIZE);
                background.add(tiles[id]);
                id++;
            }
        }

        add(background);
        setVisible(true);
    }
}

class Vector3 {
    int x;
    float y;
    int z;

    public Vector3(int x, float y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}