import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;
import java.awt.Color;


/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Score
{
    private int score;
    
    public Counter() {
        String scoretext;
        GreenfootImage image;
        Dimension dim;
        
        score = 0;
        scoretext ="Aantal diamanten: 0";
        image = new GreenfootImage(10, 100);
        dim = getTextDimensions(image, scoretext);
        image.scale(dim.width, dim.height);
        setImage(image);
        image.setColor(new Color(0, 0, 0));
        image.drawString(scoretext, 0, dim.height);
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        
    }
    
    /*
     * Garp heeft een diamant gescoord om die moet erbij geteld worden
     */
    public void addScore() {
        score ++;
        updateImage();
        
    }
         
    /*
     * Deze methode past de afbeelding van counter aan aan de nieuwe situatie
     */
    protected void updateImage() {
        String scoreText;
        Dimension dim;
        GreenfootImage image;
        
        image = getImage();
        image.clear();
        scoreText ="Aantal diamanten: " + score;
        dim = getTextDimensions(image, scoreText);
        image.setColor(new Color(0, 0, 0));
        image.drawString(scoreText, 0, dim.height);
    }
    public int getScore() {
        return this.score;
        
        
        
    }
}