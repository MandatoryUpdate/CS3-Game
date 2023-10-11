import mayflower.*;
public class Level3 extends Level
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
                                     {"","","","","","ground","ground","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
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
                                     {"","","","key()","","","key()","","","","ground","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","","","","","","","","","","",""},
                                     {"","","","","","lock(4)","key()","","","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                };
                                            
    public Level3()
    {
        super(tiles);
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
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
