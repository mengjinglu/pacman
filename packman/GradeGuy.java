package packman;

import static packman.Direction.*;

public class GradeGuy extends DynamicEntity {
    private final Field field;
    public int lives = 1;
    private double GPA = 0.000;
    public GradeGuy(double x, double y, double speed, Direction dir, Field field, vertex v1, vertex v2) {
        super(x, y, speed, dir, v1, v2);
        this.field = field;
    }

    public void moveDirection(Direction dir) {
        if(dir == Direction.LEFT){
            this.xPos -= speed;
        }
        else if(dir == Direction.RIGHT){
            this.xPos += speed;
        }
        else if(dir == Direction.UP){
            this.yPos -= speed;
        }
        else if(dir == Direction.DOWN){
            this.yPos += speed;
        }
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public void setSpeed(double speed) {
        this.speed = speed; //for testing purposes
    }

    public void move() {
         if (this.direction == LEFT && field.canMove(this.xPos, this.yPos, LEFT, v1, v2)) {
            xPos -= speed;
            System.out.println("x: " + xPos + " getX(): " + getX());
            if (field.isEdible(xPos, yPos) && field.isVisible(xPos, yPos)) {  //checks if theres a valid edible at GradeGuy's current location
                setGPA(field.getEdiblePoints(xPos, yPos));//updates gpa with the acquired edible's points
                System.out.println("Edible eaten!"); //for testing purposes
            }
        } else if (this.direction == RIGHT && field.canMove(xPos, yPos, RIGHT, v1, v2)) {
            xPos += speed;
            if (field.isEdible(xPos, yPos) && field.isVisible(xPos, yPos)) {
                setGPA(field.getEdiblePoints(xPos, yPos));
                System.out.println("Edible eaten!");
            }
        } else if (this.direction == UP && field.canMove(xPos, yPos, UP, v1, v2)) {
            yPos -= speed;
            if (field.isEdible(xPos, yPos) && field.isVisible(xPos, yPos)) {
                setGPA(field.getEdiblePoints(xPos, yPos));
                System.out.println("Edible eaten!");
            }
        } else if (this.direction == DOWN && field.canMove(xPos, yPos, DOWN, v1, v2)) {
            yPos += speed;
            if (field.isEdible(xPos, yPos) && field.isVisible(xPos, yPos)) {
                setGPA(field.getEdiblePoints(xPos, yPos));
                System.out.println("Edible eaten!");
            }
        }
    }
//    public boolean isCollided(GradeGuy gg, Enemy e1){
//        if(gg.v1 == e1.v1)
//            return true;
//        return false;
//    }
    public void lifeLost(){
        lives--;
    }
    public void gainLives(){
        lives++;
    }
    public void setLives(int i){
        lives = i;
    }
    public int getLives(){
        return lives;
    }
    public void setGPA(double gpa){
        this.GPA = gpa;
    }    
    public double getGPA(){
        return GPA;
    }
    
}