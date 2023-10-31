import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeHead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeHead extends Actor
{
    private final int KANAN = 0;
    private final int BAWAH = 90;
    private final int KIRI = 180;
    private final int ATAS = 270;
    
    private final int SPEED = 15;
    private int counter = 0;
    private int foodEaten = 0;
    
    public SnakeHead()
    {
        setRotation(Greenfoot.getRandomNumber(4)*90);
    }
    /**
     * Act - do whatever the SnakeHead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void moveAround()
    {
        counter++;
        if(counter == SPEED){
            getWorld().addObject(new Body(foodEaten*SPEED), getX(), getY());
            move(15);
            counter = 0;
        }
        if(Greenfoot.isKeyDown("up"))
            setRotation(ATAS);
        {
           if(Greenfoot.isKeyDown("down"))
            setRotation(BAWAH); 
        }
        {
            if(Greenfoot.isKeyDown("left"))
            setRotation(KIRI);
        }
        {
            if(Greenfoot.isKeyDown("right"))
            setRotation(KANAN);
        }
        

    }
    private boolean facingEdge(){
        switch(getRotation()){
            case KANAN: return getX()==getWorld().getWidth()-1;
            case BAWAH: return getX()==getWorld().getHeight()-1;
            case KIRI: return getX()==0;
            case ATAS: return getX()==0;
            
        }
        return false;
    }
    public void act(){
        moveAround();
        if(isTouching(Food.class))
        {
        Food food = new Food();
        
        removeTouching(Food.class);
        foodEaten++;
        SnakeWorld world = (SnakeWorld)getWorld();
        world.addFood();
        world.score.add(1);
        
        
        }
        
        if(facingEdge())
        {
            Greenfoot.stop();
        }
    }
        
    
}
