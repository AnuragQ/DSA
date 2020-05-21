package hashmap;

import java.util.HashMap;

public class CountCharacteOccurances {
    public static void main(String[] args) {
        String str = "aavdddgssee";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : str.toCharArray()) {
            System.out.println(ch);



        }
        hm.put('a', 1);
    }
}