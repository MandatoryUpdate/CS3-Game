
import mayflower.*;
public class GravityActor extends Actor
{
    private double gravSpeed = 0;
    private double acceleration = 0;
    
    public GravityActor()
    {
        
    }
    public void act(){        
        gravSpeed+=0.05;
        if(isBlocked())
            gravSpeed = 0;
        setLocation(getX(),getY()+gravSpeed+acceleration);
        if(acceleration>0)
            acceleration+=.5;
    }
    
    public void setAcceleration(int a){
        acceleration = a;
    }
    public double getAccelertation(){
        return acceleration;
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
