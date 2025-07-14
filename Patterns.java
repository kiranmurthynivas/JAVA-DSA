public class Patterns {
    public static void hallowRectangle(int rows, int cols) {
        for ( int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if( i==1|| i == rows || j == 1 || j == cols){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void irhPyramid(int n) {
        for(int i= 1; i<=n; i++) {
            for(int j=1; j <=n - i ; j++){
                System.out.print(" ");
            }
            for(int j=1; j <=i ; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }

    public static void invertedHalfPyramid(int n) {
        for( int i =1; i <= n ; i++) {
            for (int j = 1 ; j <= n-i+1 ; j++ ){
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public static void floydsTringle(int n) {
        int count = 1;

        for(int i = 1; i <=n ; i++){
            for(int j = 1; j <= i ; j++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println("");
        }
    }

    public static void zeroOneTringle(int n ) {
        for(int i = 1; i <=n ; i++) {
            for (int j = 1; j<=i ; j++){
                if( ( i+ j) % 2 == 0) {
                    System.out.print("1");
                }else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }

    public static void butterfly( int n ) {
        // 1st half

        for( int i= 1; i <=n ; i++){
            for(int j = 1 ; j <=i; j++){
                System.out.print("*");
            }
            for(int j=1 ; j<= 2 *(n - i); j++) {
                System.out.print(" ");
            }
            for( int j=1; j<= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        //2nd half
        for( int i= n; i >=1; i--){
            for(int j = 1 ; j <=i; j++){
                System.out.print("*");
            }
            for(int j=1 ; j<= 2 *(n - i); j++) {
                System.out.print(" ");
            }
            for( int j=1; j<= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }


    public static void soildRhombus( int n) {
        for(int i= 1; i<=n; i++){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j= 1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void hallowRhombus(int n) {
        for(int i= 1; i<=n; i++){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
            
                for(int j=1; j<=n; j++){
                    if( i==1|| i == n || j == 1 || j == n){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        
    }

    public static void diamond(int n) {
        for(int i= 1; i<=n; i++){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
           
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        
        for( int i= n; i >=1; i--){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
            
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
       
    }

    public static void main(String[] args) {
      diamond(10);
    }
}
