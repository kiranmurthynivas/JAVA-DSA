import java.util.*;

public class AList {

    public static  void swap ( ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(6);
        list.add(9);
        list.add(5);

        System.out.println(list);

        //System.out.println(list.get(2));

        //list.remove(2);
        // System.out.println(list);

        // list.set(2, 5);
        // System.out.println(list);

        // System.out.println(list.contains(3));
        // System.out.println(list.contains(6));

        // list.add(1, 5);
        // System.out.println(list);

        // for( int i = list.size()-1; i>= 0; i--){
        //     System.out.print(list.get(i));
        // }

        // Integer max = Integer.MIN_VALUE;
        // for( int i = 0; i < list.size(); i++ ){
        //     max = Math.max(max, list.get(i));
        // }
        // System.out.println("Maximum value "+ max);

        // int idx1 = 1, idx2 = 3;
        // swap(list, idx1, idx2);
        // System.out.println(list);

        // Collections.sort(list);
        // System.out.println(list);

        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1);
        // list1.add(2);
        // mainList.add(list1);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3);
        // list2.add(4);
        // mainList.add(list2);

        // for(int i = 0; i<mainList.size(); i++){
        //     ArrayList<Integer> cuArrayList =  mainList.get(i);
        //     for(int j  = 0 ; j<cuArrayList.size(); j++){
        //         System.out.println(cuArrayList.get(j));
        //     }
        // }
        // System.out.println(mainList);
    }
}