import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame{
    JFrame frame = new JFrame();
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel botPnl;

    JLabel titleLbl;
    JTextArea displayResults;
    JScrollPane scroller;

    JButton quitButton;
    JButton paperButton;
    ImageIcon paperImage;
    JButton rockButton;
    ImageIcon rockImage;
    JButton scissorsButton;
    ImageIcon scissorsImage;

    private String results;


    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        createMiddlePanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);
        createBottomPanel();
        mainPnl.add(botPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel()
    {
        topPnl = new JPanel();
        titleLbl = new JLabel("Rock Paper Scissors",JLabel.CENTER);
        titleLbl.setFont(new Font("SansSerif", Font.BOLD, 38));

        topPnl.add(titleLbl);
    }
    private void createMiddlePanel()
    {
        midPnl = new JPanel();
        displayResults = new JTextArea(20,60);
        scroller = new JScrollPane(displayResults);
        midPnl.add(scroller);
    }
    private void createBottomPanel()
    {
        botPnl = new JPanel();
        botPnl.setLayout(new GridLayout(1,2));
        rockImage = new ImageIcon("src/rock.png");
        paperImage = new ImageIcon("src/paper.png");
        scissorsImage = new ImageIcon("src/scissors.png");
        rockButton = new JButton(rockImage);
        paperButton = new JButton(paperImage);
        scissorsButton = new JButton(scissorsImage);
        quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        rockButton.addActionListener(
                (ActionEvent ae) -> {
                    displayResults.append(gameRun(1) + "\n");
                });
        paperButton.addActionListener(
                (ActionEvent ae) -> {
                    displayResults.append(gameRun(2)+ "\n");
                });
        scissorsButton.addActionListener(
                (ActionEvent ae) -> {
                    displayResults.append(gameRun(3)+ "\n");
                });
        botPnl.add(rockButton);
        botPnl.add(paperButton);
        botPnl.add(scissorsButton);
        botPnl.add(quitButton);
    }

    private String gameRun(int Choice) {
        Random rand = new Random();
        int computerChoice = rand.nextInt(1, 4);
        //rock = 1, paper = 2, scissors = 3
        String results = "";
        if (computerChoice == Choice) {
            results = "It's a tie!";
        } else {
            switch (Choice) {
                case 1 -> {
                    if (computerChoice == 2) {
                        results = "Paper beats rock (Computer wins)";
                    } else {
                        results = "Rock beats scissors (Player wins)";
                    }
                }
                case 2 -> {
                    if (computerChoice == 1) {
                        results = "Paper beats rock (Player Wins)";
                    } else {
                        results = "Scissors beats paper (Computer Wins)";
                    }
                }
                case 3 -> {
                    if (computerChoice == 1) {
                        results = "Rock beats scissors (Computer Wins)";
                    } else {
                        results = "Scissors beats Rock (Player Wins)";
                    }
                }
            }
        }
        return results;
    }
    }

