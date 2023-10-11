import mayflower.*;

public class GravityActor extends Actor {
    private double gravSpeed = 0.5;
    private double acceleration = 0;
    private boolean ableToJump = false;

    public GravityActor() {
    }

    public void act() {
        setAcceleration(acceleration + gravSpeed);

        if(isOnGround()) {
            setAcceleration(0);
            setAbleToJump(true);
            setLocation(getX(), getY()-1);
            System.out.println("yes");
        }
        if(isTouchingLadder()) {
            setAcceleration(0);
            setLocation(getX(), getY()-1);
        }
        if(isTouchingBlockFromBottom()) {
            ableToJump = false;
            setLocation(getX(), getY()+gravSpeed);
        }

        setLocation(getX(), getY() + acceleration);
    }

    public void setAcceleration(double a) {
        acceleration = a;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAbleToJump(boolean j) {
        ableToJump = j;
    }

    public boolean getAbleToJump() {
        return ableToJump;
    }

    public boolean isOnGround() {
        Actor blockBelow = getOneObjectAtOffset(0, getHeight() / 2, Block.class);
        return blockBelow != null;
    }
    public boolean isTouchingLadder() {
        Actor ladderTouching = isTouching(Ladder.class);
        return ladderTouching != null;
    }

    public boolean isBlocked() {
        Actor blockLeft = getOneObjectAtOffset(-getWidth() / 2, 0, Block.class);
        Actor blockRight = getOneObjectAtOffset(getWidth() / 2, 0, Block.class);
        return blockLeft != null || blockRight != null;
    }
    public boolean isTouchingBlockFromBottom() {
        Actor blockAbove = getOneObjectAtOffset(0, -getHeight() / 2, Block.class);
        return blockAbove != null;
    }
}
