import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private String currentAction;
    private Animation jumpRight;
    private Animation jumpLeft;
    private String direction;
    
    public MovableAnimatedActor(){
        walkRight = null;
        walkLeft = null;
        idleRight = null;
        idleLeft = null;
        jumpRight = null;
        jumpLeft = null;
        fallRight = null;
        fallLeft = null;
        direction = "right";
    }
    public void act(){
        super.act();
        String newAction = null;
        if(currentAction == null){
            currentAction = "idle";
            setAnimation(idleRight);
        }
        
        if(isOnGround()){
            if(direction.equals("right"))
                newAction = "fallRight";
            if(direction.equals("left"))
                newAction = "fallLeft";
        }
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x+w<800){
           setLocation(x+5,y);
           newAction = "walkRight";
           direction = "right";
           if(isBlocked()){
              setLocation(x-1,y);
              setAbleToJump(false);
              setAnimation(walkRight);
            }
           if(Mayflower.isKeyDown(Keyboard.KEY_UP))
           {
               direction = "right";
               newAction = "moveJumpRight";
           }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x>0){
           setLocation(x-5,y);
           newAction = "walkLeft";
           direction = "left";
           if(Mayflower.isKeyDown(Keyboard.KEY_UP))
           {
               direction = "left";
               newAction = "moveJumpLeft";
           }
           if(isBlocked()){
              setLocation(x+1,y);
              setAbleToJump(false);
              setAnimation(walkLeft);
            }
        }
        
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN))
        {
            if(direction.equals("left"))
            {
                setAnimation(idleLeft);
            }
            else
            {
                setAnimation(idleRight);
            }
            setLocation(x, y + 1);
            
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y>0){
            if(direction != null && direction.equals("left")){
              newAction = "jumpLeft";
           }
           else
              newAction = "jumpRight";
           if(isTouchingBlockFromBottom()){
               setLocation(x, y + 3);
               setAcceleration(0);
           }
        }
        else{
           if(direction != null && direction.equals("left")){
              newAction = "idleLeft";
           }
           else
              newAction = "idleRight";
        }        
        
        // System.out.println(getAcceleration());
        if(newAction!=null && !currentAction.equals(newAction)){
            if(newAction.equals("fallRight"))
                setAnimation(fallRight);
            if(newAction.equals("fallLeft"))
                setAnimation(fallLeft);
            if(newAction.equals("idleRight"))
                setAnimation(idleRight);
            if(newAction.equals("idleLeft"))
                setAnimation(idleLeft);
            if(newAction.equals("walkRight"))
                setAnimation(walkRight);
            if(newAction.equals("walkLeft"))
                setAnimation(walkLeft);
            if(newAction.equals("jumpRight"))
                jumpRight();
            if(newAction.equals("jumpLeft"))
                jumpLeft();
            if(newAction.equals("moveJumpRight")){
                setLocation(x+5,y);
                jumpRight();
            }
            if(newAction.equals("moveJumpLeft")){
                setLocation(x-5,y);
                jumpLeft();
            }
            
            currentAction = newAction;
        }
    }
    
    public void jumpLeft(){
        if(getAbleToJump()){
            setAcceleration(-10);
            setAnimation(jumpLeft);
        }
        setAbleToJump(false);
    }
    public void jumpRight(){
        if(getAbleToJump()){
            setAcceleration(-10);
            setAnimation(jumpRight);
        }
        setAbleToJump(false);
    }
    
    public void setIdleRightAnimation(Animation a){   
        idleRight = a;
    }
    public void setIdleLeftAnimation(Animation a){   
        idleLeft = a;
    }
    public void setWalkRightAnimation(Animation a){
        walkRight = a;
    }
    public void setWalkLeftAnimation(Animation a){
        walkLeft = a;
    }
    public void setFallRightAnimation(Animation a){
        fallRight = a;
    }
    public void setFallLeftAnimation(Animation a){
        fallLeft = a;
    }
    public void setJumpLeftAnimation(Animation a){
        jumpLeft = a;
    }
    public void setJumpRightAnimation(Animation a){
        jumpRight = a;
    }
}
