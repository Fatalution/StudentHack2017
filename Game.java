public class Game
{
  //storing number of cats
  public int numberOfCats = 2;

  //cats array
  public Cat[] catArray = new Cat[100];

  public Game()
  {
    //creating first 2 cats
    catArray[0] = new Cat(0, 1, null, true);
    catArray[1] = new Cat(1, 1, null, true);
  }

  //main game loop
  public void runGame()
  {
    while(true)
    {
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
    int firstCat, secondCat;
    //getting ids for first and second cats
    firstCat = (int) (Math.random() * numberOfCats);
    secondCat = firstCat;

    while(secondCat == firstCat)
    {
      secondCat = (int) (Math.random() * numberOfCats);
    }

    //getting new cat
    catArray[numberOfCats] = catArray[firstCat].breedWith(catArray[secondCat], numberOfCats);
    numberOfCats++;

    //printing breeding info
    System.out.println("Cat " + firstCat + " with " + secondCat + " equals " + numberOfCats);
  }

  private void makeKill(Cat[] catArray)
  {
    int randomCat = (int) (Math.random() * numberOfCats);
    System.out.println("Cat " + randomCat + " has died");

    catArray[randomCat] = null;

    for(int index = randomCat; index < numberOfCats; index++)
    {
      catArray[index] = catArray[index + 1];
    }
    numberOfCats --;
  }
}
