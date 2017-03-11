import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class GameGUI extends JFrame
{
  Game game;
  private static Image cat;
  private JPanel gamePanel;

  public GameGUI(Game requiredGame)
  {
    game = requiredGame;
    setTitle("Cat spawner");
    super.setPreferredSize(new Dimension(500,500));
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.BLACK);
    Container contents = getContentPane();
    contents.setLayout(new BorderLayout());
    gamePanel = new JPanel(null);
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

  public static Image catImage()
  {
    return cat;
  }


  private JLabel[] toDelete = new JLabel[0];
  public void update()
  {
    /*Cat[] cats = game.getCats();
    for (Cat cat : cats)
    {
      JLabel catLabel = new JLabel(new ImageIcon(cat.getImage()));
      catLabel.setBounds(cat.getX(), cat.getY(), 100, 100);
      gamePanel.add(catLabel);
    }
    */

    Map map = game.getMap();

    int[][] mapArray = map.getMapArray();

    int mapSize = map.getSize();

    for(JLabel label : toDelete)
    {
      gamePanel.remove(label);
      label = null;
    }

    for(int y=0; y < mapSize; y++)
      for(int x = 0; x < mapSize; x++)
      {
        if (mapArray[x][y] == 1)
        {
          JLabel catLabel = new JLabel(new ImageIcon(catImage()));
          catLabel.setBounds(x*5, y*5, 100, 100);
          gamePanel.add(catLabel);

          JLabel[] temp = new JLabel[toDelete.length + 1];
          for(int i = 0; i < toDelete.length; i++)
            temp[i] = toDelete[i];
          temp[toDelete.length] = catLabel;
          toDelete = temp;
        }
      }
  }
}
