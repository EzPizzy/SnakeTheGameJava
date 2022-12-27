import java.util.Random;

public class Food {

    private final int posX;
    private final int posY;

    public Food() {
        posX = generatePos(Graphics.WIDTH);
        posY = generatePos(Graphics.HEIGHT);
    }

    private int generatePos(int size) {
        Random random = new Random();
        return random.nextInt(size / Graphics.HEAD_OF_SNAKE) * Graphics.HEAD_OF_SNAKE;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}