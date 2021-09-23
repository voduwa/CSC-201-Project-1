public class BSTNode <E> {
    // private variables for the BSTNode
    private E Value;
    private BSTNode<E> left;
    private BSTNode<E> right;

    //constructors
    public BSTNode(){
        Value = null;
        left = null;
        right = null;
    }
    public BSTNode(E val) { left = right = null; Value = val;}

    public BSTNode(E val, BSTNode<E> l , BSTNode<E> r){
        left = l; right = r; Value = val;}


    // getters and setters for BSTNode
    public BSTNode<E> getLeft() {
        return left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public E getValue() {
        return this.Value;
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