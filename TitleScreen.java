
import mayflower.*;
public class TitleScreen extends World
{
    private StartButton start = new StartButton("img/Button/playButton.png","img/Button/playButton.png");
    private EndButton end = new EndButton("img/Button/exitButton.png","img/Button/exitButton.png");
    public TitleScreen(){
        setBackground("img/BG/BG.png");
        showText("Apocalypse Frontier", 100, 300, Color.BLACK);
        addObject(start,25,300);
        start.scale(200,100);
        addObject(end,300,300);
        end.scale(200,100);
    }
    public void act(){

    }
}
