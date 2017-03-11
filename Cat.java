public class Cat extends Animal
{

  public Cat(int givenId, int givenAge, boolean givenGender, Map givenMap)
  {
    super(givenId, givenAge, givenGender, givenMap);
  }// constructor

  public Cat(int givenId, int givenAge, boolean givenGender,
                                          Map givenMap, int givenX, int givenY)
  {
    super(givenId, givenAge, givenGender, givenMap, givenX, givenY);
  }// constructor

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

  // method for killing another cat
  private void killCat(Cat catToKill)
  {
    catToKill = null;
    getMap().removeObject(catToKill.getX(), catToKill.getY());
  }//killCat

}// class
