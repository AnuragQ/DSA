import java.io.*;
import java.util.*;

public class QueenComb2D2DBoxChoose {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        if(row==tq){
            if(qpsf==tq)
                System.out.println(asf);
            return;
        }
        int nextRow=0;
        
        int nextCol=0;
        String lastCol="";
        if(col==tq-1){
            lastCol="\n";
            nextCol=0;
            nextRow=row+1;
        }
        else{
            nextCol=col+1;
            nextRow=row;
        }
        if(qpsf<tq){
            
            queensCombinations(qpsf+1,tq,nextRow,nextCol,asf+"q"+lastCol);
        }
        queensCombinations(qpsf,tq,nextRow,nextCol,asf+"-"+lastCol);
        
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // System.out.println("as\nas");
        queensCombinations(0, n, 0, 0, "");
    }
}