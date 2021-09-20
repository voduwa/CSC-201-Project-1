import java.util.ArrayList;
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
    //if root is null insert
    //if not null than insertHelp calls itself comparing to next node
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
    //remove method for BST
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
    //
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
    // method used to find the max value
    private BSTNode getMax (BSTNode<E> rt){
        if (rt.getRight() == null)
            return rt;
        else return getMax(rt.getRight());
    }
    // method take the max that was found by getMax and deletes it
    private BSTNode deleteMax(BSTNode<E> rt){
        if (rt.getRight() == null)
            return rt.getRight();
        else {
            rt.setRight(deleteMax(rt.getRight()));
            return rt;
        }
    }

    public void print(){
        TreeIterator itr = new TreeIterator(root);
        if (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public Iterator<BSTNode<E>> iterator(){

        return new BST.TreeIterator(this.root);
    }
    // Tree iterator class

    private class TreeIterator implements Iterator<BSTNode<E>>{
         // creating stack to initialize iterator
         Stack<BSTNode<E>> myStack = new Stack<>();

        //Tree iterator goes all the way left
        private TreeIterator (BSTNode<E> rt){
            this.generateStack(myStack, rt);

//             myStack = new Stack<BSTNode<E>>();
//            while (rt != null){
//                myStack.push(rt);
//                rt = rt.getLeft();
//            }
        }

        public void generateStack(Stack myStack, BSTNode<E> rootnote){
            if (rootnote!= null){
                generateStack(myStack, rootnote.getRight());
                myStack.push(rootnote);
                generateStack(myStack, rootnote.getLeft());
            }
        }
        // checks to see if stack is empty or not
        public boolean hasNext(){
            return !myStack.empty();
        }
        // next method for iterator
        public BSTNode<E> next() {
            BSTNode<E> node = myStack.pop();
            return node;
        }

        }
    }
/*
good job! :)
 */


}
// need iterator class
