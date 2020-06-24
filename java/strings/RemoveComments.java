import java.util.ArrayList;
import java.util.List;

class RemoveComments   {
    public List<String> removeComments(String[] source) {
        boolean flag=false;
        ArrayList<String> ans=new ArrayList<>();
        String word="";
        for(int i=0;i<source.length;i++){
            for(int j=0;j<source[i].length();j++){
                // System.out.println(word+'-');
                if(!flag){
                    if(source[i].charAt(j)=='/'){
                        j++;
                        if(j<source[i].length() && source[i].charAt(j)=='/' ){
                            if(word.length()>0){
                                ans.add(word);
                                word="";
                            }
                            break;
                        }else if(j<source[i].length() && source[i].charAt(j)=='*'){
                            flag=true;   
                        }else{
                            j--;
                        word+=source[i].charAt(j);
                            
                        }
                        
                    }   
                    else{
                        // word+=charAt(j);
                        word+=source[i].charAt(j);
                    }
                    

                }else{
                    
                    if(source[i].charAt(j)=='*' ){
                        if(j+1<source[i].length() && source[i].charAt(j+1)=='/'){
                            flag=false;
                            j++;
                        }
                    }
                }
            }
            if(!flag && word.length()>0){
                ans.add(word);
                word="";
            }
        }
        return ans;
    }
}