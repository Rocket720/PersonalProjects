package gameEngine;


public class AABB {

    Vector minExt;
    Vector maxExt;

    public AABB(Vector minExt, Vector maxExt) {
        this.minExt = minExt;
        this.maxExt = maxExt;
    }

    public IntersectData intersect(AABB other) {

        Boolean doesIntersect = false;

        Vector dist1 = other.minExt.sub(this.maxExt);
        Vector dist2 = this.minExt.sub(other.maxExt);

        Vector greatestDist = dist1.max(dist2);
        double intersectDistance = Math.max(greatestDist.getX(), greatestDist.getY());
        intersectDistance = Math.max(intersectDistance, greatestDist.getZ());

        if (intersectDistance < 0) {
            doesIntersect = true;
        }

        IntersectData collisionData = new IntersectData(doesIntersect, intersectDistance);
        return collisionData;
    }

}
