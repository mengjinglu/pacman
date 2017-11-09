/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

/**
 *
 * @author mengjinglu
 */
public class Trustee extends Enemy{
    
        public Trustee(double x, double y, double speed, Direction direction, Field field, vertex v1, vertex v2){
        super(x, y,speed,direction,field,v1,v2);
        
    }   
       
        public double deductGPA(GradeGuy gg, double GPA){
            if(GPA > 2.0)
            return GPA-0.5;//trustee explode
            if(GPA < 2.0){
               gg.lives--;
            }
            return GPA;
        }
       
        public boolean isCollided(GradeGuy gg, Dean e){
         if(gg.getX()==e.getX()&&gg.getY()==e.getY()){
             System.out.println("Collision detected!");
             //isCollided = true;
             gg.setGPA(deductGPA(gg,gg.getGPA()));
             return true;
         }else
        return false;
    }
    
}

