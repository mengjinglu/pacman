package packman;


import static packman.Direction.*;

/** This class represents all game entities that do not move (dots, power-ups ext.) */
public abstract class StaticEntity {
    protected  double xPos, yPos;
    protected Direction direction;
        boolean isCollided=false;


    public StaticEntity(double xPos, double yPos, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public abstract void setDirection(Direction direction);
    public boolean isCollided(DynamicEntity gg, DynamicEntity e){
         if(gg.getX()==e.getX()&&gg.getY()==e.getY()){
             System.out.println("Collision detected!");
             Sound.pac_begin.play();
        
             isCollided = true;
        
             
             return isCollided;
         }
        return isCollided;
    }
    public double getX(){
        return this.xPos;
    }

    public double getY(){
        return this.yPos;
    }
}