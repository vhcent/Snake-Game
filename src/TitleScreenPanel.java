import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Container;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class TitleScreenPanel {
    JFrame frame;
    Container container;

    JPanel titlePanel, highScorePanel, startButtonPanel, exitButtonPanel;
    JLabel titleLabel, highScoreLabel, startButtonLabel, exitButtonLabel;

    Font titleLabelFont = new Font("Papyrus", Font.BOLD, 90);
    Font highScoreLabelFont = new Font("Papyrus", Font.BOLD, 50);
    Font ButtonFont = new Font("Papyrus", Font.BOLD, 40);
    JButton startButton, exitButton;
    int highScore = 0;

    TitleScreenPanel() {

        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 600, 150);
        titlePanel.setBackground(Color.GREEN);
        titleLabel = new JLabel("Snake Game");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(titleLabelFont);
        titlePanel.add(titleLabel);

        highScorePanel = new JPanel();
        highScorePanel.setBounds(75, 175, 425, 100);
        highScorePanel.setBackground(Color.blue);
        highScoreLabel = new JLabel("High Score : " + String.valueOf(highScore));
        highScoreLabel.setForeground(Color.black);
        highScoreLabel.setFont(highScoreLabelFont);
        highScorePanel.add(highScoreLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(200, 325, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("Start");
        startButton.setFont(ButtonFont);
        startButtonPanel.add(startButton);

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(200, 425, 200, 100);
        exitButtonPanel.setBackground(Color.black);
        exitButton = new JButton("Exit");
        exitButton.setFont(ButtonFont);
        exitButtonPanel.add(exitButton);
    }

    public void changeHighScore(int newScore) {
        if (newScore > highScore) {
            highScore = newScore;
            highScoreLabel.setText("High Score : " + String.valueOf(highScore));
            System.out.println("changeHighScore was called: " + String.valueOf(highScore));
        }
    }
}
