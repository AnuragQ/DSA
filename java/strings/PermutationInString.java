import java.util.HashMap;
class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        System.out.println(s1.length()+" "+s2.length());
        // aabb,abab,baba,abba,baab
        if(s1.length()>s2.length()){
            return false;
        }
        if(s1.length()==0){
            return true;
        }
           //create hashmap of first string
            HashMap<Character,Integer> hm1 = new HashMap<>();
            for(int i=0;i<s1.length();i++){
                char ch=s1.charAt(i);
                hm1.put(ch,hm1.getOrDefault(ch,0)+1);
            }
            int m=0,n=s1.length()-1;
            HashMap<Character,Integer> hm2 = new HashMap<>();
            //start or sliding window
            for(int i=0;i<s1.length();i++){
                char ch=s2.charAt(i);
                hm2.put(ch,hm2.getOrDefault(ch,0)+1);
            }
            while(n<s2.length()){
                char c_start=s2.charAt(m);
                // System.out.println(m+" "+n);
                m++;
                
                if(m==1430){
                    System.out.println(hm1+" "+hm2);
                    
                } 


                // System.out.println(hm2);
                if(isValid(hm1,hm2,m)){
                    return true;
                }
                    
                else{
                        n+=1;
                    
                    if(n<s2.length()){
                        char c_end=s2.charAt(n);
                        hm2.put(c_start,hm2.get(c_start)-1);
                                        // System.out.println(c_end+" "+n);
                    
                        hm2.put(c_end,hm2.getOrDefault(c_end,0)+1);
                                            

                    }
                    
                }
                
            }
            return  isValid(hm1,hm2,0);
            
    }
    
    public boolean isValid(HashMap<Character,Integer> hm1,HashMap<Character,Integer> hm2,int m){
        for(Character ch:hm1.keySet()){
            int a=hm1.get(ch);
            int b=hm2.getOrDefault(ch,0);
            // if(hm1.get(ch)!=hm2.getOrDefault(ch,0)){
                            if(a!=b){

                if(m==1430){
                    // System.out.println(hm1)
                    System.out.println(ch+" "+hm1.get(ch)+" "+hm2.getOrDefault(ch,0));
                }
                
                return false;
            }
        }
        return true;
    }
    
}

// Test case 1
// s1 abc s2 aabbcaba --> true
// test case 2
//     s1 xyasd s2 a --> false
// s1 '' s2 mnop ---> true
// s1 1231 s2 55443322113 --> true
// s1 1as2 s2 as12345 -->true
// s1 aaaab s1 aaaaaab -->
// n=size(s2)
// m=size(s1)
//                  ^   ^(n-m)m 
// s1 abc s2 aabbcaa --> true
//           ^ 
// bool isSubStrind(s1,s2)
//     1. create hm for s1
//     2. i=0,j=s1.length;
//         hm2=hm for s2(0:size(s1))
//     3. while(j<s2.length) do
           
//     4.     if(isValid(hm1,hm2)) do
//     5.          return true
//     6.      else do
//                 j++
//      7.          hm2.put(charAt(i),hm(charAt(i))--)
//     8.            hm2.put(charAt(j),hm(charAt(j))--)
//     9. end
//     10 return false

//     aabbcc
//     aabbdd

// abc
// aaaaaaabbbbbbb
// ^ ^
// bool isValid(hm1,hm2)   
//         1. for(key in hm1)do
//         2.     if(hm1.get(key,0)!=hm2.get(key,0))
//         3.          false
//         4.  return true
// ////pseudocode
// hm=hashmap(s1);
// i=0,j=0, 
// hm1{
//     a:1,
//     b:1,
//     c:1
// }
// hm2{
//     a:1
// }
// aabbcaba
// Space:O(size(s1))
// Time:O(size(s2))    
// while(j<length(s2)):
//     char ch = s2
    
//     if(ch in hm1 && hm2(ch)<hm1(ch) if()):
//         hm2()