package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 */
public abstract class Shape implements Cloneable{

    private int groupCounter = 0;
    private int zOrder;
    private String shapeName;
    private boolean isDelete = false;

    /**
     * @param g Draw the Graphic
     */
    public abstract void draw(Graphics g);

    /**
     * @param name name of Shape
     * @return the imformation of the shape
     */
    public abstract ArrayList<String> getInfo(String name);

    /**
     * @param p One point to check
     * @return Whether this shape contains this point
     */
    public abstract boolean containPoint(Vertex p);

    /**
     * @param dx Distance to move laterally
     * @param dy Distance travelled vertically
     */
    public abstract void move(double dx, double dy);

    /**
     * @return Return the Top-Left point of the Shape
     */
    public abstract Vertex getTopLeft();

    /**
     * @return Return the Bottom-Right point of the Shape
     */
    public abstract Vertex getBottomRight();

    /**
     * @param other Another shape
     *
     * use the reflection to get the method of the subclass
     *
     * @return Whether these two shapes are intersected
     */
    public boolean intersect(Shape other){
        Class<?> c = this.getClass();
        try {
            Method m = c.getMethod("intersect", other.getClass());
            boolean result = (boolean) m.invoke(this,other);
            return result;
        }catch (Exception error){System.out.println("Oops...incorrect command, please try again");}
        return false;
    }


    /**
     * @return Returns how many groups the shape is contained by
     */
    public int getGroupCounter() {
        return groupCounter;
    }

    /**
     * @param groupCounter how many groups the shape is contained by
     */
    public void setGroupCounter(int groupCounter) {
        this.groupCounter = groupCounter;
    }

    /**
     * @return Returns the order the shapes have been added
     */
    public int getzOrder() {
        return zOrder;
    }

//    public boolean intersectCircle(Circle){}

    /**
     * @param zOrder The order the shapes have been added
     */
    public void setzOrder(int zOrder) {
        this.zOrder = zOrder;
    }

    @Override
    public Shape clone() {
        try {
            Shape clone = (Shape) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * @return shape name
     */
    public String getShapeName() {
        return shapeName;
    }

    /**
     * @param shapeName shape name
     */
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    /**
     * @return delete status
     */
    public boolean isDelete() {
        return isDelete;
    }

    /**
     * set delete status true
     */
    public void setDelete() {
        isDelete = true;
    }

}
