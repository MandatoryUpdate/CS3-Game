
import mayflower.*;
public class GravityActor extends Actor
{
    private double gravSpeed = 0;
    private double acceleration = 0;
    private boolean ableToJump = false;
    
    public GravityActor()
    {
        
    }
    public void act(){        
        gravSpeed+=0.05;
        if(isBlocked()){
            gravSpeed = 0;
            setLocation(getX(),getY() - gravSpeed - 1);
            gravSpeed = 0;
            ableToJump = true;
        }
        setLocation(getX(),getY()+gravSpeed+acceleration);
        if(acceleration<0)
            acceleration+=.5;
    }
    
    public void setAcceleration(int a){
        acceleration = a;
    }
    public double getAcceleration(){
        return acceleration;
    }
    public void setAbleToJump(boolean j){
        ableToJump = j;
    }
    public boolean getAbleToJump(){
        return ableToJump;
    }
    
    public boolean isBlocked(){
        if(this.isTouching(Block.class)){
            return true;
        }
        return false;
    }
    
    public boolean isFalling(){
        boolean ret;
        while(isTouching(Block.class))
        {
           setLocation(getX(), getY() - 1); 
        }
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        if(ret == true)
            return false;
        return true;
    }
}
