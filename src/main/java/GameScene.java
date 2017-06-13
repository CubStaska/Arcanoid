import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by stas on 07.06.17.
 */
public class GameScene extends JPanel implements Runnable {

    public static final int HEIGHT = 600;
    public static final int WIDTH = 900;
    public static boolean isGame;
    public static boolean gameRun = true;
    private Ball balls;
    private Player players;
    private ArrayList<Bricks> bricks;
    private Graphics2D g2;



    public GameScene() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        setBackground(Color.blue);
        setDoubleBuffered(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Player.LEFT = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Player.RIGTH = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!gameRun) {
                        isGame = false;
                        initGame();
                        gameRun = true;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(1);

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Player.LEFT = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Player.RIGTH = false;
                }
            }
        });
        initGame();

    }

    public void initGame() {

        balls = new Ball();
        players = new Player();
        bricks = new Bricks().generateBriks();
        new Thread(this).start();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!isGame) {
            balls.draw(g2);
            players.draw(g2);
            for (Bricks brick : bricks) {
                brick.draw(g2);
            }
        }
        if (isGame) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString("Game Over", WIDTH / 2 - 20, HEIGHT / 2);
            g.drawString("press SPACE new Game", WIDTH / 2 - 60, HEIGHT / 2 + 25);
            g.drawString("press ESC exit Game", WIDTH / 2 - 50, HEIGHT / 2 + 50);
        }

    }


    @Override
    public void run() {
        while (!isGame) {
            try {
                Thread.sleep(10);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balls.move();
            players.move();
            Rectangle ballHit = new Rectangle(balls.getX(), balls.getY(), balls.getWidth(), balls.getHeight());
            Rectangle racketHit = new Rectangle(players.getX(), players.getY(), players.getWidth(), players.getHeight());

            if (ballHit.intersects(racketHit)) {
                balls.setDy(-balls.getDy());
            }
            for (int i = 0; i < bricks.size(); i++) {

                Rectangle brickHints = new Rectangle(bricks.get(i).getX(), bricks.get(i).getY(), bricks.get(i).getWidth(), bricks.get(i).getHeight());
                if (ballHit.intersects(brickHints)) {
                    bricks.remove(i);
                    balls.setDy(-balls.getDy());
                    i--;
                }
            }
            repaint();


        }
    }

}
