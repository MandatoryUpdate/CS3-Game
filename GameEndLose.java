import mayflower.*;
public class GameEndLose extends World 
{
    private StartButton restart = new StartButton("img/Button/restartButtonHighlight.png","img/Button/restartButton.png");
    private EndButton exit = new EndButton("img/Button/exitButtonHighlight.png", "img/Button/exitButton.png");
    
    public GameEndLose() 
    {
        setBackground("lose.png");
        
    }
    
    public void act()
    {
        showText("GAME OVER You Lost!",200, 200, Color.BLACK);
        
        addObject(restart, 25, 300);
        restart.scale(200,100);
        
        addObject(exit, 300, 300);
        exit.scale(200,100);
    }
    
}
