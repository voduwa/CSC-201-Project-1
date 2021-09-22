import java.awt.*;
import java.util.Iterator;

public class World {
    public static final int WORlD_X = 0;
    public static final int WORlD_Y = 0;
    public static final int WORlD_W = 1024;
    public static final int WORlD_H = 1024;
    BST<RectNode> world_tree = new BST();
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
        return null;
    }
    // checks to see if rectangle fits in world
    // If true rectangle is inserted into BST
    public void insertCheck (RectNode r){
        if (world_rect.contains(r.getRectangle())){
            world_tree.insert(r);
            System.out.println("Rectangle Accepted: " + r.toString());
        }
        else {
            System.out.println("Rectangle Rejected: " + r.toString());
        }
    }

    public void intersectionPairs(){
        BSTNode<RectNode> temp1;
        BSTNode<RectNode> temp2;
        Iterator first_itr = world_tree.iterator();

        while(first_itr.hasNext()){
            temp1 = world_tree.iterator().next();
            Iterator second_itr = world_tree.iterator();
            while (second_itr.hasNext()){
                temp2 = world_tree.iterator().next();
                if (temp1 == temp2){

                }
                else if (temp1.getValue().getRectangle().intersects(temp2.getValue().getRectangle())){
                    System.out.println(temp1.getValue().toString() + ":" + temp2.getValue().toString());
                } else {}
            }
        }


    }


}
