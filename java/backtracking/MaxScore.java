import java.io.*;
import java.util.*;

public class MaxScore {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		//write your code here
		if(idx==words.length){
		    return 0;
		}
		
		
		int max_score=Integer.MIN_VALUE;
		
		max_score=Math.max(max_score,solution(words,farr,score,idx+1));
		
		String curWord=words[idx];
		int my_score=0;
		for(int i=0;i<curWord.length();i++){
		    if(farr[curWord.charAt(i)-'a']==0){
		        return max_score;
		    }else{
		        farr[curWord.charAt(i)-'a']--;
		        my_score+=score[curWord.charAt(i)-'a'];
	       }
	       
		}
		return my_score+max_score;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}