package gameEngine;


public abstract class BoundingGeometry {

    public abstract IntersectData intersect(AABB other);

    public abstract IntersectData intersect(BoundingSphere other);

}

