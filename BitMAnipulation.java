



public class BitMAnipulation {
    
    public static void oddOrEven(int n){
        int bitmask = 1;
        if( (n & bitmask)== 0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }

    public static int getIthBit(int n, int i){
        int bitmask = 1<< i;
        if( (n & bitmask)==0){
            return 0;
        }else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i){
        int bitmask = 1<<i;
       return n| bitmask;
    }

    public static int clearIthBit(int n ,int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }

    public static int updateIthbit(int n, int i, int newBit){
       n = clearIthBit(n, i);
       int bitmask = newBit<<i;
       return n | bitmask;
    }

    public static int clearIbits(int n, int i){
        int bitmask = (~0)<<i;
        return n & bitmask;
    }

    public static int clearIbitsInRange(int n , int i, int j ){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static boolean  powerOf2(int n){
        return  ( n & (n-1)) == 0;
    }

    public static int countSetBits(int n ){
        int count = 0;
        while( n> 0){
            if( (n &1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }


    public static int fastExpo(int a, int n ){
        int ans = 1;

        while(n > 0){
            if( (n & 1) !=0){
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }

   public static void main(String[] args) {
    System.out.println(fastExpo(3, 5));
   }
}
