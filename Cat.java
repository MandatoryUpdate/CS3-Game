import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private int score = 0;
    private int lives = 3;
    public Cat(){
        String[] frames = new String[10];
        for(int i=0;i<10;i++){
            frames[i] = "img/cat/Walk ("+(i+1)+").png";
        }
        Animation walkR = new Animation(50,frames);
        walkR.resize(100,87);
        walkR.setBounds(18,4,54,80);
        
        Animation walkL = new Animation(50,frames);
        walkL.resize(100,87);
        walkL.flipHorizontally();
        walkL.setBounds(28,4,54,80);
        for(int i=0;i<10;i++){
            frames[i] = "img/cat/Idle ("+(i+1)+").png";
        }
        Animation idleR = new Animation(50,frames);
        idleR.resize(100,87);
        idleR.setBounds(18,4,54,80);
        
        Animation idleL = new Animation(50,frames);
        idleL.resize(100,87);
        idleL.flipHorizontally();
        idleL.setBounds(28,4,54,80);
        
        frames = new String[8];
        for(int i=0;i<8;i++){
            frames[i] = "img/cat/Fall ("+(i+1)+").png";
        }
        Animation fallR = new Animation(50,frames);
        fallR.resize(100,87);
        fallR.setBounds(18,4,54,80);

        Animation fallL = new Animation(50,frames);
        fallL.resize(100,87);
        fallL.flipHorizontally();
        fallL.setBounds(28,4,54,80);
        
        setWalkRightAnimation(walkR);
        setWalkLeftAnimation(walkL);
        setIdleRightAnimation(idleR);
        setIdleLeftAnimation(idleL);
        setFallRightAnimation(fallR);
        setFallLeftAnimation(fallL);
    }
    
    public void act()
    {
        super.act();
    }
    
    public void increaseScore( int i){
        score+=i;
    }
    public int getScore(){
        return score;
    }
    
    public void decreaseLives(){
        lives--;
    }
    public int getLives(){
        return lives;
    }
    
    private void updateText(){
        World w = getWorld();
        w.removeText(10,30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
}
