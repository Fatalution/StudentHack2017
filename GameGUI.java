import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class GameGUI extends JFrame
{
  Game game;
  Image image;

  public GameGUI()
  {
    setTitle("Cat spawner");
    super.setPreferredSize(new Dimension(500,500));  
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.BLACK);
    Container contents = getContentPane();
    contents.setLayout(new BorderLayout());
    JPanel gamePanel = new JPanel(null);
    gamePanel.setLayout(null);
    gamePanel.setBounds(0,0,500,500);
    contents.add(gamePanel, BorderLayout.CENTER);
    BufferedImage cat = null;
    try {
      cat = ImageIO.read(new File("cat.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Image image =  cat.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
    // JLabel imageLabel = new JLabel(new ImageIcon(image));
    for (int i = 1; i < 10; i++)
    {
      int x = i*10;
      JLabel temp =new JLabel(new ImageIcon(image));
      temp.setBounds(x,x,100,100);
      gamePanel.add(temp);

    }

    pack();
  }
}
