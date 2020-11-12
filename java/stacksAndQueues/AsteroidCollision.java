class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]<0){
                boolean vanished=false;
                while(stack.size()>0 && stack.peek()>=0){
                    if(stack.peek()<Math.abs(asteroids[i])){
                        stack.pop();
                    }else if(stack.peek()==Math.abs(asteroids[i])){
                        stack.pop();
                        vanished=true;
                        break;
                    }else{
                        vanished=true;
                        break;
                    }
                }
                if(!vanished){
                    stack.push(asteroids[i]);
                }
            }else{
                stack.push(asteroids[i]);
            }
        }
        int[] ans=new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
