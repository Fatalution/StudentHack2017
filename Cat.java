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

  // constructor for initialising variables
  private Cat(int givenId, int givenAge, String givenType, boolean givenGender)
  {
    isMale = givenGender;
    id = givenId;
    age = givenAge;
    type = givenType;
    strength = calculateStrength();
  }// constructor

  // method to calculate strength
  private int calculateStrength()
  {
    // variable to calculate strength
    int tempStrength = 0;

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
  public Cat breedWith(Cat otherCat, int givenId)
  {
    int newId = givenId;
    boolean newGender;

    if(Math.random() < 0.5)
      newGender = true;
    else
      newGender = false;

    int newStrength = 1;

    return new Cat(newId, 0, "Siberian", newGender);
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
    else if(otherCat.getStrength < strength)
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
  }//killCat

  // toString method
  public String toString()
  {
    return "Cat (" + "id = " + id + ", type = " + type + ", age = " + age + ")";
  }// toString

}// class
