import java.util.Random;

public class Food {

   //zmienne odpowiadajace za pozycje jedzonka
    private final int posX;
    private final int posY;
//metoda generujaca randomowo pozycje jedzonka, bierze pod uwage podany rozmiar oraz wielkosc weza
    private int generatePos(int sizeOF) {
        Random random = new Random();
        return random.nextInt(sizeOF / Graphics.HEAD_OF_SNAKE) * Graphics.HEAD_OF_SNAKE;
    }
    //ustalenie pozycji jedzonka na osiach
    public Food() {
        posX = generatePos(Graphics.WIDTH);
        posY = generatePos(Graphics.HEIGHT);
    }



    //GETTERY POZYCJI
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}