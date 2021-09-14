public class BSTNode <E> {
    E Value;
    BSTNode<E> left;
    BSTNode<E> right;

    //constructor
    public BSTNode(){
        Value = null;
        left = null;
        right = null;
    }
    public BSTNode(E val) { left = right = null; Value = val;}
    public BSTNode(E val, BSTNode<E> l , BSTNode<E> r){
        left = l; right = r; Value = val;}

    public BSTNode<E> getLeft() {
        return left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public E getValue() {
        return Value;
    }

    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    public void setRight(BSTNode<E> right) {
        this.right = right;
    }

    public void setValue(E value) {
        Value = value;
    }

    // Tells if element is a leaf
    public boolean isLeaf() {return (left == null) && (right == null);}
}