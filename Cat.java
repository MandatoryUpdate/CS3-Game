import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private static int score = 0;
    private static int lives = 3;
    public Cat(){
        String[] frames = new String[6];
        for(int i=0;i<6;i++){
            frames[i] = "img/3 Cyborg/Run/run"+i+".png";
        }
        Animation walkR = new Animation(100000000,frames);
        walkR.resize(40,40);
        // walkR.setBounds(18,4,54,80);
        
        Animation walkL = new Animation(100000000,frames);
        walkL.resize(40,40);
        walkL.flipHorizontally();
        // walkL.setBounds(28,4,54,80);
        
        frames = new String[4];
        for(int i=0;i<4;i++){
            frames[i] = "img/3 Cyborg/Idle/idle"+i+".png";
        }
        Animation idleR = new Animation(100000000,frames);
        idleR.resize(40,40);
        // idleR.setBounds(18,4,54,80);
        
        Animation idleL = new Animation(100000000,frames);
        idleL.resize(40,40);
        idleL.flipHorizontally();
        // idleL.setBounds(28,4,54,80);
        
        frames = new String[4];
        for(int i=0;i<4;i++){
            frames[i] = "img/3 Cyborg/Jump/jump"+i+".png";
        }
        Animation fallR = new Animation(100000000,frames);
        fallR.resize(40,40);
        // fallR.setBounds(18,4,54,80);

        Animation fallL = new Animation(100000000,frames);
        fallL.resize(40,40);
        fallL.flipHorizontally();
        // fallL.setBounds(28,4,54,80);
        
        frames = new String[4];
        for(int i=0;i<4;i++){
            frames[i] = "img/3 Cyborg/Jump/jump"+i+".png";
        }
        Animation jumpR = new Animation(100000000,frames);
        jumpR.resize(40,40);
        // jumpR.setBounds(18,4,54,80);

        Animation jumpL = new Animation(100000000,frames);
        jumpL.resize(40,40);
        jumpL.flipHorizontally();
        // jumpL.setBounds(28,4,54,80);
        
        setWalkRightAnimation(walkR);
        setWalkLeftAnimation(walkL);
        setIdleRightAnimation(idleR);
        setIdleLeftAnimation(idleL);
        setFallRightAnimation(fallR);
        setFallLeftAnimation(fallL);
        setJumpRightAnimation(jumpR);
        setJumpLeftAnimation(jumpL);
    }
    
    public void act()
    {
        super.act();
        this.updateText();

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
