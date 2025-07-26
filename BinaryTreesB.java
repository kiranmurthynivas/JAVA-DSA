import java.util.*;
import java.util.LinkedList;
public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if( root == null ) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static  int count(Node root) {
        if( root == null ) {
            return 0;
        }
        int lcount = count(root.left);
        int rcount = count(root.right);
        return lcount + rcount + 1;
    }

    public static  int sum(Node root) {
        if( root == null ) {
            return 0;
        }
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return lsum + rsum + root.data;
    }

    public static int diameter(Node root) { //approch 1  O(n^2)
        if( root == null ) {
            return 0;
        }

        int ldia = diameter(root.left);
        int rdia = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int selfdia = lh + rh + 1;

        return Math.max(selfdia,Math.max(ldia, rdia));
    }

    static class Info {
        int dia;
        int ht;

        public Info ( int dia, int ht ) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) { //approch 2  O(n)
        if( root == null ) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(dia, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null ) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data ) {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }
    
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
   
    static class Tinfo {
        Node node;
        int hd;

        public Tinfo(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {

        
        Queue<Tinfo> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0 , max = 0;
        q.add(new Tinfo(root, 0));
        q.add(null);

        while(!q.isEmpty()) {
            Tinfo curr = q.remove();
            if(curr == null ) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }  

                if( curr.node.left != null) {
                    q.add(new Tinfo(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if( curr.node.right != null) {
                    q.add(new Tinfo(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for( int i = min; i<=max; i++ ) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println("");
    }

    public static void kLevel( Node root , int level,int  k) {
        if ( root == null ) {
            return;
        }

        if ( level == k ) {
            System.out.print(root.data+" ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }
    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);               
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

       int k = 3;
       kLevel(root, 1, k);
    }
}
