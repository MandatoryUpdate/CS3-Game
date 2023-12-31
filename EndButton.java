
import mayflower.*;
public class EndButton extends Actor
{
    private String unhighlighted;
    private String highlighted;
    Level1 level1 = new Level1();
    
    public EndButton(String u, String h)
    {
        unhighlighted = u;
        highlighted = h;
        setImage(unhighlighted);
    }
    public void act(){
        if (Mayflower.mouseMoved(this))
            setImage(unhighlighted);
        if (Mayflower.mouseMoved(null) && !Mayflower.mouseMoved(this))
            setImage(highlighted);
        if(Mayflower.mouseClicked(this))
        {
            Mayflower.exit();
        }
    }
}
