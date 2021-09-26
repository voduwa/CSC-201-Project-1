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

    // method to find pairs of rectangles that intersect
    public void intersectionPairs(){
        BSTNode<RectNode> temp1;
        BSTNode<RectNode> temp2;
        Iterator<BSTNode<RectNode>> first_itr = world_tree.iterator();

        while(first_itr.hasNext()){
            temp1 = first_itr.next();
            Iterator<BSTNode<RectNode>> second_itr = world_tree.iterator();
            while (second_itr.hasNext()){
                temp2 = second_itr.next();
                if (temp1 == temp2){

                }
                else if (temp1.getValue().getRectangle().intersects(temp2.getValue().getRectangle())){
                    System.out.println(temp1.getValue().toString() + ":" + temp2.getValue().toString());
                } else{}
            }
        }


    }

    // remove name method
    public void removeNode (String name){
        Iterator<BSTNode<RectNode>> itr = world_tree.iterator();
        BSTNode<RectNode> temp;
        boolean removed = false;
        while (itr.hasNext()){
            temp = itr.next();
            if (name.equals(temp.getValue().getRectangleName())){
                world_tree.removeNode(temp);
                removed = true;
                break;
            }
        }

        //if there is no rectangle being removed, then print out the rejection info
        if (!removed){
            System.out.println("Rectangle rejected <" + name + ">");
        }
    }

    // remove by rectangle dimensions
    public void removeNode (Rectangle rect){
        Iterator<BSTNode<RectNode>> itr = world_tree.iterator();
        BSTNode<RectNode> temp;
        boolean removed = false;
        while (itr.hasNext()){
            temp = itr.next();
            if (rect == temp.getValue().getRectangle()){
                world_tree.removeNode(temp);
                removed = true;

                //when the first rectangle in the tree is found, we terminate the while loop
                // so the second one won't be removed
                break;
            }
        }

        //after the while loop, if there is no rectangle being removed, then print out some information
        if (!removed) {
            System.out.println("Rectangle rejected (" + rect + ")");
        }
    }


    public void search (String name){
        Iterator<BSTNode<RectNode>> itr = world_tree.iterator();
        BSTNode<RectNode> temp;
        boolean found = false;
        while (itr.hasNext()){
            temp = itr.next();
            if (name == temp.getValue().getRectangleName()){
                System.out.println("Rectangle found: " + temp.getValue().toString());
                found = true;
            }
        }
        if (found == false){
            System.out.println("Rectangle not found: " + name);
        }
    }

    public void regionSearch (Rectangle rect){
        Iterator<BSTNode<RectNode>> itr = world_tree.iterator();
        BSTNode<RectNode> temp;
        System.out.println("Rectangles intersecting region" + rect);
        while (itr.hasNext()){
            temp = itr.next();
            if (temp.getValue().getRectangle().height < 0 || temp.getValue().getRectangle().width < 0){
                // rectangle rejected
            } else if (rect.intersects(temp.getValue().getRectangle())){
                System.out.println(temp.getValue().getRectangleName());
            } else {
                // rectangle rejected
            }
        }
    }


    public void dump() {
        Iterator<BSTNode<RectNode>> itr = world_tree.iterator();
        BSTNode<RectNode> temp;

        while (itr.hasNext()) {
            temp = itr.next();
            System.out.println();
        }
    }

}
