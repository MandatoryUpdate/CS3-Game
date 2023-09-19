
import mayflower.*;
public class GravityActor extends Actor
{
    private int gravSpeed = 0;
    
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
            gravSpeed = 0;
            return true;
        }
        return false;
    }
    public boolean isFalling(){
        boolean ret;
        gravSpeed+=1
        setLocation(getX(), getY() + gravSpeed);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
