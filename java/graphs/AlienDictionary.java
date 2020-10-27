// https://practice.geeksforgeeks.org/problems/alien-dictionary/1
// https://practice.geeksforgeeks.org/problems/alien-dictionary/1
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

class Solution
{
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashMap<Character,ArrayList<Character>> graph=new HashMap<>();
        HashMap<Character,Integer> indegree=new HashMap<>();

        for(int i=0;i<dict.length-1;i++){
            String one=dict[i];
            String two=dict[i+1];
            for(int j=0;j<Math.min(one.length(),two.length());j++){
                char o=one.charAt(j);
                char t=two.charAt(j);
                if(o==t){
                    continue;
                }else{
                    if(!graph.containsKey(o)){
                        
                        ArrayList<Character> nbr=new ArrayList<>();
                        nbr.add(t);
                        graph.put(o,nbr);
                    }else{
                        ArrayList<Character> nbr=graph.get(o);
                        nbr.add(t);
                        graph.put(o,nbr);
                    }
                    if(!graph.containsKey(t)){
                            graph.put(t,new ArrayList<>());
                        }
                    indegree.put(t,indegree.getOrDefault(t,0)+1);
                    break;

                }
            }
  
        }
        String order="";
        ArrayDeque<Character> zero=new ArrayDeque<>();
        for(Character ch:graph.keySet()){
            
            if(indegree.get(ch)==null){
                zero.add(ch);
                break;
            }
            
        }
        while(!zero.isEmpty()){
            char rem=zero.remove();
            order=order+rem;
            for(char nbr:graph.get(rem)){
                indegree.put(nbr,indegree.get(nbr)-1);

                if(indegree.get(nbr)==0){
                    zero.add(nbr);
                }
            }
        }
        return order;
    }
}











