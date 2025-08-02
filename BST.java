
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
    
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }   
    
    public static int maxBST = 0;

    public static Info largestBSt(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBSt(root.left);
        Info rightInfo = largestBSt(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min ) {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

     public static void predorder(Node root) {
        if( root ==  null ) {
            return;
        }
        System.out.print(root.data+" ");
        predorder(root.left);
        predorder(root.right);
    } 
   
    public static Node  createBST(ArrayList<Integer> arr, int st, int end ) {
        if(st>end) {
            return null;
        }    
        Integer mid = (st+end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root; 
    }
     
    public static void getInorder(Node root , ArrayList<Integer> arr) {
        if(root == null ) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right,arr);
    }
    
    public static Node mergeBSTs(Node root1, Node root2) {
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

       return  createBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String[] args) {
      
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);

        predorder(root);
    }
}
