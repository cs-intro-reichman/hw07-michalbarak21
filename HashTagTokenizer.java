

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		/// System.out.println(dictionary[0]);
		/// System.out.println(dictionary[500]);
		/// System.out.println(dictionary[2999]);

		/// System.out.println(existInDictionary("a", dictionary));
		/// System.out.println(existInDictionary("A", dictionary));
		/// System.out.println(existInDictionary("Love", dictionary));
		/// System.out.println(existInDictionary("COLOnial", dictionary));
		/// System.out.println(existInDictionary("recursion", dictionary)); 

		breakHashTag("iloverecursion", dictionary);
		breakHashTag("iloveuniversity", dictionary);

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

	public static boolean existInDictionary(String word, String []dictionary) {
		/// First we will covert the input string to be all lowercase 
		/// Next we will create a loop that that goes over our dictionary array, and checks whether the input word 
		/// matches a word in the dictionary:
		/// If it does- return true and exit the function
		/// If it doesn't - we will go over all of the words and after the loop we will return our default answer- false 
		
		word = word.toLowerCase();
		for (int i = 0; i < dictionary.length; i++) {  
			if (word.equals(dictionary[i])) {
				return true; 
			}
		}
		return false; 
		
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
  
        int N = hashtag.length();
		String word = hashtag.substring(0, 1); 
		
		/// First we will check if the current substring is a word
		/// If it is, we would like to print it and search for a different word from the remaining substring 
		/// After finding valid substring, we want to break from the loop   
        
		for (int i = 1; i <= N; i++) {
			String currentPrefix = hashtag.substring(0, i);
			if (existInDictionary(currentPrefix, dictionary)) {
				System.out.println(currentPrefix);
				String new_word = hashtag.substring(i, N);
				breakHashTag(new_word, dictionary);
				break;
			} 
		
        }
    }

}
