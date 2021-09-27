import com.sun.security.jgss.GSSUtil;

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
    // clear the tree
    public void clear(){
        this.root = null;
        this.nodeCount = 0;
    }

    public int nodeCount() {return this.nodeCount;}

    public boolean isEmpty(){return this.nodeCount == 0;}

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
        if (root == null) {
            return new BSTNode<E>(trct);
        }
        if (root.getValue().compareTo(trct) > 0)
            root.setLeft(insertHelp(root.getLeft(), trct));
        else if (root.getValue().compareTo(trct) == 0)
            root.setLeft(insertHelp(root.getLeft(), trct));
        else {
            root.setRight(insertHelp(root.getRight(), trct));
        }
        return root;
    }
    // removeNode method
    public BSTNode<E> removeNode (BSTNode<E> node){
        BSTNode<E> temp = node;
        if (temp != null){
            root = removehelp(node, node.getValue());
            nodeCount--;
        }
        return temp;
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
    // remove helper method
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

    // Method to print out BST in order
    public void print(){
//        TreeIterator itr = new TreeIterator(root);
        TreeIterator itr = new TreeIterator(this.root);
        while (itr.hasNext()){
            System.out.print(itr.next().getValue());
        }
    }


    //inorder traversal
    public void inorder(){
        System.out.println("BST dump: ");
        inorderHelp(root, 0);
        System.out.println("BST size is " + nodeCount);
    }

    public void inorderHelp(BSTNode root, int depth){

        if (root != null){
            BSTNode<RectNode> temp = root;
            temp.depth = depth;

            inorderHelp(temp.getLeft(), depth+1);
            System.out.print("Node has depth <" + temp.depth + ">, ") ;
            System.out.println("Value " + temp.getValue().toString());

        }



    }

    public Iterator<BSTNode<E>> iterator(){

        return new TreeIterator(this.root);
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
            return myStack.pop();
        }

        }



    }
/*
good job! :)
 */




