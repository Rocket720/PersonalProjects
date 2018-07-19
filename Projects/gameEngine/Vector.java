package gameEngine;

public class Vector {

    double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector other) {

        Vector temp = new Vector(0, 0, 0);

        temp.x = this.x + other.x;
        temp.y = this.y + other.y;
        temp.z = this.z + other.z;

        return temp;

    }

    public Vector sub(Vector other) {

        Vector temp = new Vector(0, 0, 0);

        temp.x = this.x - other.x;
        temp.y = this.y - other.y;
        temp.z = this.z - other.z;

        return temp;

    }

    public Vector scale(double scalar) {

        Vector temp = new Vector(0, 0, 0);

        temp.x = this.x * scalar;
        temp.y = this.y * scalar;
        temp.z = this.z * scalar;

        return temp;

    }

    public double dot(Vector other) {

        double product = 0;

        product += this.x * other.x;
        product += this.y * other.y;
        product += this.z * other.z;

        return product;

    }

    public double magnitude() {

        double squared = this.dot(this);
        double root = Math.sqrt(squared);
        return root;

    }

    public Vector normal() {

        double mag = this.magnitude();
        Vector temp = this.scale(1 / mag);
        return temp;

    }

    public Vector max(Vector other) {

        Vector temp = new Vector(0, 0, 0);

        temp.x = Math.max(this.x, other.x);
        temp.y = Math.max(this.y, other.y);
        temp.z = Math.max(this.z, other.z);

        return temp;

    }

    public Boolean cmp(Vector other) {

        Boolean result = true;

        result = result && (this.x == other.x);
        result = result && (this.y == other.y);
        result = result && (this.z == other.z);

        return result;

    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

}
