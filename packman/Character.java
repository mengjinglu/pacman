package packman;

import static packman.Direction.*;
import java.util.*;

public class Character {
    //This class defines all moving things within this game. The Grade Guy
    //and the ghosts will extend this class when their functionality is more
    //clearly known. For now it stands simply as a way to test the primary
    //functionality of motion and collision logic.

    private double x;
    private double y;
    private double speed;
    private Direction dir;
    private final Field field;
    private vertex v1;
    private vertex v2;
    private double gpa;

    public Character(double x, double y, double speed, Direction dir, Field field, vertex v1, vertex v2, double gpa) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
        this.field = field;
        this.v1 = v1;
        this.v2 = v2;
        this.gpa = gpa;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void move() {
        if (dir == LEFT && field.canMove(x, y, LEFT, v1, v2)) {
            x -= speed;
        } else if (dir == RIGHT && field.canMove(x, y, RIGHT, v1, v2)) {
            x += speed;
        } else if (dir == UP && field.canMove(x, y, UP, v1, v2)) {
            y -= speed;
        } else if (dir == DOWN && field.canMove(x, y, DOWN, v1, v2)) {
            y += speed;
        }
        if (field.isEdible(x, y) && field.isVisible(x, y)) {
            setGPA(field.getEdiblePoints(x, y));
            System.out.println("Edible eaten!");
        }

    }

    public void moveDir(Direction dir) { //useful for generating the field
        if (dir == LEFT) {
            x -= speed;
        } else if (dir == RIGHT) {
            x += speed;
        } else if (dir == UP) {
            y -= speed;
        } else if (dir == DOWN) {
            y += speed;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setV1(vertex v1) {
        this.v1 = v1;
    }

    public void setV2(vertex v2) {
        this.v2 = v2;
    }

    public List<Edible> getEdiblesToDisplay(){
        return field.getVisibleEdibles();
    }

    @Override
    public String toString() {
        return v1.x + " " + v1.y + "\t" + v2.x + " " + v2.y;
    }

    public void setSpeed(double speed) {
        this.speed = speed; //for testing purposes
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
}