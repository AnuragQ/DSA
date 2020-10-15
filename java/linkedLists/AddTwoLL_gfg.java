




class AddTwoLL_gfg{
    class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    static int size(Node head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }
    static Node addLists(Node first, Node second){
        // code here
        // return head of sum list
        Node sum=new Node(0);
        sum.next=new Node(0);
        int co=addLists(first,size(first),second,size(second),sum.next);
        if(co>0){
            sum.data=co;
            return sum;
        }else{
            return sum.next;
        }
        
    }
    static int addLists(Node first,int pvf,Node second,int pvs,Node sum){
        if(first==null && second==null){
            return 0;
        }
        int data=0;
        if(pvf>1 || pvs>1){
            
            sum.next=new Node(0);
        }
        if(pvf>pvs){
            int co=addLists(first.next,pvf-1,second,pvs,sum.next);
            data=co+first.data;
        }else if(pvs>pvf){
            int co=addLists(first,pvf,second.next,pvs-1,sum.next);
            data=co+second.data;
        }else{
            int co=addLists(first.next,pvf-1,second.next,pvs-1,sum.next);
            data=co+first.data+second.data;
        }
        sum.data=data%10;
        return data/10;
        
    }
}

