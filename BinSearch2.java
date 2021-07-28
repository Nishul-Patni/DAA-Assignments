import java.util.Scanner;
class BinSearch2{
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
            int isPresent = binSearch(arr, key, n-1, 0);
            if(isPresent==-1){
                System.out.println(key+"-"+0);
            }else{
                // finding first occurence
                int st = isPresent, temp = isPresent;
                
                while(temp!=-1){
                    temp = binSearch(arr, key, temp-1, 0);
                    if(temp!=-1)
                        st = temp;
                }

                // finding last occurence

                int end = isPresent;
                temp = isPresent;
                while(temp!=-1){
                    temp = binSearch(arr, key, n-1, temp+1);
                    if(temp!=-1){
                        end = temp;
                    }
                }

                System.out.println(key+"-"+(end-st+1));
            }
            t--;
        }
    }

    public static int binSearch(int [] arr, int key, int hi, int lo){
        if(lo==-1){
            return -1;
        }
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        return -1;
    }
}