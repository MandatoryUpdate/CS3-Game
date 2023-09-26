
import mayflower.*;
public class Level extends World
{
    private String[][][] tiles;
    int part = 0;
    public Level(String[][][] t){
       tiles = t;
       buildScreen(part);
    }
    public void act(){
        
    }
    
    public void buildScreen(int part){
        for(int r=0;r<tiles[part].length;r++){
            for(int c=0;c<tiles[part][0].length;c++){
                System.out.println(tiles[part][r][c]);
                if(tiles[part][r][c].equals("ground")){
                    System.out.println("read");
                    addObject(new Block(), c*100, r*100);
                }
            }
        }
    }
    public void increment(){
        part++;
        removeObjects(getObjects(Block.class));
        buildScreen(part);
    }
    public void decrease(){
        part--;
        removeObjects(getObjects(Block.class));
        buildScreen(part);
    }
    public int getPart(){
        return part;
    }
}
