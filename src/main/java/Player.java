import java.awt.*;

/**
 * Created by stas on 08.06.17.
 */
public class Player {
    public static boolean LEFT;
    public static boolean RIGTH;
    private int width = 80;
    private int height = 15;
    private int speed = 5;
    private int x = GameScene.WIDTH / 2;
    private int y = GameScene.HEIGHT - 20;

    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRoundRect(x, y, width, height, 10, 10);

    }

    public void move() {
        if (LEFT) {
            x -= speed;
        }

        if (RIGTH) {
            x += speed;
        }
        if (x < 0) {
            x = 0;
        }
        if (x > (GameScene.WIDTH - 80)) {
            x = GameScene.WIDTH - 80;
        }
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
