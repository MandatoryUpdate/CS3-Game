import mayflower.*;

public class GameEndWin extends World 
{
    
    public GameEndWin() 
    {
    	setBackground("img/bg/lose.png");
    	
    }
    
    public void act()
    {
        showText("You Win!",335, 200, Color.BLACK);
    }
    
}
