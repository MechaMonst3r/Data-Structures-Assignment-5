public class BinTree<T extends Comparable> {

    private int size;
    private BinTreeNode root;

    public BinTree(BinTreeNode root) {
        this.root = root;
        size = 0;
    }

    public BinTree() {
        this(null);
    }

    public boolean isEmpty(){
        return (size == 0);

    }

    public int getSize(){
        return size;
    }

    public void inOrder(){
        inorder(root);
    }

    private void inorder(BinTreeNode r){
        if(r == null)
            return;
        inorder(r.left);
        System.out.println(r.data);
        inorder(r.right);
    }


    public boolean search(T data){
        return search(data, root);
    }

    public void insert(T data){
        root = insert(data, root);
        size++;
    }

    private BinTreeNode<T> insert(T data, BinTreeNode r){
        if(r == null){
            r = new BinTreeNode(data);
        }else{
            if(r.left == null){
                r.left = insert(data, r.left);
            }else{
                r.right = insert(data, r.right);
            }

        }
        return r;
    }

    private boolean search(T data, BinTreeNode r){

        if(isEmpty())
            return false;
        if(r.data.equals(data))
            return true;
        if(r.hasLeft()) {
            //if(search(data, r.left))
            //return true;
            boolean res = search(data, r.left);
            if(res == true)
                return true;
        }

        if(r.hasRight())
            if(search(data, r.right))
                return true;


        return false;
    }

    private class BinTreeNode<T extends Comparable>{
        T data;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode(T data, BinTreeNode left, BinTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public BinTreeNode(T data) {
            this(data, null, null);
        }

        boolean isLeaf(){
            return (left == null && right == null);
        }

        boolean hasLeft(){
            return (left != null);
        }

        boolean hasRight(){
            return (right != null);
        }


    }
}