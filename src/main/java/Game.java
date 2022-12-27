import javax.swing.*;

public class Game extends JFrame {

    public Game(int i) {
        System.out.println("test id "+i);
        this.add(new Graphics(i));
        this.setTitle("Snake The Game");
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}