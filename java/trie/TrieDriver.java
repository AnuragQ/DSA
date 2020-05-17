

public class TrieDriver {
    public static void main(String[] args) {
        Trie t=new Trie();
        
        String[] wordArray={"apple","ape","man","mango"};
        for(String word:wordArray){
            t.add(word);
        }
        t.display();
        System.out.println(t.find("apple"));
        System.out.println(t.find("appl"));
    }
}