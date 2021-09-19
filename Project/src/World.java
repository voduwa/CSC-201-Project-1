import java.awt.*;

public class World {

    public Rectangle createIntersection(Rectangle r) {
        Rectangle rect1 = new Rectangle () ;
        Rectangle rect2 = new Rectangle ();
        rect2.setRect(r);
        rect2.createIntersection(rect1);
        return rect2;
    }

    public boolean intersects (Rectangle r, int x, int y, int w, int h) {
        return intersectsOnX(r.x, r.w) && intersectsOnY(r.y, r.h);
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
    public boolean contains(Rectangle r) {
        //now this just needs to be added and World class will be complete
    }
}
