package gameEngine;

abstract class BoundingSphere extends BoundingGeometry {

    Vector pos;
    double radius;

    public BoundingSphere(Vector pos, double radius) {
        this.pos = pos;
        this.radius = radius;
    }

    public IntersectData intersect(BoundingSphere other) {
        Boolean doesIntersect = false;

        Vector separation = this.pos.sub(other.pos);
        double separationDistance = Math.sqrt(separation.magnitude());
        double totalRadius = this.radius = other.radius;
        double intersectDistance = separationDistance - totalRadius;

        if (separationDistance < totalRadius) {
            doesIntersect = true;
        }

        IntersectData collisionData = new IntersectData(doesIntersect, intersectDistance);
        return collisionData;
    }


}
