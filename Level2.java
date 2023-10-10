import mayflower.*;
public class Level2 extends Level
{
    private Cat cat;
    private int y;
    //Make tiles size 12x16
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
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","key()","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                   { 
                                     {"","","","","","","","","","","","","","","",""}, 
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","punk(200,400,300)","","","","","","","","","","","","",""}, 
                                     {"","","","","ground","","","","","ground","","","","","",""},
                                     {"","","","","","","","ground","","ground","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","ground","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","lock(3)","","","","","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                };
                                            
    public Level2()
    {
        super(tiles);
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
        showText("Score: "+cat.getScore()+" Lives: "+cat.getLives(), 10, 30, Color.BLACK);
    }
    public void act(){
        if(cat.getX()>740 && getPart()+1<tiles.length){
            y = cat.getY();
            increment();
            cat.setLocation(50,y);
        }
        if(cat.getX()<10 && getPart()-1>-1){
            decrease();
            cat.setLocation(730,400);
        }
    }
    public void setTiles(String[][][] t){
        tiles = t;
    }
}
