class KthLargestinBST
{
    class pair{
        int nodeCount;
        int largestNode;
        public pair(){
            nodeCount=0;
            largestNode=-1;
        }
        public pair(int nodeCount,int largestNode){
            this.nodeCount=nodeCount;
            this.largestNode=largestNode;
        }
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        return helper(root,K).largestNode;
        
        
    }
    public pair helper(Node root,int k)
    {
        //Your code here
        if(root==null){
            return new pair();
        }
        pair lans=helper(root.right,k);
        if(lans.largestNode!=-1){
            return lans;
        }
        if(k-1-lans.nodeCount==0){
            return new pair(0,root.data);
        }
        
        pair rans=helper(root.left,k-1-lans.nodeCount);
        if(rans.largestNode!=-1){
            return rans;
        }
        
        return new pair(lans.nodeCount+rans.nodeCount+1,-1);
    }
    
    
    
    
    
}