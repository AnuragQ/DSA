import java.io.*;
import java.util.*;

public class MinStack_  {

  public static class MinStack {
    Stack<Integer> allData;
    Stack<Integer> minData;

    public MinStack() {
      allData = new Stack<>();
      minData = new Stack<>();
    }


    int size() {
        return this.allData.size();
      // write your code here  
    }

    void push(int val) {
        
        if(minData.size()==0 || minData.peek()>=val){
            minData.push(val);
        }
            allData.push(val);
        
      // write your code here
    }

    int pop() {
      // write your code here
      if(allData.size()==0){
          System.out.println("Stack underflow");
          return -1;
          
      }
      if(minData.peek()==allData.peek()){
          minData.pop();
      }
      int val=allData.pop();
      return val;
    }

    int top() {
      // write your code here
      if(allData.size()==0){
          System.out.println("Stack underflow");
          return -1;
          
      }
      int val=allData.peek();
      return val;
    }

    int min(){
  	  // write your code here
  	  
  	  if(allData.size()==0){
          System.out.println("Stack underflow");
          return -1;
          
      }
      int val=minData.peek();
      return val;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("min")){
        int val = st.min();
        if(val != -1){
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}