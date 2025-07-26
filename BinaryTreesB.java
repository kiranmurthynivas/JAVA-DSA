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

    public static int diameter(Node root) {
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
   

    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

       System.out.println(diameter(root));
       
    }
}
