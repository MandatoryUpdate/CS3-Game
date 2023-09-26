
import mayflower.*;
public class TitleScreen extends World
{
    private StartButton start = new StartButton("img/dog/Fall (2).png","img/dog/Dead (4).png");
    private EndButton end = new EndButton("img/dog/Fall (2).png","img/dog/Dead (4).png");
    public TitleScreen(){
        setBackground("img/BG/BG.png");
        showText("CS3 Game: ", 100, 300, Color.BLACK);
        addObject(start,300,400);
        addObject(end,600,400);
    }
    public void act(){

    }
}
