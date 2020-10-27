import java.util.*;

public class GroupShiftedAnagrams {
    static String getKey(String str){
        String key="";
        for(int i=1;i<str.length();i++){
            char ch1=str.charAt(i);
            char ch2=str.charAt(i-1);
            int diff=ch2-ch1;
            if(diff<0){
                diff+=26;
            }
            key+=diff+"#";
        }
        key+='.';
        return key;
    }
	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
	    HashMap<String,ArrayList<String>> map=new HashMap<>();
		for(int i=0;i<strs.length;i++){
		    String key=getKey(strs[i]);
		    if(!map.containsKey(key)){
		        map.put(key,new ArrayList<String>());
		    }
		    map.get(key).add(strs[i]);
		}
		ArrayList<ArrayList<String>> ans=new ArrayList<>();
		for(String key:map.keySet()){
		    ans.add(map.get(key));
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
