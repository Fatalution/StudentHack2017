import java.util.concurrent.TimeUnit;


public class Game
{
  //storing number of cats
  private int numberOfCats = 2;

  private int mapCountDown = 3;

  private GameGUI window;

  //cats array
  private Cat[] catArray = new Cat[100];

  private Map map;

  public Game()
  {
    map = new Map(20);
    //creating first 2 cats
    catArray[0] = new Cat(0, 1, true, map, 1, 1);
    catArray[1] = new Cat(1, 1, true, map, 1, 3);
    System.out.println(map);
    window = new GameGUI(this);
    window.setVisible(true);
  }

  // main game loop
  // throws an exception because of 1 sec delay
  public void runGame() throws InterruptedException
  {
    while(true)
    {
      // fixing the ArrayIndexOutOfBoundsException error
      window.update();
      if (numberOfCats == catArray.length)
        break;

      makeMove();

      // deciding on next action
      if(Math.random() < 0.9 && numberOfCats > 3)
      {
        makeKill(catArray);
      }
      else
      {
        makeBreeding(catArray);
      }
      System.out.println(map);

      mapCountDown--;
      if (mapCountDown == 0)
      {
        mapCountDown = 3;
    //    System.out.println(map);
      }
      // wait for 1 second
      TimeUnit.SECONDS.sleep(3);
    }
  }

  private void makeBreeding(Cat[] catArray)
  {
    int firstCatID, secondCatID;
    // getting ids for first and second cats
    firstCatID = (int) (Math.random() * numberOfCats);
    secondCatID = firstCatID;

    while(secondCatID == firstCatID)
    {
      secondCatID = (int) (Math.random() * numberOfCats);
    }

    // getting new cat

    catArray[numberOfCats] = catArray[firstCatID].breedWith(catArray[secondCatID], numberOfCats);
    numberOfCats++;

    // printing out the number of cats
    System.out.println(firstCatID + " with " + secondCatID + " = " + numberOfCats);
  }

  private void makeKill(Cat[] catArray)
  {
    int randomCatID = (int) (Math.random() * numberOfCats);
    System.out.println("Cat number " + randomCatID + " has died");

    catArray[randomCatID].killCat();
    catArray[randomCatID] = null;

    for(int index = randomCatID; index < numberOfCats; index++)
    {
      catArray[index] = catArray[index + 1];
    }
    numberOfCats --;
  }

  private void makeMove()
  {
    for(int index = 0; index < numberOfCats; index++)
      {
        catArray[index].move();
      }
  }


  public Map getMap()
  {
    return map;
  }
}
