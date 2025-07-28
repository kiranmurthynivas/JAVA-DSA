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

    public static boolean getPath( Node root , int n , ArrayList<Node> path ) {

        if( root == null ) {
            return false;
        }
        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight ) {
            return true;
        }

        path.remove(path.size()-1);

        return false;

    }
    public static Node lca(Node root , int n1, int n2 ) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i =0;
        for(; i<path1.size() && i<path2.size(); i++ ) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        } 

        Node lca = path1.get(i-1);
        return lca;
    } 

public static Node lca2(Node root, int n1, int n2) {
    if (root == null || root.data == n1 || root.data == n2) {
        return root;
    }

    Node leftlca = lca2(root.left, n1, n2);
    Node rightlca = lca2(root.right, n1, n2);

    if (leftlca == null) {
        return rightlca;
    }
    if (rightlca == null) {
        return leftlca;
    }

    return root;
}

public static int lcaDist(Node root, int n){
    if(root == null ) {
        return -1;
    }

    if(root.data == n) {
        return 0;
    }

    int leftDist = lcaDist(root.left, n);
    int rigthDist = lcaDist(root.right, n);

    if(leftDist == -1 && rigthDist == -1 ) {
        return -1;
    } else if (leftDist == -1)  {
        return rigthDist+1;
    } else {
        return leftDist+1;
    }
}

public static int minDist(Node root, int n1, int n2 ) {
    Node lca = lca2(root, n1, n2);
    int dist1= lcaDist(lca,n1);
    int dist2= lcaDist(lca,n2);

    return dist1 + dist2;
}


    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);               
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

       int n1 = 4, n2 = 5;
       System.out.println(minDist(root, n1, n2));
    }
}
