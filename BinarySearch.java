import java.util.*;

class BinarySearch{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            int lo =0, hi=n-1;
            int mid=0;
            while(lo<=hi){
                mid = lo+(hi-lo)/2;
                if(arr[mid]==key){
                    break;
                }else if(arr[mid]>key){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
            if(lo<=hi){
                System.out.println(mid+1);
            }else{
                System.out.println("False");
            }
            t--;
        }
    }
}