package Snake;

public class Coords {
    int x;
    int y;

    Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[ " + this.getX() + ", " + this.getY() + " ]";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
