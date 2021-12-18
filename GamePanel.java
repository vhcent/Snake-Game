import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHeight = 600;
    static final int snakeSize = 20;
    static final int appleSize = 20;
    static final int DELAY = 175;
    static final int numOfGrid = (panelWidth * panelHeight) / (snakeSize * snakeSize);
    static boolean gameOver = false;
    Timer timer;
    Random random;
    Apple apple;
    Snake snake;

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHeight);
        super.setBackground(Color.BLACK);
        this.setFocusable(true);
        setVisible(true);
        timer = new Timer(DELAY, this);
        timer.start();
        newApple();
        snake = new Snake();
        snake.updateSnake();
    }

    public class Apple {
        int appleXCoordinate;
        int appleYCoordinate;

        Apple() {
            appleXCoordinate = random.nextInt((int) (panelWidth / appleSize)) * appleSize;
            appleYCoordinate = random.nextInt((int) (panelWidth / appleSize)) * appleSize;
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);
            g2d.fillRect(apple.appleXCoordinate, apple.appleYCoordinate, appleSize, appleSize);
        }
    }

    public void newApple() {
        apple = new Apple();
    }

    public class Snake {
        int applesEaten = 0;
        int segments = 3;
        String direction = "Right";
        final int[] snakeXCoordinates = new int[numOfGrid];
        final int[] snakeYCoordinates = new int[numOfGrid];

        Snake() {
            snakeXCoordinates[0] = 300;
            snakeXCoordinates[1] = 280;
            snakeXCoordinates[2] = 260;
            snakeYCoordinates[0] = 300;
            snakeYCoordinates[1] = 300;
            snakeYCoordinates[2] = 300;
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < segments; i++) {
                g2d.setColor(Color.green);
                g2d.fillRect(snakeXCoordinates[i], snakeYCoordinates[i], snakeSize, snakeSize);
            }
        }

        public void updateSnake() {

            for (int i = segments; i > 0; i--) {
                snakeXCoordinates[i] = snakeXCoordinates[i - 1];
                snakeYCoordinates[i] = snakeYCoordinates[i - 1];
            }

            if (direction == "Right") {
                snakeXCoordinates[0] = snakeXCoordinates[0] + snakeSize;
            }

        }
    }

    // @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        apple.paintComponent(g);
        snake.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        snake.updateSnake();
        repaint();
    }

}