public class Rectangle {

    private String RectangleName;
    private int x;
    private int y;
    private int w;
    private int h;

    // Rectangle constructor
    public Rectangle(String name, int x, int y, int w, int h){
        RectangleName = name;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    // Rectangle getters
    public String getRectangleName() {return RectangleName;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getW() {return w;}
    public int getH() {return h;}

    // Rectangle setters
    public void setRectangleName(String rectangleName) {
        RectangleName = rectangleName;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setW(int w) {
        this.w = w;
    }
    public void setH(int h) {
        this.h = h;
    }

    //To string returns name, (x,y), w, h
    @Override
    public String toString(){
        return (RectangleName + ", (" + x + "," + y + "), " + w + ", " + h);
    }



//Comparable for rectangle
