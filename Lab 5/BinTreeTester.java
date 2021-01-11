/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrahman
 */
public class BinTreeTester {
    public static void main(String[] args) {
        BinSearchTree<Integer> bt = new BinSearchTree<>();
        bt.insert(5);
        bt.insert(500);
        bt.insert(50);
        bt.insert(200);
        bt.insert(54);
        
        
        bt.printInOrder();
        //System.out.println(bt.height());
        //System.out.println(bt.size());
        System.out.println(bt.contains(54));
    }
    
}
