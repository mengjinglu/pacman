package packman;
import java.util.List;
import static packman.Direction.*;

/** This class represents all game entities that do move (GradeGuy, Enemies, Professors, ext.) */
public abstract class DynamicEntity extends StaticEntity {
    protected double speed;
    protected vertex v1;
    protected vertex v2;
    protected final Field field;

    public DynamicEntity(double x, double y, double speed, Direction dir, vertex v1, vertex v2) {
        super(x, y, dir);
        this.v1 = v1;
        this.v2 = v2;
        this.speed = speed;
        this.field = new Field();
    }
 public List<Edible> getEdiblesToDisplay(){
        return field.getVisibleEdibles();
    }

    public abstract void move();
    public abstract void moveDirection(Direction dir);
    
    public void pauceIfCollided(){
        
            System.out.println("pauced");
        
    }
    public void setV1(vertex v1){
        this.v1 = v1;
    }
    public void setV2(vertex v2){
        this.v2 = v2;
    }
    public abstract void setSpeed(double speed);

    @Override
    public String toString(){
        return v1.x + " " + v1.y + "\t" + v2.x + " " + v2.y;
    }
   
    
}