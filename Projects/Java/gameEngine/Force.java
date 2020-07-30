package gameEngine;

import java.util.ArrayList;

public abstract class Force {

    ArrayList<PhysicsObject> objects;

    public Force() {
        this.objects = new ArrayList<PhysicsObject>();
    }

    /* The returned int is not used here,
     * but is an example scheme to support removing objects */
    public int attachObject(PhysicsObject object) {
        this.objects.add(object);
        return this.objects.size() - 1;
    }

    public abstract void applyForce();

    public abstract void integrate(double dt);

}
