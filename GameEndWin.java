import mayflower.*;

public class GameEndWin extends World 
{
    private RestartButton restart = new RestartButton("img/Button/restartButton.png","img/Button/restartButton.png");
    private EndButton exit = new EndButton("img/Button/exitButton.png", "img/Button/exitButton.png");
    public GameEndWin() 
    {
        setBackground("img/bg/lose.png");
        showText("You Win!",335, 200, Color.BLACK);
        addObject(restart, 25, 300);
        restart.scale(200,100);
        addObject(exit, 300, 300);
        exit.scale(200,100);
    }
    
    public void act(){
    }
    
}
