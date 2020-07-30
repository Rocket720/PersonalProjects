package gameEngine;


public class IntersectData {

    double depth;
    Boolean doesIntersect;
    Vector normal;

    public IntersectData(Boolean doesIntersect, double depth) {
        this.depth = depth;
        this.doesIntersect = doesIntersect;
        this.normal = new Vector(0, 0, 0);
    }

    public Boolean doesIntersect() {
        return this.doesIntersect;
    }

    public double getDepth() {
        return this.depth;
    }

    public Vector getNormal() {
        return this.normal;
    }

    public IntersectData intersect(BoundingGeometry obj) {
        //if (this.)
        return new IntersectData(doesIntersect, 1);
    }
}

