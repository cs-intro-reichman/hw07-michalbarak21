
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		
		// System.out.println(tail("word"));
		// System.out.println(tail("live"));
		// System.out.println(tail("alive"));

		// System.out.println(levenshtein("hello", "hell"));
		// System.out.println(levenshtein("hello", "hell0"));
		// System.out.println(levenshtein("love", "i"));
		// System.out.println(levenshtein("concensus", "consensus"));

	}

	public static String tail(String str) {
		/// this function returns a substring of the input word without the first letter
		int n = str.length(); 
		return (str.substring(1, n));  
	}

	public static int levenshtein(String word1, String word2) {
		// As an initial step we want to assert that both words are lowercase, so our program will not be case sensitive 
		word1 = word1.toLowerCase(); 
		word2 = word2.toLowerCase(); 

		// First we want to check if word1 is empty- then we will need to insert all the letters of word2
		if (word1.isEmpty()) {
			return word2.length();
		}
		// Next  we want to check if word2 is empty- then we will need to insert all the letters of word1
		if (word2.isEmpty()) {
			return word1.length();
		}
		// Now we will check whether the first character of each word matches. 
		// If it does, no edits are needed and we can move on to the next char
		if (word1.charAt(0) == word2.charAt(0)) {
			String nxt_word1 = tail(word1); 
			String nxt_word2 = tail(word2);
			return(levenshtein(tail(word1), tail(word2))); 
		}
		// If the first letters of both words do not match we need to make an edit- insertion, deletion or substitution
		// Since we want to choose the minimal amount of edits, we will then create 3 different scenarions that equivalent our edit
		// and choose the scenario returning the minimal number
		return 1 + Math.min(levenshtein(tail(word1), word2), Math.min(levenshtein(word1, tail(word2)), levenshtein(tail(word1), tail(word2)))); 

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		/// We will create a loop that goes over our dictionary, and inputs each line of dictionary txt in a 
		/// cell of the array 
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readLine(); 
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) { 
		String ans = "";
		for (int i = 0; i < dictionary.length; i++) {
			int num = levenshtein(word, dictionary[i]); 
			if (num > threshold) {

			} else {
				if (levenshtein(word, dictionary[i]) <= levenshtein(word, ans)) {
					ans = dictionary[i]; 
				}
			}
		}
		if (ans.isEmpty()) {
			return word; 
		}
		return ans; 
	}

}
