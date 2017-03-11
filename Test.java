public class Test
{
  private static final int INITIAL_ARRAY_SIZE = 3;
  private static Cat[] cats = new Cat[INITIAL_ARRAY_SIZE];
  private static final int ARRAY_RESIZE_FACTOR = 2;
  private static int catNumber = 0;
  private static final double SPAWNING_PROBABILITY = 0.4;

  public static void main(String[] args)
  {
    Map map = new Map(20);

    cats[0] = new Cat(0, true, map, 1, 1);
    catNumber++;

    cats[1] = new Cat(0, false, map, 1, 3);
    catNumber++;

    System.out.println(map);

    while(true)
    {
      if(catNumber >= cats.length)
      {
        Cat[] tempArray = new Cat[INITIAL_ARRAY_SIZE * ARRAY_RESIZE_FACTOR];
        for(int index = 0; index < cats.length; index++)
          tempArray[index] = cats[index];

        cats = tempArray;
      }

      for(int index = 0; index < cats.length-1; index++)
        if(cats[index] != null && cats[index+1] != null)
        {
          cats[catNumber] = cats[index].breedWith(cats[index+1]);
          catNumber++;
        }

     System.out.println(map);
     break;
    }

  }// main
}// Test
