import java.awt.*;
import java.util.Comparator;

public class RectNode implements Comparable<RectNode>{
    // private variables for RectNode
    private String RectangleName;
    private Rectangle rectangle;

    // Rectangle constructor
    // check rectangle


    public RectNode(){
        this.RectangleName = null;
        this.rectangle = null;
    }

    public RectNode (String name, Rectangle rect){
        RectangleName = name;
        rectangle = rect;
    }

    // Rectangle getters
    public String getRectangleName() {
        return RectangleName;
    }
    public Rectangle getRectangle() {return rectangle;}


    // Rectangle setters
    public void setRectangleName(String rectangleName) {
        RectangleName = rectangleName;
    }
    public void setRectangle(Rectangle rectangle) {this.rectangle = rectangle;}


    //To string returns name, (x,y), w, h
    @Override
    public String toString() {
        return "(<" + RectangleName + ">, <" + rectangle.x + ">, <" + rectangle.y + ">, <" + rectangle.width + ">, <" + rectangle.height + ">) ";
    }

    //Comparable for rectangle
    public int compareTo(RectNode other) {
        return this.RectangleName.compareTo(other.RectangleName);

        }

}



