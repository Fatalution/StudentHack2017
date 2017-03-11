import java.awt.Image;

public class Cat extends Animal
{

  public Cat(int givenId, int givenAge, Map givenMap)
  {
    super(givenId, givenAge, givenMap);
  }// constructor

  public Cat(int givenId, int givenAge, boolean givenGender,
                                          Map givenMap, int givenX, int givenY)
  {
    super(givenId, givenAge, givenGender, givenMap, givenX, givenY);
  }// constructor

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

      return new Cat(givenId, 1, getMap());
  }

  // method to find distance between two points on the map
  // pythagoras theorem
  public double distanceToCat(Cat otherCat)
  {
    double distance = 0;
    int distanceA = getX() - otherCat.getX();
    int distanceB = getY() - otherCat.getY();
    distance = Math.sqrt(Math.pow(distanceA, 2) + Math.pow(distanceB, 2));
    return distance;
  }

  // method to check if breeding is possible
  // if distance between cats is more than 3 - it is not possible
  public boolean breedingPossible(Cat otherCat)
  {
    if ((distanceToCat(otherCat) > 3) || (isMale && otherCat.isMale)
                                      || (!isMale && !otherCat.isMale))
      return false;
    else
      return true;
  }

  // method for fighting with other cats, sets dead cat to null
  public void fightWith(Cat otherCat)
  {
    // if other cat's strength is greater, kill this cat
    // or kill other cat if this one is stronger
    if(otherCat.getStrength() > getStrength())
      killCat();
    else if(otherCat.getStrength() < getStrength())
      killCat();
    else
    {
      // if the strength values are even, choose at random
      // which cat to kill
      if(Math.random() < 0.5)
        killCat();
      else
        killCat();
    }// else
  }// fightWith


  public void killCat()
  {
    getMap().removeObject(getX(), getY());
  }//killCat

}// class
