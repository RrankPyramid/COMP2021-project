package hk.edu.polyu.comp.comp2021.clevis.util;

public class Vertex extends BinaryPair{
    public Vertex(double x, double y){
        super(x,y);
    }
    public Vector vectorTo(Vertex other){
        return new Vector(other.x - this.x, other.y-this.y);
    }
    public double distanceTo(Vertex other){
        return this.vectorTo(other).norm();
    }

    public Vertex add(Vector other) {
        return new Vertex(this.x + other.x, this.y+other.y);
    }

    public Vertex substract(Vector other) {
        return new Vertex(this.x - other.x, this.y - other.y);
    }

    public static void main(String[] args) {
        Vertex a=new Vertex(3,4);
        Vector b = new Vector( 100,100);
        Vertex c = a.add(b);
        System.out.println(c.x+""+c.y);
    }
}
