import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends Actor
{
    private int age = 0;
    private int lifespan;
    
    public Body(int lifespan){
        this.lifespan = lifespan;
    }
    /**
     * Act - do whatever the Body wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(age == lifespan){
            getWorld().removeObject(this);
        }
        age++;
    }
}
