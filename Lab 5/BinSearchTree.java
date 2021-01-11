/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrahman
 */
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

    private boolean find(T ele, BinTreeNode r) {
        if (r == null) {
            return false;
        }

        if (r.getData().compareTo(ele) == 0) {
            return true;
        }

        if (ele.compareTo(r.getData()) < 0) {
            if (r.getLeft() != null) {
                if(find(ele, r.getLeft()))
                    return true;

            }
        } else if (ele.compareTo(r.getData()) > 0) {
            if (r.getRight() != null) {
                if(find(ele, r.getRight()))
                    return true;
            }
        }

        return false;
    }

    public boolean contains(T ele) {

        return find(ele, root);
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
}
