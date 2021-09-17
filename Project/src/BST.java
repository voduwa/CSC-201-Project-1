import java.util.Iterator;
import java.util.Stack;

public class BST <E extends Comparable<E>> implements Iterable<BSTNode<E>> {
//create iterator class at end
    //add method called iterator
    //root node
    BSTNode<E> root;
    int nodeCount;

    //BST Constructor
    public BST() {
        root = null;
        nodeCount = 0;
    }

    //Insert method for rectangle
    //Assuming that the rectangle has already been checked for correct parameters
    public void insert (E rect){
        root = insertHelp(root, rect);
        nodeCount++;
    }

    private BSTNode<E> insertHelp(BSTNode<E> root, E trct){
        //if the tree is empty
        if (root == null) return new BSTNode<E>(trct);
        if (root.getValue().compareTo(trct) > 0)
            return insertHelp(root.getLeft(), trct);
        else if (root.getValue().compareTo(trct) == 0)
            return root;
        else
            return insertHelp(root.getRight(), trct);
    }

    public E remove (E trct){
        E temp = findhelp(root, trct);
        if (temp != null) {
            root = removehelp(root, trct);
            nodeCount--;
        }
        return temp;
    }

    private E findhelp (BSTNode<E> rt, E trct){
        if (rt == null) return null;
        if (rt.getValue().compareTo(trct) > 0)
            return findhelp (root.getLeft(), trct);
        else if (rt.getValue().compareTo(trct) == 0)
            return root.getValue();
        else return findhelp(rt.getRight(), trct);

    }

    private BSTNode removehelp (BSTNode<E> rt, E trct){
        if (rt == null) return null;
        if (rt.getValue().compareTo(trct) > 0)
            rt.setLeft(removehelp(rt.getLeft(), trct));
        else if (rt.getValue().compareTo(trct) < 0)
            rt.setRight(removehelp(rt.getRight(), trct));
        else {
            if (rt.getLeft() == null)
                return rt.getRight();
            else if (rt.getRight() == null)
                return rt.getLeft();
            else{
                BSTNode<E> temp = getMax(rt.getLeft());
                rt.setValue((temp.getValue()));
                rt.setLeft(deleteMax(rt.getLeft()));
            }
        }
        return rt;
    }

    private BSTNode getMax (BSTNode<E> rt){
        if (rt.getRight() == null)
            return rt;
        else return getMax(rt.getRight());
    }

    private BSTNode deleteMax(BSTNode<E> rt){
        if (rt.getRight() == null)
            return rt.getRight();
        else {
            rt.setRight(deleteMax(rt.getRight()));
            return rt;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private class TreeIterator implements Iterator<BSTNode<E>>{
        Stack<BSTNode<E>> myStack;


        TreeIterator (BSTNode<E> rt){
            myStack = new Stack<BSTNode<E>>();
            while (rt != null){
                myStack.push(rt);
                rt = rt.getLeft();
            }
        }

        public boolean hasNext(){
            return !myStack.empty();
        }

        public E next() {
            BSTNode<E> node = myStack.pop();
            E result = node.getValue();
            if (node.getRight() != null){
                node = node.getRight();
                while (node != null) {
                    myStack.push(node);
                    node = node.getLeft();
                }
            }
            return result;
        }
    }
/*
good job! :)
 */


}
// need iterator class
