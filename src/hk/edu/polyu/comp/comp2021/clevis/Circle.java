package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;


import java.awt.Graphics;
import java.util.ArrayList;

public class Circle extends Shape {
    private Vertex center;
    private double radius;

    public Circle(Vertex center, double radius,int z) {
        this.center = center;
        this.radius = radius;
        this.zOrder = z;
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval((int)(center.x-radius), (int)(center.y-radius), (int)radius*2, (int)radius*2);
    }

    @Override
    public boolean containPoint(Vertex p){
        return GraphConstant.EPS <= Math.abs(center.distanceTo(p)-radius);
    }

    @Override
    public void move(double dx, double dy) {
        center=center.add(new Vector(dx,dy));
    }

    @Override
    public Vertex getTopLeft(){
        return new Vertex(center.x-radius, center.y-radius);
    }


    @Override
    public Vertex getBottomRight(){
        return new Vertex(center.x+radius, center.y+radius);
    }

    @Override
    public String[] getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a circle");
        result.add("Center : "+String.format("%.2f", center.x)+" "+String.format("%.2f", center.y));
        result.add("Radius : "+String.format("%.2f", radius));
        return (String[])result.toArray();
    }
}
