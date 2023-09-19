import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
        Block block = new Block();
        addObject(block,400,500);
        Block block2 = new Block();
        addObject(block2,528,372);
        showText("Score: "+cat.getScore()+" Lives: "+cat.getLives(), 10, 30, Color.BLACK);
    }
    
    public void act()
    {
        
    }
    
}