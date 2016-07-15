package hard;

import java.util.ArrayList;
import java.util.HashMap;

public class MinDistancebetweenWords {
	private class words{
		@SuppressWarnings("unused")
		ArrayList<Integer> a;
	}
	
	HashMap<String, words> h = new HashMap<String, words>();
	
	void addwords(String w){
		/*logic to add words to hashlist with key string and add all the starting
		* positions to the arraylist
		*/
	}
	
	void returnShortDistance(String w1, String w2){
		/* here we look both words in hashmap and get their respective arraylists
		 * and hence lists are sorted we can get minimum distance in O(size of list)
		 */
	}
	
}
