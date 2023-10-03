
import mayflower.*;
import java.util.*;
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
                if(tiles[part][r][c].equals("ground"))
                    addObject(new Block(), c*50, r*50);
                if(tiles[part][r][c].length()>0 && tiles[part][r][c].substring(0,1).equals("p"))
                    addObject(new Punk(Integer.parseInt(tiles[part][r][c].substring(5,8)),Integer.parseInt(tiles[part][r][c].substring(9,12)),Integer.parseInt(tiles[part][r][c].substring(13,15))),c*100, r*100);
            }
        }
    }
    public void increment(){
        part++;
        removeObjects(getObjects(Block.class));
        removeObjects(getObjects(Enemy.class));
        buildScreen(part);
    }
    public void decrease(){
        part--;
        removeObjects(getObjects(Block.class));
        removeObjects(getObjects(Enemy.class));
        buildScreen(part);
    }
    public int getPart(){
        return part;
    }
}
