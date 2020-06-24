
import java.util.HashMap;

public class CountSubarraySumDivByK {
   
        public int subarraysDivByK(int[] A, int K) {
            HashMap<Integer,Integer> hm=new HashMap<>();
            hm.put(0,1);
            int sum=0;
            int count=0;
            int mod=0;
            for(int i=0;i<A.length;i++){
                sum+=A[i];
                 mod=((sum%K)+K)%K;
                count+=hm.getOrDefault(mod,0);
                hm.put(mod,hm.getOrDefault(mod,0)+1);
                
            }
            return count;
        }
    
}