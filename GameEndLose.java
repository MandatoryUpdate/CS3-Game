import mayflower.*;
public class GameEndLose extends World 
{
    private StartButton restart = new StartButton("img/dog/Fall (2).png","img/dog/Dead (4).png");
    
    public GameEndLose() 
    {
    	setBackground("img/BG/lose.png");
    	
    }
    
    public void act()
    {
        showText("You Lost!",335, 200, Color.BLACK);
        addObject(restart, 300, 200);
    }
    
}