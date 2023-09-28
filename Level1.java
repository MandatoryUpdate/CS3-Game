import mayflower.*;
public class Level1 extends Level
{
    private Cat cat;
    private int y;
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
                                     {"","","","","ground","","",""},
                                     {"","","","","","","",""}, 
                                     {"","","","","","","",""},
                                     {"ground","ground","ground","ground","ground","ground","ground","ground"},
                                   },
                                   
                                };
                                            
    public Level1()
    {
        super(tiles);
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
        showText("Score: "+cat.getScore()+" Lives: "+cat.getLives(), 10, 30, Color.BLACK);
    }
    public void act(){
        System.out.println(cat.getX());
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
