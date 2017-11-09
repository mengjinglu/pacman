package packman;

import static java.lang.Math.abs;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

//A field is a directed graph which defines the path grade guy may move along.
//It is implemented using an Adjacency List
class vertex {

    double x;
    double y;

    public vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        //add an exception handler for when type isn't a vertex.
        if (o instanceof vertex) {
            return abs(((vertex) o).x - x) < 0.01 && abs(((vertex) o).y - y) < 0.01;
        }
        return false;
    }

    /*
     This function checks if the passed coordiantes(x,y) is equal to the vertex
     that called the function and return true if so. Basically compares 2
     vertices to check if they are equal.
     */
//    public boolean isEqual(vertex v) {
//        System.out.println("this.x: " + this.x + " v.x(): " + v.x);
//        if (this.x == v.x && this.y == v.y) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void set(vertex v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (int) x + (int) y;
    }

    @Override
    public String toString() {
        return "" + x + " " + y;
    }
}
/*
Class that defines all edibles related information, any edible will be created
using this class and then added to a list of edibles that will be displayed on the field.
*/
class Edible {

    vertex location; //vertex that stores location of the edible on the field
    double point;   //gpa points earned when eating this edible
    boolean visible; //boolean to determine if edible was eaten and should be removed from the field

    public Edible(double x, double y, double p) {
        this.location = new vertex(x, y);
        this.point = p;
        this.visible = true;
    }
    public boolean isVisible(){
        return visible;
    }

    void setInvisible() {
        this.visible = false;
    }
}

public class Field {

    private HashMap<vertex, List<vertex>> field;
    private double closeness; //defines when the program should allow you to move in your new direction given a click. Should be small enough to be unoticeable but large enough to always work i.e. the dx or dy may cause a problem if it can jump over the turn.
    private Vector<Edible> edibles; //declaring data structure to hold edible information

    public Field() {
        //this.field = field;
        closeness = 10;

        field = new HashMap<>();

        vertex v0 = new vertex(22.571428571428573, 559.0);
        vertex v1 = new vertex(291.2857142857143, 559.0);
        vertex v2 = new vertex(363.85714285714283, 559.0);
        vertex v3 = new vertex(632.1428571428571, 559.0);
        vertex v4 = new vertex(632.1428571428571, 501.0);
        vertex v5 = new vertex(581.0, 501.0);
        vertex v6 = new vertex(512.2, 501.0);
        vertex v7 = new vertex(437.375, 501.0);
        vertex v8 = new vertex(363.85714285714283, 501.0);
        vertex v9 = new vertex(291.2857142857143, 501.0);
        vertex v10 = new vertex(218.125, 501.0);
        vertex v11 = new vertex(141.0, 501.0);
        vertex v12 = new vertex(70.5, 501.0);
        vertex v13 = new vertex(22.571428571428573, 501.0);
        vertex v14 = new vertex(22.571428571428573, 443.0);
        vertex v15 = new vertex(70.5, 443.0);
        vertex v16 = new vertex(141.0, 443.0);
        vertex v17 = new vertex(218.125, 443.0);
        vertex v18 = new vertex(291.2857142857143, 443.0);
        vertex v19 = new vertex(358.0, 443.0);
        vertex v20 = new vertex(437.375, 443.0);
        vertex v21 = new vertex(512.2, 443.0);
        vertex v22 = new vertex(581.0, 443.0);
        vertex v23 = new vertex(632.1428571428571, 443.0);
        vertex v24 = new vertex(632.1428571428571, 386.0);
        vertex v25 = new vertex(512.2, 386.0);
        vertex v26 = new vertex(437.375, 386.0);
        vertex v27 = new vertex(363.85714285714283, 386.0);
        vertex v28 = new vertex(291.2857142857143, 386.0);
        vertex v29 = new vertex(218.125, 386.0);
        vertex v30 = new vertex(144.75, 386.0);
        vertex v31 = new vertex(22.571428571428573, 386.0);
        vertex v32 = new vertex(218.125, 329.0);
        vertex v33 = new vertex(437.375, 329.0);
        vertex v34 = new vertex(141.0, 272.0);
        vertex v35 = new vertex(218.125, 272.0);
        vertex v36 = new vertex(328.0, 272.0);
        vertex v37 = new vertex(437.375, 272.0);
        vertex v38 = new vertex(509.5, 272.0);
        vertex v39 = new vertex(218.125, 211.0);
        vertex v40 = new vertex(288.0, 211.0);
        vertex v41 = new vertex(328.0, 211.0);
        vertex v42 = new vertex(363.85714285714283, 211.0);
        vertex v43 = new vertex(437.375, 211.0);
        vertex v44 = new vertex(22.571428571428573, 151.0);
        vertex v45 = new vertex(144.75, 151.0);
        vertex v46 = new vertex(218.125, 151.0);
        vertex v47 = new vertex(291.2857142857143, 151.0);
        vertex v48 = new vertex(363.85714285714283, 151.0);
        vertex v49 = new vertex(437.375, 151.0);
        vertex v50 = new vertex(512.2, 151.0);
        vertex v51 = new vertex(632.1428571428571, 151.0);
        vertex v52 = new vertex(632.1428571428571, 96.0);
        vertex v53 = new vertex(512.2, 96.0);
        vertex v54 = new vertex(437.375, 96.0);
        vertex v55 = new vertex(363.85714285714283, 96.0);
        vertex v56 = new vertex(218.125, 96.0);
        vertex v57 = new vertex(144.75, 96.0);
        vertex v58 = new vertex(22.571428571428573, 96.0);
        vertex v59 = new vertex(22.571428571428573, 19.0);
        vertex v60 = new vertex(144.75, 19.0);
        vertex v61 = new vertex(291.2857142857143, 19.0);
        vertex v62 = new vertex(363.85714285714283, 19.0);
        vertex v63 = new vertex(509.5, 19.0);
        vertex v64 = new vertex(632.1428571428571, 19.0);
        vertex v65 = new vertex(291.2857142857143, 96.0);
        field.put(v0, Arrays.asList(v13, v1));
        field.put(v1, Arrays.asList(v0, v9, v2));
        field.put(v2, Arrays.asList(v1, v8, v3));
        field.put(v3, Arrays.asList(v2, v4));
        field.put(v4, Arrays.asList(v3, v5));
        field.put(v5, Arrays.asList(v4, v22, v6));
        field.put(v6, Arrays.asList(v21, v5));
        field.put(v7, Arrays.asList(v20, v8));
        field.put(v8, Arrays.asList(v7, v2));
        field.put(v9, Arrays.asList(v1, v10));
        field.put(v10, Arrays.asList(v9, v17));
        field.put(v11, Arrays.asList(v16, v12));
        field.put(v12, Arrays.asList(v11, v15, v13));
        field.put(v13, Arrays.asList(v12, v0));
        field.put(v14, Arrays.asList(v15, v31));
        field.put(v15, Arrays.asList(v12, v14));
        field.put(v16, Arrays.asList(v11, v17, v30));
        field.put(v17, Arrays.asList(v10, v16, v18));
        field.put(v18, Arrays.asList(v17, v28, v19));
        field.put(v19, Arrays.asList(v18, v27, v20));
        field.put(v20, Arrays.asList(v19, v7, v21));
        field.put(v21, Arrays.asList(v20, v6, v25));
        field.put(v22, Arrays.asList(v5, v23));
        field.put(v23, Arrays.asList(v22, v24));
        field.put(v24, Arrays.asList(v23, v25));
        field.put(v25, Arrays.asList(v24, v21, v26, v38));
        field.put(v26, Arrays.asList(v25, v33, v27));
        field.put(v27, Arrays.asList(v19, v26));
        field.put(v28, Arrays.asList(v18, v29));
        field.put(v29, Arrays.asList(v28, v32, v30));
        field.put(v30, Arrays.asList(v29, v34, v31, v16));
        field.put(v31, Arrays.asList(v14, v30));
        field.put(v32, Arrays.asList(v29, v33, v35));
        field.put(v33, Arrays.asList(v32, v26, v37));
        field.put(v34, Arrays.asList(v45, v35, v30));
        field.put(v35, Arrays.asList(v34, v39, v32));
        field.put(v36, Arrays.asList(v41));
        field.put(v37, Arrays.asList(v33, v38, v43));
        field.put(v38, Arrays.asList(v37, v50, v25));
        field.put(v39, Arrays.asList(v35, v40));
        field.put(v40, Arrays.asList(v39, v47, v41));
        field.put(v41, Arrays.asList(v40, v42));
        field.put(v42, Arrays.asList(v48, v41, v43));
        field.put(v43, Arrays.asList(v42, v37));
        field.put(v44, Arrays.asList(v45, v58));
        field.put(v45, Arrays.asList(v44, v57, v34));
        field.put(v46, Arrays.asList(v56, v47));
        field.put(v47, Arrays.asList(v46, v40));
        field.put(v48, Arrays.asList(v42, v49));
        field.put(v49, Arrays.asList(v48, v54));
        field.put(v50, Arrays.asList(v38, v51, v53));
        field.put(v51, Arrays.asList(v50, v52));
        field.put(v52, Arrays.asList(v51, v53, v64));
        field.put(v53, Arrays.asList(v52, v63, v54, v50));
        field.put(v54, Arrays.asList(v49, v53, v55));
        field.put(v55, Arrays.asList(v65, v62, v54));
        field.put(v56, Arrays.asList(v65, v46, v57));
        field.put(v57, Arrays.asList(v56, v60, v58, v45));
        field.put(v58, Arrays.asList(v57, v44, v59));
        field.put(v59, Arrays.asList(v58, v60));
        field.put(v60, Arrays.asList(v59, v57, v61));
        field.put(v61, Arrays.asList(v60, v65));
        field.put(v62, Arrays.asList(v55, v63));
        field.put(v63, Arrays.asList(v62, v53, v64));
        field.put(v64, Arrays.asList(v63, v52));
        field.put(v65, Arrays.asList(v55, v61, v56));

        //creating all edibles to be displayed on the field
        //for now just initialized all edibles as pelletes(0.02 points) and A's(freshman=0.2 points) 
        Edible e0 = new Edible(22.571428571428573, 559.0, 0.2);
        Edible e2 = new Edible(363.85714285714283, 559.0, 0.02);
        Edible e4 = new Edible(632.1428571428571, 501.0, 0.02);
        Edible e6 = new Edible(512.2, 501.0, 0.02);
        Edible e8 = new Edible(363.85714285714283, 501.0, 0.02);
        Edible e10 = new Edible(218.125, 501.0, 0.2);
        Edible e12 = new Edible(70.5, 501.0, 0.02);
        Edible e14 = new Edible(22.571428571428573, 443.0, 0.02);
        Edible e16 = new Edible(141.0, 443.0, 0.02);
        Edible e18 = new Edible(291.2857142857143, 443.0, 0.02);
        Edible e20 = new Edible(437.375, 443.0, 0.2);
        Edible e22 = new Edible(581.0, 443.0, 0.02);
        Edible e24 = new Edible(632.1428571428571, 386.0, 0.02);
        Edible e26 = new Edible(437.375, 386.0, 0.02);
        Edible e28 = new Edible(291.2857142857143, 386.0, 0.02);
        Edible e30 = new Edible(144.75, 386.0, 0.2);
        Edible e32 = new Edible(218.125, 329.0, 0.02);
        Edible e34 = new Edible(141.0, 272.0, 0.02);
        Edible e36 = new Edible(328.0, 272.0, 0.02);
        Edible e38 = new Edible(509.5, 272.0, 0.02);
        Edible e40 = new Edible(288.0, 211.0, 0.2);
        Edible e42 = new Edible(363.85714285714283, 211.0, 0.02);
        Edible e44 = new Edible(22.571428571428573, 151.0, 0.02);
        Edible e46 = new Edible(218.125, 151.0, 0.02);
        Edible e48 = new Edible(363.85714285714283, 151.0, 0.02);
        Edible e50 = new Edible(512.2, 151.0, 0.2);
        Edible e52 = new Edible(632.1428571428571, 96.0, 0.02);
        Edible e54 = new Edible(437.375, 96.0, 0.02);
        Edible e56 = new Edible(218.125, 96.0, 0.02);
        Edible e58 = new Edible(22.571428571428573, 96.0, 0.02);
        Edible e60 = new Edible(144.75, 19.0, 0.2);
        Edible e62 = new Edible(363.85714285714283, 19.0, 0.02);
        Edible e64 = new Edible(632.1428571428571, 19.0, 0.02);

        edibles = new Vector<>(); //initialize data structure to hold edibles
        //add all edibles to the list
        edibles.add(e0);
        edibles.add(e2);
        edibles.add(e4);
        edibles.add(e6);
        edibles.add(e8);
        edibles.add(e10);
        edibles.add(e12);
        edibles.add(e14);
        edibles.add(e16);
        edibles.add(e18);
        edibles.add(e20);
        edibles.add(e22);
        edibles.add(e24);
        edibles.add(e26);
        edibles.add(e28);
        edibles.add(e30);
        edibles.add(e32);
        edibles.add(e34);
        edibles.add(e36);
        edibles.add(e38);
        edibles.add(e40);
        edibles.add(e42);
        edibles.add(e44);
        edibles.add(e46);
        edibles.add(e48);
        edibles.add(e50);
        edibles.add(e52);
        edibles.add(e54);
        edibles.add(e56);
        edibles.add(e58);
        edibles.add(e60);
        edibles.add(e62);
        edibles.add(e64);
    }

    /*
    This function checks if the passed coordiantes(x,y) match an edible vertex
    and return true if so.
     */
    boolean isEdible(double x, double y) {
        vertex v = new vertex(x, y);
        for (int i = 0; i < edibles.size(); i++) {
            if (edibles.elementAt(i).location.equals(v)) {
                System.out.println("isEdible: true"); //for testing purposes
                return true;
            }
        }
        System.out.println("isEdible: false");
        return false;
    }

    /*
    This function finds the edible vertex corresponding to the passed 
    coordiantes(x,y) and checks if that edible is visible, is so returns true. 
     */
    boolean isVisible(double x, double y) {
        vertex v = new vertex(x, y);
        for (int i = 0; i < edibles.size(); i++) {
            if (edibles.elementAt(i).visible == true) {
                return true;
            }
        }
        return false;
    }

    /*
    This function finds the edible vertex corresponding to the passed 
    coordiantes(x,y) and returns the point value for that specific edible.
    But right before it returns it actually
    makes it's visible value to false using setInvisible(). 
     */
    double getEdiblePoints(double x, double y) {
        vertex v = new vertex(x, y);
        double p = 0;
        for (int i = 0; i < edibles.size(); i++) {
            if (edibles.elementAt(i).location.equals(v)) {
                p = edibles.elementAt(i).point;
                edibles.elementAt(i).setInvisible();  //Makes edible object invisible
            }
        }
        return p;
    }
   public List<Edible> getVisibleEdibles(){
        List<Edible> temp = new ArrayList<>();
        for(Edible e : edibles){
            if(e.isVisible()){
                temp.add(e);
            }
        }
        return temp;
    }
    boolean canMove(double x, double y, Direction dir, vertex v1, vertex v2) {
        List<vertex> Edges;

        if (abs(x - v1.x) < closeness && abs(y - v1.y) < closeness) {
            Edges = field.get(v1);
            exit:
            for (vertex v : Edges) {
                switch (dir) {
                    case LEFT:
                        if (x - v.x > 0) {
                            v2.set(v);
                            break exit;
                        }
                        break;
                    case RIGHT:
                        if (x - v.x < 0) {
                            v2.set(v);
                            break exit;
                        }
                        break;
                    case UP:
                        if (y - v.y > 0) {
                            v2.set(v);
                            break exit;
                        }
                        break;
                    case DOWN:
                        if (y - v.y < 0) {
                            v2.set(v);
                            break exit;
                        }
                        break;
                }
            }
        } else if (abs(x - v2.x) < closeness && abs(y - v2.y) < closeness) {
            Edges = field.get(v2);
            exit2:
            for (vertex v : Edges) {
                switch (dir) {
                    case LEFT:
                        if (x - v.x > 0) {
                            v1.set(v);
                            break exit2;
                        }
                        break;
                    case RIGHT:
                        if (x - v.x < 0) {
                            v1.set(v);
                            break exit2;
                        }
                        break;
                    case UP:
                        if (y - v.y > 0) {
                            v1.set(v);
                            break exit2;
                        }
                        break;
                    case DOWN:
                        if (y - v.y < 0) {
                            v1.set(v);
                            break exit2;
                        }
                        break;
                }
            }
        }

        switch (dir) {
            case LEFT:
                if (x - min(v1.x, v2.x) > 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (max(v1.x, v2.x) - x > 0) {
                    return true;
                }
                break;
            case UP:
                if (y - min(v1.y, v2.y) > 0) {
                    return true;
                }
                break;
            case DOWN:
                if (max(v1.y, v2.y) - y > 0) {
                    return true;
                }
                break;
        }

        return false;
    }

    public double min(double x, double y) {
        if (x < y) {
            return x;
        }
        return y;
    }

    public double max(double x, double y) {
        if (x > y) {
            return x;
        }
        return y;
    }
    
    public HashMap<vertex, List<vertex>> getFieldVertices() {
        return this.field;
    }

}