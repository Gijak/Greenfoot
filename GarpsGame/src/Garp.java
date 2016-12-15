import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


/**
 * Write a description of class Garp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor
{
private GreenfootImage imageLeft;
private GreenfootImage imageRight;


    /**
     * Constructor om de afbeelding van Garp te laden.
     * Geen parameters
     */
public Garp(){ 
    imageLeft = new GreenfootImage("GarpLeft.png");
    imageRight = new GreenfootImage("GarpRight.png");
}

/*****
 * Act - do whatever the GArp wants to do. This method is called whenever
 * the 'Act' or 'Run' button gets in the enviroment.
 */
public void act() {
        movingAndTurning();
        collectingDiamonds();
        foundBomb();
}


/*****
 *Deze methode vangt op welke pijltjestoes is ingedrukt en beeweegt vervolgens Gar[
 * Geen parameters
 * Geen teruggave
 */
   protected void movingAndTurning() {

     if(Greenfoot.isKeyDown("right")) {
         if(getImage() == imageLeft) {         
             setImage(imageRight);
        }
        setRotation(0);
        move(5);        
         if(foundRock()) {
         move(-5);

        }
}
        
 if(Greenfoot.isKeyDown("left")) {
     if(getImage() == imageRight) {
     setImage(imageLeft);
    }
    setRotation(0);
    move(-5);}
    
if(foundRock()) {
 move(5);
}
      
if(Greenfoot.isKeyDown("up")) {
    if(getImage() == imageLeft) {
         setImage(imageRight);
    }
    setRotation(-90);
    move(5);
}
if(foundRock()) {
move(-5);
}
        
 if(Greenfoot.isKeyDown("down")) {
     if(getImage() == imageLeft) {
     setImage(imageRight);
    } 
     setRotation(90);
     move(5);
     if(foundRock()) {
    move(-5);
    }
  }
}

/*****
 * In deze methode verzamelt Garp de diamanten
 * geen parameters
 * geen teruggave
 */
protected void collectingDiamonds() {
    Actor diamond;
    World world;
    Counter counter;
    List lijst;
    
    //op zoek naar diamanten
    diamond = getOneObjectAtOffset(0, 0, Diamond.class);
    if(diamond != null) { //Als Garp een diamant ziet
       world = getWorld(); //In welke wereld leeft Grap
       world.removeObject(diamond); //Verwijder de diamant van de wereld
       lijst = world.getObjects(Counter.class);
       counter = (Counter)lijst.get(0);
       counter.addScore();
       if(counter.getScore() ==12) {
           Greenfoot.stop();
       
        }     
    }
}

/*******
* Deze methode  bepaalt of Garp tegen is aangelopen
* geen parameters
* teruggave booleon
*/
protected boolean foundRock() {
    Actor rock;
    rock = getOneObjectAtOffset(0, 0, Rock.class);
    if(rock != null) {
        return true;
    }
    return false;

  }
  
  public void foundBomb() {
      Actor bomb;
      
      bomb = getOneObjectAtOffset(0, 0, Bomb.class);
      if(bomb != null) { 
          getWorld().removeObject(bomb);
          getWorld().addObject(new Explosion(), getX(), getY());
          getWorld().removeObject(this);
    }
  } 
}
