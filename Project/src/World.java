import java.awt.*;

public class World {
    public static final int WORlD_X = 0;
    public static final int WORlD_Y = 0;
    public static final int WORlD_W = 1024;
    public static final int WORlD_H = 1024;
    Rectangle world_rect = new Rectangle(WORlD_X,WORlD_Y,WORlD_W, WORlD_H);

    /*
    if(world_rect.contains(new_rect))
    else{it cannot}
    */

    public Rectangle createIntersection(Rectangle r) {
        Rectangle rect1 = new Rectangle (1,3,4,5) ;
        Rectangle rect2 = new Rectangle (2,4,6,7);
        //if ((rect1,rect2)){}
        //else{}

    }
}
