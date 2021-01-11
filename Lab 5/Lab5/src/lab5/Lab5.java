
package lab5;

/**
 *
 * @author work
 */
public class Lab5 {

    
    public static void main(String[] args) {
       BinTree test = new BinTree();
       
       test.insert(4);
       test.insert(6);
       test.insert(15);
       test.insert(40);
       
       System.out.println("Testing Root to Leaf printing: ");
       test.root2Leaf();
       
       
       System.out.println("Testing getting the sum of the tree: ");
       try
         {
         System.out.println("Total sum of tree: " + test.getSum());
         }
       catch(NonComparableElementException exception)
         {
          System.out.println("The current tree contains non Int data."); 
         }
       
       
       BinTree tree1 = new BinTree();
       BinTree tree2 = new BinTree();
       
       tree1.insert(2);
       tree1.insert(4);
       tree1.insert(9);
       tree1.insert(6);
       
       tree2.insert(3);
       tree2.insert(7);
       tree2.insert(9);
       tree2.insert(6);
       
       System.out.println("Testing if 2 trees are the same: ");
       System.out.println(tree1.sameTrees(tree2));
       
       
       System.out.println("Testing the mirror of a tree: ");   
       test.mirrorTree();
       test.root2Leaf();
       
       
       System.out.println("Testing Binary Search Tree findMin() and findMax(): ");
       BinSearchTree tester = new BinSearchTree();
       
       tester.insert(6);
       tester.insert(7);
       tester.insert(1);
       tester.insert(31);
       tester.insert(90);
       
       System.out.println(tester.findMin());
       System.out.println(tester.findMax());
       
       
       System.out.println("Testing Binary Search Tree non-recursive find() method: ");
       System.out.println(tester.contains(2));
       
       
       System.out.println("Testing the Binary Search Tree merge() method: ");
       BinSearchTree tester2 = new BinSearchTree();
       
       tester2.insert(4);
       tester2.insert(8);
       tester2.insert(1);
       tester2.insert(2);
       tester2.insert(100);
       
       tester.merge(tester2);
       tester.printInOrder();
    }
    
}
