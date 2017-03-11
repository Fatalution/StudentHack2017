public class Actions
{
  // method to decide on next action
  private static String decideOnAction(Cat neededCat)
  {
    int result = new Random().nextInt(MAX);

       switch (result)
       {
        case 0:
        fightWith(neededCat);
        break;

        case 1:
        breedWith(neededCat);
        break;
       }

  }
}
