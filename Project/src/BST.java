import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BST <E extends Comparable<E>> implements Iterable<BSTNode<E>> {
//create iterator class at end
    //add method called iterator
    //root node
    BSTNode root;
    int nodeCount;

    //BST Constructor
    public BST() {
        root = null;
        nodeCount = 0;
    }

    //Insert method for rectangle
    //Assuming that the rectangle has already been checked for correct parameters
    public void insert (RectNode rect){
        root = insertHelp(root, rect);
        nodeCount++;
    }

    private BSTNode<E> insertHelp(BSTNode<E> root, RectNode trct){
        //if the tree is empty
        if (root == null) return new BSTNode<E>(trct);
        if (root.value().compareTo(trct) > 0)
            root.left(insertHelp(root.left(), trct));
        else
            root.right = (insertHelp(root.right(), trct));
        return root;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


/*
good job! :)
 */


}