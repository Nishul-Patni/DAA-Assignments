import java.util.*;

class LinearSearch{
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
            int i=0;
            while(i<n){
                if(arr[i]==key){
                    break;
                }
                i++;
            }
            if(i==n){
                System.out.println(0);
            }else{
                System.out.println(1+" "+(i+1));
            }
            t--;
        }
    }
}