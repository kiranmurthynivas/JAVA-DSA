public class DividenConquer {

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void mergeSort(int arr[], int si,int ei){
        if( si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        megre(arr, si, mid, ei);
    }

    public static void megre(int arr[], int si, int mid, int ei ){
        int temp[] = new int[ei-si+1];
        int i= si;
        int j= mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]= arr[i];
                i++;
            }else{
                temp[k]= arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0,i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }

    }
    
    public static void quickSort(int arr[], int si,int ei){
        if(si>= ei){
            return;
        }
        int piIdx = partiiton(arr, si, ei);
        quickSort(arr, si, piIdx-1);
        quickSort(arr, piIdx+1, ei);
    }  

    public static int partiiton(int arr[], int si, int ei){

        int pivot = arr[ei];
        int i = si-1;
        for(int j=si; j<ei; j++){
            if(arr[j]< pivot ){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
        
    }

    public static int search(int arr[], int target, int si, int ei){

        if( si>ei){
         return -1;
        }

        int mid = si+(ei-si)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[si]<=arr[mid]){
            if(arr[si]<=target && target <= arr[mid]){
                return search(arr, target, si, mid-1);
            }else {
                return search(arr, target, mid+1, ei);
            }

        }else{
            if(arr[mid]<=target && target <= ei){
                return search(arr, target, mid+1, ei);
            }else{
                return search(arr, target, mid-1, si);
            }
        }
    }


    public static void main(String[] args) {
        String  arr[] = { "sun", "earth", "mars", "mercury"};
       
        
    }
}
