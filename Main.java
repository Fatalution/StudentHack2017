public class Main
{
  public static void main(String[] args)
  {
    Cat[] catArray = new Cat[100];

    catArray[0] = new Cat(0, 1, null, true);
    catArray[1] = new Cat(1, 1, null, true);
    int numberOfCats = 2;

    int firstCat, secondCat;

    while(true)
    {
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
  }
  // DIFFERENCE
}
