
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
            setLocation(getX(),getY() - 1);
            ableToJump = true;
        }
        if(isLadder())
        {
            gravSpeed = 0;
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
    public boolean isLadder(){
        if(this.isTouching(Ladder.class)){
            return true;
        }
        return false;
    }
    public boolean isFalling(){
        boolean ret, ret2;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        ret2 = isTouching(Ladder.class);
        if(ret == true || ret2 == true)
            return false;
        setLocation(getX(), getY() - 1);
        return true;
    }
}
