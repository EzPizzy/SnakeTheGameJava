import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.Border;

public class Graphics extends JPanel implements ActionListener {
//ustalamy rozmiar planszy jak i wielkości naszego wonsza rzecznego :D podane tu rozmiary wykorzystywane sa w innych klasach
    static final int WIDTH = 800;
    static final int HEIGHT = 400;
    static final int HEAD_OF_SNAKE = 25;
    static final int BOARD_SIZE = (WIDTH * HEIGHT) / (HEAD_OF_SNAKE * HEAD_OF_SNAKE);

    final Font font = new Font("Impact", Font.BOLD, 22);
    //pozycjonowanie względem osi x oraz y
    int[] snakePosX = new int[BOARD_SIZE];
    int[] snakePosY = new int[BOARD_SIZE];
    int snakeLength;
//klasa food
    Food food;
    int foodEaten;
//domślnie waz rusza sie w prawo
    char direction = 'R';
    boolean isMoving = false;
    int user_ids=0;
    final Timer timer = new Timer(79, this);


    public Graphics(int userid) {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setFocusable(true);
        this.user_ids=userid;
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (isMoving) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if (direction != 'R') {
                                direction = 'L';
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (direction != 'L') {
                                direction = 'R';
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (direction != 'D') {
                                direction = 'U';
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (direction != 'U') {
                                direction = 'D';
                            }
                            break;
                    }
                } else {
                    start();
                }
            }
        });

        start();
    }

    protected void start() {
        snakePosX = new int[BOARD_SIZE];
        snakePosY = new int[BOARD_SIZE];
        snakeLength = 5;
        foodEaten = 0;
        direction = 'R';
        isMoving = true;
        spawnFood();
        timer.start();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);


        if (isMoving) {
            g.setColor(Color.white);
            g.fillOval(food.getPosX(), food.getPosY(), HEAD_OF_SNAKE, HEAD_OF_SNAKE);

            g.setColor(Color.red);
            for (int i = 0; i < snakeLength; i++) {
                g.fillRect(snakePosX[i], snakePosY[i], HEAD_OF_SNAKE, HEAD_OF_SNAKE);
            }
        } else {
            String scoreText="";
            if (foodEaten>0) {
                 scoreText = String.format("zjadasz swój własny ogon...\n Wynik: %d \n Naciśnij dowolny przycisk aby zacząć od nowa", foodEaten);
            }
            else  scoreText = String.format("Mniej niż zero oh oh oh oh chociaż twój wynik to %d", foodEaten);
            int row=0;
            int user_id=2;
            try{

                ResultSet result= QueryExecutor.executeSelect("SELECT COUNT(*) AS COUNT FROM \"Games\" ");
                while(result.next()) {
                    row=result.getInt("COUNT")+1;

                }


                QueryExecutor.executeQuery("INSERT INTO \"Games\"( \"Id_game\", \"Id_user\", \"score\")  Values("+row+", '"+user_ids+"','"+ foodEaten +"')");


                //String username= result.getString("User_name");


            }
            catch (SQLException e) {
                e.getStackTrace();
            }
            g.setColor(Color.red);
            g.setFont(font);
            g.drawString(scoreText, (WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, HEIGHT / 2);
        }
    }

    protected void move() {
        for (int i = snakeLength; i > 0; i--) {
            snakePosX[i] = snakePosX[i-1];
            snakePosY[i] = snakePosY[i-1];
        }

        switch (direction) {
            case 'U' -> snakePosY[0] -= HEAD_OF_SNAKE;
            case 'D' -> snakePosY[0] += HEAD_OF_SNAKE;
            case 'L' -> snakePosX[0] -= HEAD_OF_SNAKE;
            case 'R' -> snakePosX[0] += HEAD_OF_SNAKE;
        }
    }

    protected void spawnFood() {
        food = new Food();
    }

    protected void eatFood() {
        if ((snakePosX[0] == food.getPosX()) && (snakePosY[0] == food.getPosY())) {
            snakeLength++;
            foodEaten++;
            spawnFood();
        }
    }

    protected void collisionTest() {
        for (int i = snakeLength; i > 0; i--) {
            if ((snakePosX[0] == snakePosX[i]) && (snakePosY[0] == snakePosY[i])) {
                isMoving = false;
                break;
            }
        }

        if (snakePosX[0] < 0 || snakePosX[0] > WIDTH - HEAD_OF_SNAKE || snakePosY[0] < 0 || snakePosY[0] > HEIGHT - HEAD_OF_SNAKE) {
            isMoving = false;
        }

        if (!isMoving) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isMoving) {
            move();
            collisionTest();
            eatFood();
        }

        repaint();
    }
}