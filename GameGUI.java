import java.awt.*;
import javax.swing.*;

public class GameGUI extends JFrame
{
  Game game;
  Image image;

  public GameGUI()
  {
    setTitle("Cat spawner");
    //setPreferredSize(new Dimension(500, 500));
    setSize(500,500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.BLACK);
  //  setDoubleBuffered(true);

    //loading image
    ImageIcon icon = new ImageIcon("cat.png");
    image = icon.getImage();
    JLabel imageLabel = new JLabel(icon);
    add(imageLabel);

    pack();
  }
}
