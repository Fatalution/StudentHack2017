import javax.swing.*;
public class Animal
{
  // int to track the age of a cat
  private int age = 0;
  // variable for ID
  private final int id;
  // class constants to determine cat's gender
  public final boolean isMale;
  // integer to hold the strength of a cat
  private int strength;
  // integers to hold x and y variables of the cat
  private int x, y;
  // the map that the cat is on
  private final Map map;
  private Image image;

  // constructor for initialising variables
  public Animal(int givenId, int givenAge, Map givenMap, Image animalImage)
  {
    image = animalImage;
    if(Math.random() < 0.5)
      isMale = true;
    else
      isMale = false;

    id = givenId;
    age = givenAge;
    strength = calculateStrength();
    map = givenMap;

    x = (int) (Math.random() * map.getSize());
    y = (int) (Math.random() * map.getSize());

    while(map.getCell(x,y) != 0)
    {
      x = (int) (Math.random() * map.getSize());
      y = (int) (Math.random() * map.getSize());
    }

    map.addObject(x, y, 1);

  }// constructor 1

  public Animal(int givenId, int givenAge, boolean givenGender,
                                          Map givenMap, int givenX, int givenY, Image animalImage)
  {
    isMale = givenGender;
    id = givenId;
    age = givenAge;
    strength = calculateStrength();
    map = givenMap;
    x = givenX;
    y = givenY;
    image = animalImage;

    map.addObject(x, y, 1);

  }// constructor 2

  // method to calculate strength
  private int calculateStrength()
  {
    // variable to calculate strength
    int tempStrength;

    if(isMale)
      tempStrength = 100;
    else
      tempStrength = 50;

    tempStrength -= age * 5;

    return tempStrength;
  }// calculateStrength

  public int getStrength()
  {
    return strength;
  }// getStrength

  // method for breeding two animals
  // returns new cat
  public Animal breedWith(Animal otherAnimal, int givenId)
  {
    // variable to store new gender of new cat
    boolean newGender;

    // gender is 50/50 male or female
    if(Math.random() < 0.5)
      newGender = true;
    else
      newGender = false;

    // generates x and y between the two parent cats

    int newX = Math.min(x, otherAnimal.getX()) + (int)(Math.random() * ((Math.max(x, otherAnimal.getX()) - Math.min(x, otherAnimal.getX())) + 1));
    int newY = Math.min(y, otherAnimal.getY()) + (int)(Math.random() * ((Math.max(y, otherAnimal.getY()) - Math.min(y, otherAnimal.getY())) + 1));

    while(map.getCell(x,y) != 0)
    {
      newX = Math.min(x, otherAnimal.getX()) + (int)(Math.random() * ((Math.max(x, otherAnimal.getX()) - Math.min(x, otherAnimal.getX())) + 1));
      newY = Math.min(y, otherAnimal.getY()) + (int)(Math.random() * ((Math.max(y, otherAnimal.getY()) - Math.min(y, otherAnimal.getY())) + 1));
    }

    // returns new cat
    return new Animal(givenId, 0, newGender, map, newX, newY);
  }

  public void move()
  {
    boolean moved = false;

    while(!moved)
    {
      if(Math.random() < 0.25 && x < map.getSize() - 1)
      {
        x++;
        moved = true;
      }
      else if(Math.random() < 0.5 && y < map.getSize() - 1)
      {
        y++;
        moved = true;
      }
      else if(Math.random() < 0.75 && x > 0)
      {
        x--;
        moved = true;
      }
      else if(y > 0)
      {
        y--;
        moved = true;
      }
    }// while

  }// move

  // method for adding a year for a cat
  public void addYear()
  {
    age++;
  }// addYear

  // method for getting the gender of a cat
  private boolean checkIfMale()
  {
    return isMale;
  }// getGender

  // method for getting X value
  public int getX()
  {
    return x;
  }

  // method for getting Y value
  public int getY()
  {
    return y;
  }

  public Map getMap()
  {
    return map;
  }// getMap

}// class
