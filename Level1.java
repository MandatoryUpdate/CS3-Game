import mayflower.*;
public class Level1 extends Level
{
    private Cat cat;
    private int y;
    private static String[][][] tiles =  { 
                                   { 
                                     {"","","","","","","","","","","","","","","",""}, 
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""}, 
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","food(500)","food(300)","food(150)","food(200)","","","","","","","",""},
                                     {"","","","","","","","","","","","lock(2)","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                   { 
                                     {"","","","","","","","","","","","","","","",""}, 
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","key()","","","","","","","","","","","","","",""},
                                     {"","ground","punk(100,220,300)","","","ground","","","","","","","","","",""}, 
                                     {"","","ground","ground","ground","","","","","","","","","","",""},
                                     {"","","","","","","ground","ground","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","ground","ground","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","ground",""},
                                     {"ground","","ground","lava","lava","ground","","","","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                };
                                            
    public Level1()
    {
        super(tiles);
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
        cat.setLives(3);
        showText("Score: "+cat.getScore()+" Lives: "+cat.getLives(), 10, 30, Color.BLACK);
    }
    public void act(){
        y = cat.getY();
        if(cat.getX()>740 && getPart()+1<tiles.length){
            increment();
            cat.setLocation(50,y);
        }
        if(cat.getX()<10 && getPart()-1>-1){
            decrease();
            cat.setLocation(730,y);
        }
    }
    public void setTiles(String[][][] t){
        tiles = t;
    }
}
