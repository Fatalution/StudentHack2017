// class representing maps
// each cell has value true if it is occupied
public class Map
{
  // integer to hold the size of a map
  private final int size;
  // String array to represent the map
  private int[][] map;
  // class constant to hold empty cell value
  public final int EMPTY = 0;

  // constructor for maps
  public Map(int givenSize)
  {
    size = givenSize;
    initialiseMap();
  }// constructor

  // initialises map array
  private void initialiseMap()
  {
    map = new int[size][size];

    // sets all spaces to 0
    for(int x = 0; x < size; x++)
      for(int y = 0; y < size; y++)
        map[x][y] = EMPTY;
  }

  // sets the map coordinates of new object to the id of an object
  public void addObject(int x, int y, int givenId)
  {
    if(map[x][y] == EMPTY)
      map[x][y] = givenId;
  }// addObject

  // method for removing objects from map
  public void removeObject(int x, int y)
  {
    map[x][y] = 0;
  }// removeObject

  // toString method
  public String toString()
  {
    String mapString = "";

    for(int y = 0; y < size; y++)
    {
      for(int x = 0; x < size; x++)
      {
        if(map[x][y] > 0)
          mapString += map[x][y];
        else
          mapString += "-";
      }// for

      mapString += "\n";

    }// for

    return mapString;
  }// toString

  // accessor method to get the size of the map
  public int getSize()
  {
    return size;
  }

  public int getCell(int x, int y)
  {
    return map[x][y];
  }

}// class
