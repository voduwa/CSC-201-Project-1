import java.awt.*;

public class World {
private Rectangle other;
private int ox; //other x
private int ow; //other width
private int oy;//other y
private int oh; //other height

    public boolean intersects (Rectangle other) {
        return intersectsOnX(other.x, other.width) && intersectsOnY(other.y, other.height);
    }

    private boolean intersectsOnX(int ox, int ow) {
        if (this.ox + ow <= ox) return false;
        if (ox + ow <= this.ox) return false;
        return true;
    }
    private boolean intersectsOnY(int oy, int oh) {
        if (this.oy + oh <= oy) return false;
        if (oy + oh <= this.oy) return false;
        return true;
    }
    public boolean contains(Rectangle other) {
        //now this just needs to be added and World class will be complete
    }
}
