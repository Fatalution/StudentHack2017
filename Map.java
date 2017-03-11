// class representing maps
// each cell has value true if it is occupied
public class Map
{
  // integer to hold the size of a map
  private final int size;
  // String array to represent the map
  private boolean[][] map;

  // constructor for maps
  public Map(int givenSize)
  {
    size = givenSize;
    initialiseMap();
  }// constructor

  // initialises map array
  private void initialiseMap()
  {
    for(int x = 0; x < size; x++)
      for(int y = 0; y < size; y++)
        map[x][y] = false;
  }

  // sets the map coordinates of new object to false
  public void addObject(int x, int y)
  {
    map[x][y] = true;
  }// addObject

  public String toString()
  {
    String mapString = "";

    for(int y = 0; y < size; y++)
    {
      for(int x = 0; x < size; x++)
      {
        if(map[x][y])
          mapString += "#";
        else
          mapString += " ";
      }// for

      mapString += "\n";

    }// for

    return mapString;
  }// toString

}// class