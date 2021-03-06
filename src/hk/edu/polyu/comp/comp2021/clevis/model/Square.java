package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import java.util.ArrayList;

/**
 *
 */
public class Square extends Rectangle {
    /**
     * @param p      The Top-Left point of this square
     * @param direct The vector from the top left corner to the bottom right corner
     * @param z      The order the shapes have been added
     */
    public Square(Vertex p, Vector direct, int z) {
        super(p, direct, z);
    }

    @Override
    public ArrayList<String> getInfo(String name) {
        ArrayList<String> result = new ArrayList<>();
        result.add(name + " is a Square");
        result.add("Top-Left Corner : " + String.format("%.2f", getP().getX()) + " " + String.format("%.2f", getP().getY()));
        result.add("Side length : " + String.format("%.2f", getDirect().getX()));
        return result;
    }

    @Override
    public Square clone() {
        return (Square) super.clone();
    }
}
