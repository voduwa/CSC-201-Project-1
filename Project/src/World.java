import java.awt.*;

public class World {
public Rectangle other;

    public Rectangle createIntersection(Rectangle r) {
        Rectangle rect1 = new Rectangle () ;
        Rectangle rect2 = new Rectangle ();
        rect2.setRect(r);
        rect2.createIntersection(rect1);
        return rect2;
    }

    public boolean intersects (Rectangle other, int x, int y, int w, int h) {
        return intersectsOnX(other.x, other.w) && intersectsOnY(other.y, other.h);
    }

    private boolean intersectsOnX(int x, int w) {
        if (x + w <= x) return false;
        if (x + w <= x) return false;
        return true;
    }
    private boolean intersectsOnY(int y, int h) {
        if (y + h <= y) return false;
        if (y + h <= y) return false;
        return true;
    }
    public boolean contains(Rectangle other) {
        //now this just needs to be added and World class will be complete
    }
}
