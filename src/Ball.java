import java.awt.*;

/**
 * Created by stas on 07.06.17.
 */
public class Ball {
    private int dx = 5;
    private int dy = 5;
    private int width = 20;
    private int height = 20;
    private int x;
    private int y = GameScene.HEIGHT / 2;

    public Ball() {
        x = (int) (Math.random() * 850);
        y = (int) (Math.random() * 201) + 300;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, height);

    }

    public void move() {
        y += dy;
        x += dx;

        if (y > GameScene.HEIGHT - 20) {
            //     dy = -dy;
            GameScene.isGame = true;
            GameScene.gameRun = false;
            new GameScene().initGame();
        }

        if (y < 0) {
            dy = -dy;
        }

        if (x < 0) {
            dx = -dx;
        }

        if (x > GameScene.WIDTH - 20) {
            dx = -dx;
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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
