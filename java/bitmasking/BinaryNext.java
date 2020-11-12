import java.util.*;

class BinaryNext {
    public int shiftInt(int n,int i,int count){
        n=n&(~(1<<i));
        n=n|(1<<(i+1));
        int z_mask=~((1<<i)-1);
        int o_mask=(1<<count)-1;
        
        return (n&z_mask)|o_mask;
    }
    public int solve(int n) {
        
        int i=0;
        boolean flag=false;
        int count=0;
        while(i<=32){
            // System.out.println(n&(1<<i));
            if(flag && (n&(1<<i))==0){
                // System.out.println(i-1);
                return shiftInt(n,i-1,count-1);
            }else if( (n&(1<<i))!=0){
                flag=true;
                count++;
            }
            
            i++;
        }
        return -1;
    }
}