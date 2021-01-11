package lab5;

import java.util.LinkedList;
import java.util.Queue;

public class BinSearchTree<T extends Comparable> {

    private BinTreeNode root;
    private int size;

    public BinSearchTree() {
        root = null;
        size = 0;
    }

    public void insert(T element) {

        root = add(element, root);
        size++;
    }
    
    public T findMin()
    {
      BinTreeNode temp = findMinValue(root);//Temp node that represents the node with the lowest value  
      return (T)temp.getData();  //Returns the data held in that node.
    }
    
    public T findMax()
    {
      BinTreeNode temp = findMaxValue(root);//Temp node that represents the node with the highest value 
      return (T)temp.getData();//Returns the data held in that node.   
    }

    //Non-recursive version of the find method.
    private boolean find(T ele, BinTreeNode r) {
        Queue<BinTreeNode> cur = new LinkedList<BinTreeNode>();//A queue that holds the current node
        BinTreeNode temp = new BinTreeNode();//A temp node that represents the current node.
        
        if (r == null)//If the tree is empty, return false.
        {
            return false;
        }

        if (r.getData().compareTo(ele) == 0)//If the root is the element you're looking for, return true.
        {
            return true;
        }

        cur.add(r);//Pushes the root onto the que.
        
        if (ele.compareTo(r.getData()) < 0)//If the data in root is larger then the key
        {
         while(!cur.isEmpty())//Will run as long as the que isn't empty.
         {   
          temp = cur.poll();//Removes the first node in the que, stores it in temp.
          if(temp != null)//If the temp node isn't null.
          { 
           if(ele.compareTo(temp.getData()) == 0)//Will return true if the data in the current node matches the key
            {
             return true;   
            }
           cur.add(temp.getLeft());//Traverses the left subtree and pushes it onto the queue
          }
         } 
        } 
        
        if (ele.compareTo(r.getData()) > 0)//If the data in root is smaller then the key
        {
         while(!cur.isEmpty())//Will run as long as the que isn't empty.
         {   
          temp = cur.poll();//Removes the first node in the que, stores it in temp.
          if(temp != null)//If the temp node isn't null.
          {
           if(ele.compareTo(temp.getData()) == 0 && temp.getData() != null)//Will return true if the data in the current node matches the key
            {
             return true;   
            }
           cur.add(temp.getRight());//Traverses the right subtree and pushes it onto the queue
          }
         }   
        }
       
     return false;//Returns false if no data in the Tree matches the key.
    }

    public boolean contains(T ele) {

        return find(ele, root);
    }
    
    //Method to merge two seperate trees into a single tree.
    private BinTreeNode mergeTree(BinTreeNode a, BinTreeNode b) throws NonComparableElementException
    {
     int sum;//Variable to hold the sum of data of two trees   
        if(a == null)//If a is empty then returns b
         {
          return b;   
         }
     
        if(b == null)//If b is empty then returns a
         {
          return a;   
         }
        
        sum = (int)a.data + (int)b.data;//Adds the data of both current nodes together
        a.data = sum;//Sets the current node to sum
        a.setLeft(mergeTree(a.getLeft(), b.getLeft()));//Traverses left tree and sets the nodes.
        a.setRight(mergeTree(a.getRight(), b.getRight()));//Traverses the right tree and sets the nodes.
     
     return a;//Returns the new tree. 
    }
    
    public void merge(BinSearchTree r)//Method for merging trees.
    {
     mergeTree(root, r.root);   
    }

    private BinTreeNode<T> add(T data, BinTreeNode r) {
        if (r == null) {
            r = new BinTreeNode(data);
        } else {
            if (data.compareTo(r.getData()) < 0) {
                r.setLeft(add(data, r.getLeft()));
            } else if (data.compareTo(r.getData()) > 0) {
                r.setRight(add(data, r.getRight()));
            }

        }
        return r;
    }

    private void inOrder(BinTreeNode r) {
        if (r == null) {
            return;
        }
        inOrder(r.getLeft());
        System.out.println(r.getData());
        inOrder(r.getRight());
    }

    public void printInOrder() {
        inOrder(root);
    }

    private void preOrder(BinTreeNode r) {
        if (r == null) {
            return;
        }

        System.out.println(r.getData());
        inOrder(r.getLeft());
        inOrder(r.getRight());
    }

    public void printPreOrder() {
        preOrder(root);
    }

    public void printLevelOrder() {
        levelOrder(root);
    }

    public int size() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(BinTreeNode r) {
        if (r == null) {
            return 0;
        }
        return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }

    private void levelOrder(BinTreeNode r) {
        // create a Q
        //enQ(r);
        //while(!Q.isEmpty()){
        //n = deQ();
        //print n
        //enQ all the children of n
    }
    
   //Finds the minimum value in the Tree 
   private BinTreeNode<T> findMinValue(BinTreeNode r)
   {
    if(r == null)//If the tree is empty
	 {
	  return null;
	 }
	 
	else if(r.getLeft() == null)//Will return the farthest left node.
	   { 
	    return r;
	   }
    
    return findMinValue(r.getLeft());//Will continue to go down the left side until it
                               //hits null.
   }

   //Finds the maximum value in the Tree 
   private BinTreeNode<T> findMaxValue(BinTreeNode r)
   {
    if(r == null)//If the tree is empty
	 {
	  return null;
	 }
	 
	else if(r.getRight() == null)//Will return the farthest right node.
	   { 
	    return r;
	   }
    
    return findMaxValue(r.getRight());//Will continue to go down the right side until it
                               //hits null.
   }
}
