package gameEngine;

public class EngineTest {

    public static void main(String[] args) {

        PhysicsEngine eng = new PhysicsEngine();
        PhysicsObject body = new PhysicsObject(new Vector(0, 0, 10), new Vector(0, 0, 0), 1);
        Gravity g = new Gravity();
        eng.addBody(body);
        eng.addForce(g);
        g.attatchObject(body);

        eng.integrate(1);
        System.out.println(body.getPos().x);
        System.out.println(body.getPos().y);


    }

}
