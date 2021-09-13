public class BST {

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
    public void insert (Rectangle rect){
        root = insertHelp(root, rect);
        nodeCount++;
    }

    private BSTNode insertHelp(BSTNode root, Rectangle trct){
        //if the tree is empty
        if (root == null) return new BSTNode(key);
        if (root.value().compareTo(key) > 0)
            root.left(insertHelp(root.left(), key));
        else
            root.right = (insertHelp(root.right(), key));
        return root;
    }





}