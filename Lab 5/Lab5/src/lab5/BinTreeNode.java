package lab5;

public class BinTreeNode <T extends Comparable> {
    T data;
    private BinTreeNode left, right;

    public BinTreeNode() {
        this(null, null, null);
    }
    
    public BinTreeNode(T data) {
        this(data, null, null);
    }

    
    public BinTreeNode(T data, BinTreeNode left, BinTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

    public BinTreeNode getRight() {
        return right;
    }

    public void setRight(BinTreeNode right) {
        this.right = right;
    }
    
    public boolean isLeaf(){
        return (left == null && right == null);
    }
    public boolean hasLeft(){
        return (left != null);
    }
    public boolean hasRight(){
        return (right != null);
    }
    
    
}
