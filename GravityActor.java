
import mayflower.*;
public class GravityActor extends Actor
{
    private int gravSpeed = 0;
    
    public GravityActor()
    {
        
    }
    public void act(){        
        gravSpeed+=0.5;
        setLocation(getX(),getY()+gravSpeed);
        if(isBlocked())
            setLocation(getX(),getY()-1);
    }
    
    public boolean isBlocked(){
        if(this.isTouching(Block.class)){
            gravSpeed = 0;
            return true;
        }
        return false;
    }
    public boolean isFalling(){
        boolean ret;
        setLocation(getX(), getY() + gravSpeed);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
