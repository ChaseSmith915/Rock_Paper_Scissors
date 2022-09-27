import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        displayResults = new JTextArea(10,60);
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

        botPnl.add(rockButton);
        botPnl.add(paperButton);
        botPnl.add(scissorsButton);
        botPnl.add(quitButton);



    }
}
