import javax.swing.*;

public class Game extends JFrame {

    public Game(int i) {
        //tworzymy nowe okno do gry, przekazujemy id usera
        this.add(new Graphics(i));
        //tytuł okna
        this.setTitle("Snake The Game");
        this.pack();
        //działanie po naciśnięciu x
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //blokowanie zmiany rozmiaru okna- gdy jest true to nie jest okno responsywne
        this.setResizable(false);
        //widocznosc okna
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}