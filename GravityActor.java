import mayflower.*;
public class GravityActor extends Actor
{
    private double gravSpeed = 0.5;
    private double acceleration = 0;
    private boolean ableToJump = false;
    
    public GravityActor()
    {
        
    }
    public void act(){
        acceleration = acceleration + gravSpeed;
        if(isBlocked()){
            acceleration=0;
            setLocation(getX(),getY() - gravSpeed - 1);
            ableToJump = true;
        }
        setLocation(getX(),getY()+acceleration);
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
        return this.isTouching(Block.class);
    }
    
    public boolean isFalling(){
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
