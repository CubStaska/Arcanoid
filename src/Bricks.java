import java.awt.*;
import java.util.ArrayList;

/**
 * Created by stas on 09.06.17.
 */
public class Bricks {
    private int width = 55;
    private int height = 25;
    private int x;
    private int y;

    public Bricks(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bricks() {
    }

    public ArrayList<Bricks> generateBriks() {
        ArrayList<Bricks> bricks = new ArrayList<>();
        int x = 20;
        int y = 15;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                x += 10;
                bricks.add(new Bricks(x, y));
                x += 55;
            }
            x = 20;
            y += 35;
        }
        return bricks;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fill3DRect(x, y, width, height, true);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
