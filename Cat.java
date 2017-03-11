public class Cat extends Animal
{

  public Cat(int givenAge, Map givenMap)
  {
    super(givenAge, givenMap);
  }// constructor

  public Cat(int givenAge, boolean givenGender,
                                          Map givenMap, int givenX, int givenY)
  {
    super(givenAge, givenGender, givenMap, givenX, givenY);
  }// constructor

  // method for breeding two cats
  // returns new cat
  public Cat breedWith(Cat otherCat)
  {
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


      int newX = 0;

      int newY = 0;


      // returns new cat
      return new Cat(0, newGender, getMap(), newX, newY);
    }
    else
      return null;

  }

  // method to find distance between two points on the map
  // pythagoras theorem
  private double distanceToCat(Cat otherCat)
  {
    double distance = 0;
    int distanceA = Math.abs(getX() - otherCat.getX());
    int distanceB = Math.abs(getY() - otherCat.getY());
    distance = Math.sqrt(Math.pow(distanceA, 2) + Math.pow(distanceB, 2));
    return distance;
  }

  // method to check if breeding is possible
  // if distance between cats is more than 3 - it is not possible
  private boolean breedingPossible(Cat otherCat)
  {
    if ((distanceToCat(otherCat) > 3) || (isMale == otherCat.isMale))
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
      killCat(otherCat);
    else if(otherCat.getStrength() < getStrength())
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


  private void killCat(Cat catToKill)
  {
    catToKill = null;
    getMap().removeObject(catToKill.getX(), catToKill.getY());
  }//killCat

}// class
