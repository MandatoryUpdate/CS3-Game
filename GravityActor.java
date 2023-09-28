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
        boolean ret = false;
        setLocation(getX(), getY() + 1);
        ret = this.isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return ret;
    }
    
    public boolean isFalling(){
        boolean ret = false;
        while(isTouching(Block.class))
        {
            ret = true;
            setLocation(getX(), getY() - 1); 
        }
        if(ret == true)
            return false;
        return true;
    }
}
