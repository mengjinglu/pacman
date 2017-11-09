package packman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static packman.Direction.DOWN;
import static packman.Direction.LEFT;
import static packman.Direction.RIGHT;
import static packman.Direction.UP;


public class Enemy extends DynamicEntity {
    private Field field;
    Random rand = new Random();
    int randNum = rand.nextInt(2);
    public Enemy(double x, double y, double speed, Direction direction, Field field, vertex v1, vertex v2) {
        super(x, y, speed, direction, v1, v2);
        this.field = field;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void move() {
        if (field.canMove(this.xPos, this.yPos, LEFT, v1, v2)) {
            moveDirection(this.direction);
            //System.out.println("x: " + xPos + " getX(): " + getX());     
        } else if (field.canMove(xPos, yPos, RIGHT, v1, v2)) {
            moveDirection(this.direction);
        } else if (field.canMove(xPos, yPos, UP, v1, v2)) {
            moveDirection(this.direction);
        } else if (field.canMove(xPos, yPos, DOWN, v1, v2)) {
            moveDirection(this.direction);        
        } else {
            //System.out.println("cant move "+this.direction.toString());
        }
        //System.out.println(this.toString());
    }

//    private Direction calcDirection() {
//        List<Direction> dirList = new ArrayList<>();
//        dirList.add(direction.DOWN);
//        dirList.add(direction.UP);
//        dirList.add(direction.RIGHT);
//        dirList.add(direction.LEFT);
//        
//        if (this.direction == direction.UP)
//            dirList.remove(direction.DOWN);
//        else if (this.direction == direction.DOWN)
//            dirList.remove(direction.UP);
//        else if (this.direction == direction.LEFT)
//            dirList.remove(direction.RIGHT);
//        else 
//            dirList.remove(direction.LEFT);
//        
//        int i = 2;
//        int randDir = rand.nextInt((i - 0) + 1) + 0;
//        while (!field.canMove(xPos, yPos, dirList.get(randDir), v1, v2)) {
//            dirList.remove(randDir);
//            i--;
//            randDir = rand.nextInt((i-0)+1)+0;
//        }
//        return dirList.get(randDir);
//    }
    public void changeDirection() {
       // setDirection(calcDirection());
        
        if (field.canMove(this.xPos, this.yPos, Direction.UP, this.v1, this.v2)){
            setDirection(Direction.UP);
        } else if (field.canMove(this.xPos, this.yPos, Direction.DOWN, this.v1, this.v2)) {
            setDirection(Direction.DOWN);
        } else if (field.canMove(this.xPos, this.yPos, Direction.LEFT, this.v1, this.v2)) {
             setDirection(Direction.LEFT);
        } else {
            setDirection(Direction.RIGHT);
        }

//        switch(rand){
//                case 1: setDirection(Direction.UP); break;
//                case 2: setDirection(Direction.DOWN); break;
//                case 3: setDirection(Direction.LEFT); break;
//                case 4: setDirection(Direction.RIGHT); break;}
        
    }

    @Override
    public void moveDirection(Direction dir) {
        switch (dir) {
            case UP     : yPos -= speed ; break;
            case DOWN   : yPos += speed ; break;
            case LEFT   : xPos -= speed ; break;
            case RIGHT  : xPos += speed ; break;
        }
    }
    
    public boolean isAtVertex() {
        for (vertex v : field.getFieldVertices().keySet()) {
            if ((this.getX() == v.x) && (this.getY() == v.y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    //public abstract double deductGPA(GradeGuy gg, double GPA);
    public double getX(){
        return this.xPos;
    }

    public double getY(){
        return this.yPos;
    }
    
    @Override
    public String toString() {
        return "\nEnemy @ x: "+this.getX()+" y: "+this.getY()+" moving "+this.direction.toString();
    }
    
}