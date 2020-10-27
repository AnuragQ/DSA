import java.util.*;

public class AnagramMappings {
    
    static class Pair{
        int idx;
        ArrayList<Integer> arr;
        Pair(){
            arr=new ArrayList<>();
            idx=0;
        }
    }
    
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
	    HashMap<Integer,Pair> map=new HashMap<>();
	    for(int i=0;i<arr2.length;i++){
	        int elem=arr2[i];
	        if(!map.containsKey(elem)){
	            map.put(elem, new Pair());
	        }
	        map.get(elem).arr.add(i);
	    }
	    int[] ans=new int[arr1.length];
	    
	    for(int i=0;i<arr1.length;i++){
	        int elem=arr2[i];
	        Pair p=map.get(elem);
	        ans[i]=p.arr.get(p.idx);
	        p.idx++;
	    }
	    return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
