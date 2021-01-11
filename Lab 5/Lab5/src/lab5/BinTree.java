package lab5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinTree<T extends Comparable> {

    private int size;
    BinTreeNode root;

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
    
    public int getSum()//Returns the sum of the entire tree.
    {
     return sumOfTree(root);   
    }
    
    public void root2Leaf(){//Method that runs the private method
      int[] path = new int[1000];  
      printRootToLeafPath(root, path, 0);   
    }
    
    public boolean sameTrees(BinTree a)//Method that checks if two tree's are the same.
    {
     return identicalTrees(root, a.root);   
    }
    
    public BinTreeNode mirrorTree()
    {
      return mirror(root);   
    }

    private void inorder(BinTreeNode r){
        if(r == null)
            return;
        inorder(r.left);
        System.out.println(r.data);
        inorder(r.right);
    }
    
    private void printRootToLeafPath(BinTreeNode r, int[]path, int size){
        
        if(r == null)//Returns if there is nothing in the tree.
          {
           return;   
          }
        path[size] = (int)r.data;//Attaches the data in root to the path array
        size++;//Increases the index for the array.
        
        if(r.left == null && r.right == null)//If it's a leaf
          {
            for(int i = 0; i < size; i++)
               {
                 System.out.println(path[i]);//Prints the path leading to the leaf.  
               }  
          }
        
        else//Traverses the other subtree's
          {
           printRootToLeafPath(r.left, path, size);
           printRootToLeafPath(r.right, path, size); 
          }
    }
    
    private int sumOfTree(BinTreeNode r) throws NonComparableElementException
    { int sum; //Variable to hold the total sums of each subtree
    
      sum = 0;
      Stack<BinTreeNode> stack = new Stack();//A stack to hold all of the nodes of the tree.
      
      //Returns 0 if the tree is empty  
      if(r == null)
        {
         return 0;   
        }
     else
         stack.push(r);//Pushes the root node onto the stack.
      
    if(!(r.data instanceof Integer))//If the data isnt an int type, throws exception
      {
       throw new NonComparableElementException("This is not an Integer type");   
      }
    
    else
      //A while loop that pushes all of the tree nodes onto the stack, then pops them to calculate their data   
      while(!stack.isEmpty())
          {
            BinTreeNode temp = stack.pop();//temp node to store the node thats popped off the stack.
            sum += (int)temp.data;
            
            if(temp.left != null)//Pushes all of the left subtrees onto the stack
              {
               stack.push(temp.left);   
              }
            
            if(temp.right != null)//pushes all of the right subtrees onto the stack.
              {
               stack.push(temp.right);   
              } 
          }
    
       //Returns the sum of those subtrees
       return sum;
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
    
    //Checks if two trees are the same
    private boolean identicalTrees(BinTreeNode a, BinTreeNode b)
    {
      if(a == null && b == null)//If both roots are null, then true.
        {
         return true;   
        }
      
      else if(a == null || b == null)//If only 1 is null, then false.
        {
         return false;   
        }
      
      if(a.data != b.data)//If the data within the current nodes aren't the same, false.
        {
         return false;
        }
      
      boolean leftIsSame = identicalTrees(a.left, b.left);//Checks if the left subtree is the same.
      boolean rightIsSame = identicalTrees(a.right, b.right);//Checks if the right subtree is the same.
      
      //If both the left and right subtrees are the same, then it returns true!
      if(leftIsSame && rightIsSame)
        {
         return true;   
        }
      
      //Otherwise they aren't identical at all.
      else return false;
    }
    
    //Creates the mirror of the current tree
    private BinTreeNode mirror(BinTreeNode r)
    {
     if(r == null)//Returns null if the tree is empty.
       {
        return null;  
       }
     
     BinTreeNode leftTree = mirror(r.left);//A temp node to store the left side of the tree
     BinTreeNode rightTree = mirror(r.right);//Temp node to store the right side of the tree
     
     //Swaps the two sides of the tree.
     r.left = rightTree;
     r.right = leftTree;
     
     return r;
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