
import mayflower.*;
public class GravityActor extends Actor
{
    
    public GravityActor()
    {
        
    }
    public void act(){
        setLocation(getX(),getY()+1);
        if(isBlocked())
            setLocation(getX(),getY()-1);
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
