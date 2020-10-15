/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SegregateOddEven {
    static class Node{
        Node next; 
        int data;
        public Node(int data){
            this.data=data;
        }
    }
	public static void main (String[] args) throws IOException{
		//code
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    Node dum=new Node(0);
		    Node tmp=dum;
		    String[] inp=br.readLine().split(" ");
		    for(int i=0;i<n;i++){
		        dum.next=new Node(Integer.parseInt(inp[i]));
		        dum=dum.next;
		    }
		    Node head=tmp.next;
		    Node seg=segregate(head);
		    while(seg!=null){
		        System.out.print(seg.data+" ");
		        seg=seg.next;
		    }
		    	 System.out.println();

		}
	}
	public static Node segregate(Node head){
	    Node odd=new Node(0);
	    Node even=new Node(0);
	    Node etemp=even;
	    Node otemp=odd;
	    while(head!=null){
	        if((head.data&1)==0){
	            even.next=head;
	            head=head.next;
	            even=even.next;
	        }else{
	            odd.next=head;
	            head=head.next;
	            odd=odd.next;
	        }
	       // head=head.next;
	    }
        even.next=otemp.next;
        ///////////
        odd.next=null;
        ///////////                         
	    return etemp.next;
	}
	
	
}



