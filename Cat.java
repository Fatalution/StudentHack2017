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

  private int calculateStrength()
  {
    
  }// calculateStrength

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

  private boolean checkIfMale()
  {
    return isMale;
  }// getGender

  // toString method
  public String toString()
  {
    return "Cat (" + "id = " + id + ", type = " + type + ", age = " + age + ")";
  }// toString

  public void fightWith(Cat otherCat)
  {

  }// fightWith

  private void killCat(Cat catToKill)
  {
    catToKill = null;
  }//killCat

}
