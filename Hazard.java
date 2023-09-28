import mayflower.*;
public class Hazard extends Actor
{
    private int x;
    private int y;
    public Hazard(int startx, int starty)
    {
       x = startx;
       y = starty;
    }

    
    public void act()
    {
        if(isTouching(Cat.class)){
          Cat a = getOneIntersectingObject(Cat.class);
          World w = getWorld();
          a.decreaseLives();
          a.setLocation(x,y);
          if(a.getLives()==0){
              Mayflower.setWorld(new GameEndLose());
            }
        }  
        
    }
}

