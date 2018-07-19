package gameEngine;

public class Gravity extends Force {

    Vector g;

    public Gravity() {
        super();

        g = new Vector(0, 0, -9.8);
    }

    public void integrate(double dt) {

    }

    public void applyForce() {
        for (int i = 0; i < this.objects.size(); i++) {
            PhysicsObject object = this.objects.get(i);
            object.applyForce(this.g.scale(object.getMass()));
        }
    }

    public void attatchObject(PhysicsObject body) {
        body.setPos(body.getPos().add(g));
    }

}
