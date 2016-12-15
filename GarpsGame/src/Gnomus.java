import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor{
    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        int random;
        
        move(5); // ga 5 pixels vooruit
        if(atWorldEdge()){ //Sta je aan de rand van de wereld
            move(-5); //Doe een stap terug
            if(Greenfoot.getRandomNumber(100) < 50) { //Welke kant op: rechts of links
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            else {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        else { //Als je niet aan de rand van de wereld bent
            random = Greenfoot.getRandomNumber(100); //getal tussen 0 en 100
            if(random < 2) { //2%kans naar rechts
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            if(random > 98) { //2%kans naar links
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
                
    }    
    lookForGarp();
    lookForGarp();
}

/*
 * Controleer of Gnomus aan het einde van de wereld staat.
 * Geen parameters
 * @return: boolean: flase: als Gnomus ergens midden op de wereld staat
 *                   true: als Gnomus op de rand van de wereld staat
 */
public boolean atWorldEdge() {
    int x, i, y, wx, wy; //Declaratie van i toegevoegd voor de helft van breedte van de afbeelding
    
    //Linkerkant
    x = getX();
    i = getImage().getWidth() / 2; //Vraag de breedte van de afbeelding op en deel deze door twee
    if(x <= i) { //Aan de linkerkant van de wereld
        return true;
    }
    //Bovenkant
    y = getY();
    if(y <= i) {
        return true;
    }
    //Rechterkant
    wx = getWorld().getWidth() - i;
    if(x >= wx) {
        return true;
    }
    //Onderkant
    wy = getWorld().getHeight() - i;
    if(x >= wy) {
        return true;
    }
    
    return false;
}

/*
 * *Zorgt voor een willekeurige relatie van Gnomus
 * *Geen parameters en geen teruggave
 */
 protected void setRotation() {
     if(Greenfoot.getRandomNumber(100) <50) {
         setRotation(getRotation() + Greenfoot.getRandomNumber(180));
        }
    else {
        setRotation(getRotation() - Greenfoot.getRandomNumber(180));
    }
     
}

/*
 *Deze methode zorgt ervoor dat Gnomus een draaai maakt als hij tegen een wi.....
 *aanloopt
 */
protected void lookForActor() {
    Actor actor;
    actor = getOneObjectAtOffset(0, 0, Actor.class);
    if((actor != null))
        turn(45);
}
    
/*
 * In deze methode vermoordt Garp, nadat deze heel hard geschreeuwd heeft....
 * Geen parameters
 * Geen teruggave
 */
protected void lookForGarp() {
    Actor garp;
    garp = getOneObjectAtOffset(1, 1, Garp.class);
    if(garp != null) {
        Greenfoot.playSound("scream.mp3");
        getWorld().removeObject(garp);
        Greenfoot.stop();
   }   
  }
}
