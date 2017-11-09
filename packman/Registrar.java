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
public class Registrar extends Enemy {
     public Registrar(double x, double y, double speed, Direction direction, Field field, vertex v1, vertex v2){
        
        super(x, y,speed,direction,field,v1,v2);
       
    }   
        
        public boolean isCollided(GradeGuy gg, Dean e){
         if(gg.getX()==e.getX()&&gg.getY()==e.getY()){
             System.out.println("Collision detected!");
             //isCollided = true;
             gg.setGPA(deductGPA(gg.getGPA()));
             return true;
         }else
        return false;
    }
        public double deductGPA(double GPA){
            return GPA-0.1;
        }
}
