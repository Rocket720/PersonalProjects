package gameEngine;

import java.util.ArrayList;

public class PhysicsEngine {

    ArrayList<Force> forces;
    ArrayList<PhysicsObject> objects;

    public PhysicsEngine() {
        this.forces = new ArrayList<Force>();
        this.objects = new ArrayList<PhysicsObject>();
    }

    public void applyForces(double dt) {
        /* Clear the net force from the last tick */
        for (int i = 0; i < this.objects.size(); i++) {
            this.objects.get(i).clearNetForce();
        }

		/* Have each force update its attached bodies */
        for (int i = 0; i < this.forces.size(); i++) {
            this.forces.get(i).applyForce();
        }
    }

    public void integrate(double dt) {
        for (int i = 0; i < this.objects.size(); i++) {
            for (int j = 0; j < this.objects.size(); j++) {
                if (i != j) {
                    BoundingGeometry col1 = this.objects.get(i).getCollider();
                    BoundingGeometry col2 = this.objects.get(j).getCollider();

                    if (col1 != null && col2 != null) {
                        // IntersectData collData = col1.intersect();
                        if (col1 instanceof BoundingSphere && col2 instanceof BoundingSphere) {
                            BoundingSphere d = (BoundingSphere) col1;
                            BoundingSphere e = (BoundingSphere) col2;

                            IntersectData collisionData = d.intersect(e);
                        }
                    }
                }
            }
        }
        this.applyForces(dt);
        for (int i = 0; i < this.objects.size(); i++) {
            this.objects.get(i).integrate(dt);
        }
    }

    /* The returned int is not used here,
     * but is an example scheme to support removing objects */
    public int addBody(PhysicsObject body) {
        this.objects.add(body);
        return this.objects.size() - 1;
    }

    /* The returned int is not used here,
     * but is an example scheme to support removing objects */
    public int addForce(Force force) {
        this.forces.add(force);
        return this.forces.size() - 1;
    }

    public int size() {
        return objects.size();
    }


}
