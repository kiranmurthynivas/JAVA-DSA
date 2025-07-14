public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        
        Node newNode = new Node(data);
        size++;

        if( head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public void addLast(int data){

        Node newNode = new Node(data);
        size++;
        if( head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;
    }

    public void printLL(){
        if( head == null){
            System.out.println("Linked is empty");
            return;
        }
        Node temp = head;
        while( temp !=  null){
            System.out.print( temp.data+" ");
            temp= temp.next;
        }

    }

    public void addIndex(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while( i< idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size== 1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if( size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if( size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for( int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addIndex(2, 6);
        ll.printLL();
        System.out.println(" ");


        // System.out.println(ll.size);
        ll.removeFirst();
        ll.printLL();

        System.out.println("");

        ll.removeLast();
        ll.printLL();
        System.out.println(ll.size);
    }  
}
