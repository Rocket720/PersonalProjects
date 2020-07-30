package gameEngine;

public class PhysicsObject {

    Vector pos, vel, force;
    double mass;
    BoundingGeometry collider;

    public PhysicsObject(Vector pos, Vector vel, double mass) {
        this.pos = pos;
        this.vel = vel;
        this.mass = mass;
        this.force = new Vector(0, 0, 0);
    }

    public void integrate(double dt) {
        this.vel = this.vel.add(this.force.scale(dt / mass));
        this.pos = this.pos.add(this.vel.scale(dt));
    }

    public Vector getPos() {
        return this.pos;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public Vector getVel() {
        return this.vel;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public double getMass() {
        return this.mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public BoundingGeometry getCollider() {
        return this.collider;
    }

    public void setCollider(BoundingGeometry collider) {
        this.collider = collider;
    }

    public void clearNetForce() {
        this.force = new Vector(0, 0, 0);
    }

    public void applyForce(Vector force) {
        this.force = this.force.add(force);
    }

}
