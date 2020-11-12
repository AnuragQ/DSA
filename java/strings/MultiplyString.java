class MultiplyStrings {
    public String multiply(String num1, String num2) {
        
        int[] ans=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int num1_val=num1.charAt(i)-'0';
                int num2_val=num2.charAt(j)-'0';
                int product=num1_val*num2_val+ans[i+j+1];
                ans[i+j+1]=product%10;
                ans[i+j]=product/10 +(ans[i+j]);
            }
        }
        String prod="";
        boolean flag=true;
        for(int i=0;i<ans.length;i++){
            if(ans[i]==0 &&flag)
                continue;
            else
                flag=false;
                     
            prod=prod+ans[i];
        }
        return "".equals(prod)?"0":prod;
    }
}