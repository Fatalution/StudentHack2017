public class Game
{
  //storing number of cats
  public int numberOfCats = 2;

  //cats array
  public Cat[] catArray = new Cat[100];

  public Game()
  {
    Map map = new Map(100);
    //creating first 2 cats
    catArray[0] = new Cat(0, 1, null, true, map, 1, 1);
    catArray[1] = new Cat(1, 1, null, true, map, 1, 3);
  }

  //main game loop
  public void runGame()
  {
    while(true)
    {
      // fixing the ArrayIndexOutOfBoundsException error
      if (numberOfCats == catArray.length)
        break;

      if(Math.random() < 0.2 && numberOfCats > 2)
      {
        makeKill(catArray);
      }

      else
      {
        makeBreeding(catArray);
      }
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
    catArray[numberOfCats]
        = catArray[firstCatID].breedWith(catArray[secondCatID], numberOfCats);

    // checking if breeding was possible
    if (!catArray[firstCatID].breedingPossible(catArray[secondCatID]))
      return;
    else
      numberOfCats++;

    // printing out the number of cats
    System.out.println(numberOfCats + " number of cats");
  }

  private void makeKill(Cat[] catArray)
  {
    int randomCatID = (int) (Math.random() * numberOfCats);
    System.out.println("Cat number " + randomCatID + " has died");

    catArray[randomCatID] = null;

    for(int index = randomCatID; index < numberOfCats; index++)
    {
      catArray[index] = catArray[index + 1];
    }
    numberOfCats --;
  }
}
