
import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root , int val  ) {
        if(root == null ) {
            root = new Node(val);
            return root;
        }

        if(root.data > val ) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean search(Node root , int key  ) {

        if( root == null ) {
            return false;
        }

        if( root.data == key ) {
            return true;
        }

        if( root.data > key ) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    } 

    public static Node delete(Node root, int val) {
        if (root == null) return null;

        if (root.data < val) {
            root.right = delete(root.right, val); 
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data); 
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root , int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data <= k1 ) {
            printInRange(root.right, k1, k2);
        } 
        else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++ ) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if( root == null ) {
            return;
        }
        path.add(root.data);
        if( root.left == null && root.right == null ) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isVaildBST(Node root, Node min , Node max) {
        if(root == null ) {
            return true;
        }

        if(min != null && root.data <= min.data ) {
            return false;
        }
        else if(max !=null && root.data >= max.data) {
            return false;
        }

        return isVaildBST(root.left, min, root) && isVaildBST(root.right, root, max);
    }

    public static Node mirror(Node root) {
        if( root == null ) { 
            return null;
        }
        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void predorder(Node root) {
        if( root ==  null ) {
            return;
        }
        System.out.print(root.data+" ");
        predorder(root.left);
        predorder(root.right);
    } 

    public static void getInorder(Node root , ArrayList<Integer> inorder) {
        if(root == null ) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

     public static Node  createBST(ArrayList<Integer> inorder, int st, int end ) {
        if(st>end) {
            return null;
        }    
        Integer mid = (st+end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root; 
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void main(String[] args) {
      
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);


        root = balanceBST(root);
        predorder(root);
    }
}
