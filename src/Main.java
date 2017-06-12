import javax.swing.*;

/**
 * Created by stas on 07.06.17.
 */
public class Main {

    public static void main(String[] args) {
        JFrame myframe = new JFrame("Arkanoid");
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setResizable(false);
        myframe.setContentPane(new GameScene());
        myframe.pack();
        myframe.setLocationRelativeTo(null);
        myframe.setVisible(true);

    }
}
