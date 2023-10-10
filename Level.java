
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
                String str = tiles[part][r][c];
                System.out.print(str);
                if(str.equals("ground"))
                    addObject(new Block(), c*50, r*50);
                if(str.equals("lava"))
                    addObject(new Lava(), c*50, r*50);
                if(str.length()>0 && str.substring(0,4).equals("punk"))
                    addObject(new Punk(Integer.parseInt(str.substring(5,8)),Integer.parseInt(str.substring(9,12)),Integer.parseInt(str.substring(13,16))),c*50, r*50);
                if(str.length()>0 && str.substring(0,3).equals("key")){
                    addObject(new Key(part,c*50, r*50),c*50, r*50);
                    tiles[part][r][c] = "";
                }
                if(str.length()>0 && str.substring(0,4).equals("food")){
                    Food food = new Food(part,Integer.parseInt(str.substring(5,8)));
                    addObject(food,c*50, r*50);
                    food.hide();
                    food.appear(part);
                    tiles[part][r][c] = "";
                }
                if(str.length()>0 && str.substring(0,4).equals("lock")){
                    addObject(new Lock(part,Integer.parseInt(str.substring(5,6)),c*50, r*50),c*50, r*50);
                    tiles[part][r][c] = "";
                }
            }
            System.out.println("");
        }
    }
    public void increment(){
        part++;
        List<Collectable> objects = getObjects(Collectable.class);
        for(int i=0;i<objects.size();i++){
            objects.get(i).hide();
            objects.get(i).appear(part);
        }
        removeObjects(getObjects(Hazard.class));
        removeObjects(getObjects(Block.class));
        removeObjects(getObjects(Enemy.class));
        
        buildScreen(part);
    }
    public void decrease(){
        part--;
        List<Collectable> objects = getObjects(Collectable.class);
        for(int i=0;i<objects.size();i++){
            objects.get(i).hide();
            objects.get(i).appear(part);
        }
        removeObjects(getObjects(Hazard.class));
        removeObjects(getObjects(Block.class));
        removeObjects(getObjects(Enemy.class));
        
        buildScreen(part);
    }
    public int getPart(){
        return part;
    }
}
