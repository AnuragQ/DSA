package java.arrays;

import java.util.*;

public class SearchIn2dArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int  = sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
                // System.out.println(array[i][j]);
            }
            
        }
        sc.close();
        int num=sc.nextInt();
        int rows=0;
        int rowe=n-1;
        int floor = 0, mid = 0;

        boolean found = false;
        while (rows <= rowe) {
            mid = (rows + rowe) / 2;
            if (array[mid][0] == num) {
                floor = mid;
                break;
            } else if (array[mid][0] > num) {
                rowe = mid - 1;
            }
            else{
                floor=mid;
                rows=mid+1;
            }
        }
        int cols=0;
        int cole=n-1;
        while(cols<=cole){
            mid=(cols+cole)/2;
            if(array[floor][mid]==num){
                found=true;
                break;
            }
            else if(array[floor][mid]>num){
                cole=mid-1;
            }
            else{
                cols=mid+1;
            }
        }
        if(found){
            System.out.println(floor);
            System.out.println(mid);
        }
        else{
            System.out.println("Not Found");
        }
        
    }

}