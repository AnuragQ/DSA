

////not printed

public class GenerateAllSortedArray {
public static void main(String[] args) {
    int[] A={2,3,25};
    int[] B={1,5,20,30};
    printAllSorted(A,B,0,0,false,"",Integer.MIN_VALUE);
}

private static void printAllSorted(int[] A, int[] B, int i, int j, boolean fromB,String asf ,int prev)  {

    if((!fromB && i>=A.length) || (fromB && j>=B.length)){        
        return;
    }       
    
    if(fromB){
        if(B[j]>=prev){
            System.out.println(asf +B[j]+" ");
            printAllSorted(A, B, i, j+1, !fromB, asf+B[j]+" ",B[j]);                
        }
        printAllSorted(A, B, i, j+1, fromB, asf,prev);
        
    }else{
        if(A[i]>=prev){
            printAllSorted(A, B, i+1, j, !fromB, asf+A[i]+" ",A[i]);
        }
        printAllSorted(A, B, i+1, j, fromB, asf,prev);
        
    }
}

}
