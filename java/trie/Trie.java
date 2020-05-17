 
/**
 * TrieImplemmentation
 */
public class Trie {
    Node root;
    static final int LENGTHOFCHILDREN = 26;

    private class Node {
        Node[] children;
        boolean eow;
        public Node(char ch){
            this.children=new Node[LENGTHOFCHILDREN];
            this.eow=false;
        }
        public Node(){

        }
    }

    public Trie() {
        root = new Node();
        root.children = new Node[LENGTHOFCHILDREN];
    }

    public void add(String val){
        Node node=root;
        for(int i =0;i<val.length();i++){
            char ch=val.charAt(i);
            if(node.children[ch-'a']==null){
                Node n=new Node(ch);
                node.children[ch-'a']=n;

            }
            node=node.children[ch-'a'];
        }
        node.eow=true;

    }
    public boolean find(String val){
        Node node=root;
        for(int i = 0 ; i<val.length();i++){
            char ch=val.charAt(i);
 
            if(node.children[ch-'a']==null){
                return false;
            }
            node=node.children[ch-'a'];
        }
        return node.eow;


    }
    public void display(){
        display(root,"");
    }

    private void display(Node node, String asf) {
        if(node==null)
            return;
            if (node.eow) {
                System.out.println(asf);
                
            }
            for(int i=0;i<node.children.length;i++){
                display(node.children[i],asf+(char)('a'+i));
            }
    }

}
