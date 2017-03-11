import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class GameGUI extends JFrame
{
  Game game;
  private Image cat;
  JLabel[] cat = new JLabel[0];

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
    BufferedImage tempCat = null;
    try {
      tempCat = ImageIO.read(new File("cat.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    cat =  tempCat.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
    
    /*
    for (int i = 1; i < 10; i++)
    {
      int x = i*10;
      JLabel temp =new JLabel(new ImageIcon(image));
      temp.setBounds(x,x,100,100);
      gamePanel.add(temp);

    }
    */
    pack();
  }

  public Image catImage()
  {
    return cat;
  }

  public void update()
  {
    
  }
}
