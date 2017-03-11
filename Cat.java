import javax.swing.*;

public class Cat
{
  // int to track the age of a cat
  private int age = 0;
  // string to store the type of a cat which is final
  private final String type;
  // variable for ID
  private final int id;
  // class constants to determine cat's gender
  private final boolean isMale;
  // integer to hold the strength of a cat
  private int strength;
  // integers to hold x and y variables of the cat
  private final int x, y;
  // the map that the cat is on
  private final Map map;
  private Image catImage;

  // constructor for initialising variables
  public Cat(int givenId, int givenAge, String givenType, boolean givenGender,
                                                                  Map givenMap)
  {
    isMale = givenGender;
    id = givenId;
    age = givenAge;
    type = givenType;
    strength = calculateStrength();
    map = givenMap;
    x = (int) (Math.random() * map.getSize());
    y = (int) (Math.random() * map.getSize());

    map.addObject(x, y, 1);

    catImage = GameGUI.catImage();

  }// constructor 1

  public Cat(int givenId, int givenAge, String givenType, boolean givenGender,
                                        Map givenMap, int givenX, int givenY)
  {
    isMale = givenGender;
    id = givenId;
    age = givenAge;
    type = givenType;
    strength = calculateStrength();
    map = givenMap;
    x = givenX;
    y = givenY;

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

  private int getStrength()
  {
    return strength;
  }// getStrength

  // method for breeding two cats
  // returns new cat
  public Cat breedWith(Cat otherCat, int givenId)
  {
    // sets new id to given one
    int newId = givenId;
    // variable to store new gender of new cat
    boolean newGender;

    // gender is 50/50 male or female
    if(Math.random() < 0.5)
      newGender = true;
    else
      newGender = false;

    // check if breeding is possible using the boolean value
    if (breedingPossible(otherCat))
    {
      // generates x and y between the two parent cats
      int newX = Math.min(x, otherCat.getX()) + (int)(Math.random()
         * ((Math.max(x, otherCat.getX()) - Math.min(x, otherCat.getX())) + 1));

      int newY = Math.min(y, otherCat.getY()) + (int)(Math.random()
         * ((Math.max(y, otherCat.getY()) - Math.min(y, otherCat.getY())) + 1));

      //printing breeding info
      System.out.println("Cat " + id + " breeds with "
                                            + otherCat.id + "!");
      // returns new cat
      return new Cat(newId, 0, "Siberian", newGender, map, newX, newY);
    }
    else
    {
      System.out.println("Can not breed, too far!");
      return null;
    }
  }

  // method to find distance between two points on the map
  // pythagoras theorem
  public double distanceToCat(Cat otherCat)
  {
    double distance = 0;
    int distanceA = x - otherCat.x;
    int distanceB = y - otherCat.y;
    distance = Math.sqrt(Math.pow(distanceA, 2) + Math.pow(distanceB, 2));
    return distance;
  }

  // method to check if breeding is possible
  // if distance between cats is more than 3 - it is not possible
  public boolean breedingPossible(Cat otherCat)
  {
    if (distanceToCat(otherCat) > 3)
      return false;
    else
      return true;
  }
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

  // method for fighting with other cats, sets dead cat to null
  public void fightWith(Cat otherCat)
  {
    // if other cat's strength is greater, kill this cat
    // or kill other cat if this one is stronger
    if(otherCat.getStrength() > strength)
      killCat(otherCat);
    else if(otherCat.getStrength() < strength)
      killCat(this);
    else
    {
      // if the strength values are even, choose at random
      // which cat to kill
      if(Math.random() < 0.5)
        killCat(otherCat);
      else
        killCat(this);
    }// else
  }// fightWith

  private int getX()
  {
    return x;
  }

  private int getY()
  {
    return y;
  }

  private void killCat(Cat catToKill)
  {
    catToKill = null;
  }//killCat

  // toString method
  public String toString()
  {
    return "Cat (" + "id = " + id + ", type = " + type + ", age = " + age + ")";
  }// toString

}// class
