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

  // constructor for initialising variables
  private Cat(int givenId, int givenAge, String givenType, boolean givenGender)
  {
    isMale = givenGender;
    id = givenId;
    age = givenAge;
    type = givenType;
  }// constructor

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
    return "Cat (" + type + ", " + age + ")";
  }// toString

  public void fightWith(Cat otherCat)
  {
    if(otherCat)
  }// fightWith

  private void killCat(Cat catToKill)
  {
    catToKill = null;
  }//killCat

}
