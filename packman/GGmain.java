package packman;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import static packman.Direction.*;
/**
 * Main program creates GUI and runs it.
 * This is mainly for testing purposes by Graphics Team
 * and will be modified often to test programs.
 */

class pos{
    double x;
    double y;
    
    pos(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    double abs(double a){
        if(a < 0)
            return a * -1;
        return a;
    }
    
    @Override
    public boolean equals(Object p){
        //assume p will be a pos
        if(abs(((pos)p).x - x) < 0.0001 && abs(((pos)p).y - y) < 0.0001)
            return true;
        return false;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
}

public class GGmain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Generates a window to place all GUI components.
     */
    boolean generateField = false;
    boolean printResult = false;
    int position = 0;
    boolean L = true;
    boolean R = true;
    boolean U = true;
    boolean D = true;
    boolean W = false;
    ArrayList<pos> verts = new ArrayList<>();
    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    ArrayList<String> enemyList = new ArrayList<>(Arrays.asList("Dean", "Trustee","Registrar"));
    public void start(Stage primaryStage) {
        /*GameScreenScene secondModule = new GameScreenScene();
        StackPane root = new StackPane();
        //Group root = new Group();

        Scene primaryScene = new Scene(root, 800, 600);
        Scene gameScene = new Scene(secondModule.getView(), 800, 600);

        primaryStage.setTitle("Grade Guy");
        primaryStage.setScene(gameScene);
        primaryStage.setResizable(false);
        //primaryStage.show();
        */
        primaryStage.setTitle( "Grade Guy Alpha" );
        
        Group root = new Group();
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );
        
        
        Canvas canvas = new Canvas( 680, 600 );
        root.getChildren().add( canvas );
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Image gradeGuy = new Image( "images/GG.png" );
        Image Dean = new Image("images/Dean.png");
        Image Trustee = new Image("images/Trustee.png");
        Image Registrar = new Image("images/Registrar.png");
        Image background = new Image( "images/TestPacmanLevel.png");
        
        Image pellet = new Image("images/pellet.png");
        Image gradeA = new Image("images/GradeA.png");
        Image gradeAplus = new Image("images/GradeA+.png");
        
        
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
                
        ArrayList<String> input = new ArrayList<>();
        
        theScene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();

                    if ( !input.contains(code) )
                        input.add(code);
                });
 
        theScene.setOnKeyReleased(
                e -> {
                    String code = e.getCode().toString();
                    input.remove(code);
                });
        
        vertex v0 = new vertex(291.2857142857143, 443.0);
        vertex v1 = new vertex(358.0, 443.0);
        vertex v2 = new vertex(291.2857142857143, 443.0);
        vertex v3 = new vertex(358.0, 443.0);
        vertex v5 = new vertex(581.0, 501.0);
        
        Field gameField = new Field();
        Field testField = new Field();
        GradeGuy GG = new GradeGuy(325,442,1,RIGHT, gameField,v0,v1);
        Character chr = new Character(325, 442, 1, LEFT, new Field(), v0, v1, 0);
        Dean  dean = new Dean(581.0, 501.0, 1, DOWN, testField, v0, v1);
        Trustee trustee = new Trustee(218.125, 501.0, 1, UP, testField, v3, v5);
        Registrar registrar = new Registrar(70.5, 501.0, 1, UP, testField, v2, v5);
        
        KeyFrame kf = new KeyFrame(
            Duration.seconds(0.017),                // 60 FPS
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent ae)
                {
                    playGame(input,GG,gc,background,gradeGuy,Dean,Trustee,Registrar,pellet, gradeA, gradeAplus,dean, trustee, registrar);
                    //moveEnemies(enemy1, enemy2, enemy3);
                    
                    //setUpField(input,GG,gc,background,gradeGuy);
                }
            });
        
        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
        
        primaryStage.show();
    }
    /**
     Gameover
     */
    public void GameOver() {
        Stage Gameover = new Stage();
        StackPane root = new StackPane();
        Button space = new Button("View Score");
        Label msg = new Label("You lost the game, press SPACE to view the score.");
        root.setId("gameOverPane"); 
        root.getChildren().addAll(space,msg); 
        Scene scene = new Scene(root, 400, 300); 
        Gameover.setScene(scene); 
        Gameover.show(); 
    }
    public void playGame(ArrayList<String> input, DynamicEntity GG, GraphicsContext gc, 
            Image background, Image gradeGuy, Image Dean, Image Trustee, Image Registrar,
            Image pellet, Image gradeA, Image gradeAplus,Dean dean, Trustee trustee,Registrar registrar){
        if (input.contains("RIGHT"))
                        GG.setDirection(RIGHT);
                    if (input.contains("LEFT"))
                        GG.setDirection(LEFT);
                    if (input.contains("UP"))
                        GG.setDirection(UP);
                    if (input.contains("DOWN"))
                        GG.setDirection(DOWN);
                    if (input.contains("W")){
                       System.out.println(GG);
                       System.out.println(GG.getX() + "\t" + GG.getY());
                    }


                    GG.move();
                    //update our character
                    
                    /**
                     * Threads for enemies, move dean, the next enemy will move in 10 seconds.
                     */
//                 Runnable r1 = new Runnable() {
//                  public void run() {
//                     moveEnemies(dean);
//                   }
//                  };
//                       Thread t1 = new Thread(r1);
//                       t1.start();
//                   /**
//                    * Thread to move registrar
//                    */
//                   Runnable r2 = new Runnable() {
//                    public void run() {
//                        try{
//                            while(true){
//                                Thread.sleep(10000L);
//                                 moveEnemies(registrar);
//                            }
//                        }catch(InterruptedException iex){
//                            
//                        }
//                       System.out.println("thread running!");
//                     }
//                    };
//                   Thread t2 = new Thread(r2);
//                   t2.start();
//                   /**
//                    * Thread to move trustee
//                    */
//                   Runnable r3 = new Runnable() {
//                    public void run() {
//                        try{
//                            while(true){
//                                Thread.sleep(10000);
//                                 moveEnemies(trustee);
//                            }
//                        }catch(InterruptedException iex){
//                            
//                        }
//                       
//                    }
//                    };
//                   Thread t3 = new Thread(r3);
//                   t3.start();
//                    //moveEnemies(dean, trustee, registrar);
//                    Timer time = new Timer();
//                    time.scheduleAtFixedRate(new TimerTask(){
//                        public void run(){
//                              moveEnemies(dean);
//                     }
//                        }, 0, 1000 * 5);   
//                    Timer time1 = new Timer();
//                    time1.scheduleAtFixedRate(new TimerTask(){
//                        public void run(){
//                              moveEnemies(trustee);
//                     }
//                        }, 0, 1000 * 10);   

                    moveEnemies(dean, trustee, registrar);
                    GG.isCollided(GG, dean);
                    GG.isCollided(GG, trustee);
                    GG.isCollided(GG, registrar);
                    
                    
                    gc.clearRect(0, 0, 800,600);    // Clear the canvas 

                    // background image clears canvas
                    gc.drawImage( background, 0, 0);
                    gc.drawImage( gradeGuy, GG.getX(), GG.getY() );
                    gc.drawImage( Dean, dean.getX(), dean.getY());
                    gc.drawImage( Trustee, trustee.getX(), trustee.getY());
                    gc.drawImage( Registrar, registrar.getX(), registrar.getY());
                    
                    for (Edible v : GG.getEdiblesToDisplay()) {
            gc.drawImage(pellet, v.location.x, v.location.y);
        }
                    
    }

    public void moveEnemies(Enemy ... enemies) {
        for (Enemy e : enemies) {
            e.move();
            if (e.isAtVertex()) {
                //System.out.println("Enemy hit a vertex");GameOver();
                
                e.changeDirection();
                e.move();
            }
        }
    }
    
    public void setUpField(ArrayList<String> input, DynamicEntity GG, GraphicsContext gc, Image background, Image gradeGuy, Image Dean, Image Trustee, 
            Image Registrar, Dean dean, Trustee trustee,Registrar registrar){
        ///the following will print out the field based off of how you position GG. Press the w key to add a vertex at every intersection and the program will do the rest.        
        if(!generateField){
            if (input.contains("LEFT"))
                GG.moveDirection(LEFT);
            if (input.contains("RIGHT"))
                GG.moveDirection(RIGHT);
            if (input.contains("UP"))
                GG.moveDirection(UP);
            if (input.contains("DOWN"))
                GG.moveDirection(DOWN);
            if (input.contains("W"))
                if(!verts.contains(new pos(GG.getX(),GG.getY())))
                    verts.add(new pos(GG.getX(),GG.getY()));
            if (input.contains("D")){//D is for done
                for(int x = 0; x < verts.size(); x++)
                    edges.add(new ArrayList<>());
                generateField = true;
                System.out.println("For every vertex that pops up, press the appropriate arrow keys for which direction a vertex exists in. When you finish with a vertex press W. When this finishes the code for the field will print out. "
                        + "Don't worry about getting vertices to line up perfectly, do it as closely as you can and the program will smooth it out when you're done.");
            }
            //GG.move(); //update our character
            // Clear the canvas 
           gc.clearRect(0, 0, 800,600);

           // background image clears canvas
           gc.drawImage( background, 0, 0);
           gc.drawImage( gradeGuy, GG.getX(), GG.getY() );
//           gc.drawImage( Dean, enemy1.getX(), enemy1.getY());
//           gc.drawImage( Trustee, enemy2.getX(), enemy2.getY());
//           gc.drawImage( Registrar, enemy3.getX(), enemy3.getY());


           for(pos i : verts){
               gc.drawImage(gradeGuy, i.x, i.y);
           }
        }
        else{
            gc.clearRect(0, 0, 800,600);
            gc.drawImage( background, 0, 0);
            gc.drawImage(gradeGuy,verts.get(position).x,verts.get(position).y);
            if (input.contains("LEFT") && L){
                (edges.get(position)).add(getClosest(position,verts,LEFT));
                System.out.println("LEFT" + edges.get(position).get(edges.get(position).size()-1) );
            }
            if (input.contains("RIGHT") && R){
                (edges.get(position)).add(getClosest(position,verts,RIGHT));
                System.out.println("RIGHT" + edges.get(position).get(edges.get(position).size()-1) );
            }
            if (input.contains("UP") && U){
                (edges.get(position)).add(getClosest(position,verts,UP));
                System.out.println("UP" + edges.get(position).get(edges.get(position).size()-1) );
            }
            if (input.contains("DOWN") && D){
                (edges.get(position)).add(getClosest(position,verts, DOWN));
                System.out.println("DOWN" + edges.get(position).get(edges.get(position).size()-1) );
            }
            if (input.contains("W") && W){
                position += 1;
                W = false;
                L = R = U = D = true;
            }

            if(position == verts.size()){
                smoothVerts(5); //takes in the index of closeness
                System.out.println("field = new HashMap<>();");
                for(int i = 0; i < verts.size(); i++){
                    System.out.println("vertex v" + i + " = new vertex(" + verts.get(i).x + ", " + verts.get(i).y + ");");
                }

                for(int i = 0; i < edges.size(); i++){
                    System.out.print("field.put( v" + i + ", Arrays.asList(");
                    String temp = "";
                    for(int v : edges.get(i)){
                        temp += "v";
                        temp += v;
                        temp += ", ";
                    }
                    temp = temp.substring(0,temp.length()-2);
                    temp += "));";
                    System.out.println(temp);
                }
                generateField = false;
            }
        }
    }
    
    public void smoothVerts(double closeness){
        ArrayList<Integer> horizontal = new ArrayList<>();
        ArrayList<Integer> vertical = new ArrayList<>();
        for(int i = 0; i < verts.size(); i++){
            horizontal.add(i);
            vertical.add(i);
        }
        
        while(!horizontal.isEmpty()){
            ArrayList<pos> temp = new ArrayList<>();
            ArrayList<Integer> toRemove = new ArrayList<>();
            temp.add(verts.get(horizontal.get(0)));
            horizontal.remove(0);
            double tempAvg = temp.get(0).y;
            
            for(int k : horizontal){
                if(abs(verts.get(k).y - temp.get(0).y) < closeness){
                    temp.add(verts.get(k));
                    toRemove.add(k);
                    tempAvg += verts.get(k).y;
                }
            }
            
            for(int k : toRemove)
                horizontal.remove(Integer.valueOf(k));
            
            tempAvg /= temp.size();
            
            for(int i = 0; i < temp.size(); i++){
                temp.get(i).setY(tempAvg);
            }
        }
        
        while(!vertical.isEmpty()){
            ArrayList<pos> temp = new ArrayList<>();
            ArrayList<Integer> toRemove = new ArrayList<>();
            temp.add(verts.get(vertical.get(0)));
            vertical.remove(0);
            double tempAvg = temp.get(0).x;
            
            for(int k : vertical){
                if(abs(verts.get(k).x - temp.get(0).x) < closeness){
                    temp.add(verts.get(k));
                    toRemove.add(k);
                    tempAvg += verts.get(k).x;
                }
            }
            
            for(int k : toRemove)
                vertical.remove(Integer.valueOf(k));
            
            tempAvg /= temp.size();
            
            for(int i = 0; i < temp.size(); i++){
                temp.get(i).setX(tempAvg);
            }
        }
    }
    
    public int getClosest(int i, ArrayList<pos> V, Direction dir){
        double indexOfCloseness = 20;
        int best = -1;
        double closestDist = 100000;
        for(int j = 0; j < V.size(); j++){
            if(i == j)
                continue;
            //System.out.println(dir.toString());
            switch(dir){
                case LEFT:
                    if(abs(V.get(i).y - V.get(j).y) <= indexOfCloseness){
                        if((V.get(i).x - V.get(j).x > 0) && closestDist > abs(V.get(i).x - V.get(j).x)){
                            closestDist = abs(V.get(i).x - V.get(j).x);
                            best = j;
                        }
                    }
                    break;
                case RIGHT:
                    if(abs(V.get(i).y - V.get(j).y) <= indexOfCloseness){
                        if((V.get(i).x - V.get(j).x < 0) && closestDist > abs(V.get(i).x - V.get(j).x)){
                            closestDist = abs(V.get(i).x - V.get(j).x);
                            best = j;
                        }
                    }
                    break;
                    
                case UP:
                    if(abs(V.get(i).x - V.get(j).x) <= indexOfCloseness){
                        if((V.get(i).y - V.get(j).y > 0) && closestDist > abs(V.get(i).y - V.get(j).y)){
                            closestDist = abs(V.get(i).y - V.get(j).y);
                            best = j;
                        }
                    }
                    break;
                case DOWN:
                    if(abs(V.get(i).x - V.get(j).x) <= indexOfCloseness){
                        if((V.get(i).y - V.get(j).y < 0) && closestDist > abs(V.get(i).y - V.get(j).y)){
                            closestDist = abs(V.get(i).y - V.get(j).y);
                            best = j;
                        }
                    }
                    break;
            }
        }
        switch(dir){
            case UP:
                U = false;
                break;
            case DOWN:
                D = false;
                break;
            case LEFT:
                L = false;
                break;
            case RIGHT:
                R = false;
                break;
        }
        W = true;
        //System.out.println(best);
        return best;
    }
    
    double abs(double a){
        if(a < 0)
            return a * -1;
        return a;
    }
}