import java.util.ArrayList;

    public class PairSum {

        public static boolean  pairsum1(ArrayList<Integer> list, int target){
            // brute force
            // for(int i = 0; i<list.size(); i++){
            //     for(int j = i+1; j<list.size(); j++){
            //         if(list.get(i)+ list.get(j) == target){
            //             return true;
            //         }
            //     }
            // }
            // return false;

            // 2 pointer approch

            int lp = 0;
            int rp = list.size()-1;

            while( lp< rp){
                if( list.get(lp) + list.get(rp) == target){
                    return true;
                }else if( list.get(lp) + list.get(rp) < target){
                    lp++;
                }else{
                    rp--;
                }
            }
            return false;
        }

        public static boolean pairSum2( ArrayList<Integer> list, int target){
            // 2 pointer approch
            int bp = -1;
            int n = list.size();

            for(int i = 0; i<n-1; i++){
                if( list.get(i)> list.get(i+1)){
                    bp = i;
                    break;
                }
            }

            int lp = bp+1;
            int rp = bp;

            while( lp!=rp){

                if( list.get(lp)+list.get(rp) == target){
                    return true;
                }else if( list.get(lp)+ list.get(rp) < target){
                    lp = (lp + 1) % n;
                }else{
                    rp = (n + rp -1) % n;
                }
            }
            return false;
        }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSum2(list, 16));
    }
}