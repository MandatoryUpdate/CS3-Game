
import mayflower.*;
public class Level1 extends Level
{
    private Cat cat;
    private static String[][][] tiles =  { 
                                   { 
                                     {"","","","","","","",""}, 
                                     {"","","","","","","",""},
                                     {"","","","","","","",""},
                                     {"","","","","","","",""}, 
                                     {"","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   { 
                                     {"","","","","","","",""}, 
                                     {"","","","","","","",""},
                                     {"","","","","","","",""},
                                     {"","","","","","","",""}, 
                                     {"","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                };
                                            
    public Level1()
    {
        super(tiles);
        setBackground("img/BG/BG.png");
        cat = new Cat();
        addObject(cat, 400, 100);
        showText("Score: "+cat.getScore()+" Lives: "+cat.getLives(), 10, 30, Color.BLACK);
    }
    public void act(){
        
    }
}
