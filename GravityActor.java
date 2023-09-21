
import mayflower.*;
public class GravityActor extends Actor
{
    private double gravSpeed = 0;
    
    public GravityActor()
    {
        
    }
    public void act(){        
        gravSpeed+=0.05;
        if(isBlocked())
            gravSpeed = 0;
            setLocation(getX(),getY()-1);
        setLocation(getX(),getY()+gravSpeed);
    }
    
    public boolean isBlocked(){
        if(this.isTouching(Block.class)){
            return true;
        }
        return false;
    }
    public boolean isFalling(){
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
