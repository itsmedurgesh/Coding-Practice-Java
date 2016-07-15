package cormen;

/** this implementation uses redix sort to set of strings 
 *  with using counting sort as underlying sorting algorithm
 * @author dc
 *
 */
public class RedixSort {
	/** this is pass sorting the array based on column index for the alphabet and this 
	 * has been applied repeatedly to fully sort
	 * O(n*width)
	 * @param ss
	 * @param idx
	 * @return returns the new sorted copy of the array
	 */
	public static String[] countingSort(String[] ss, int idx){
		int[] c = new int[26];
		String[] ss1 = new String[ss.length];
		
		for(int i=0; i<26; ++i)
			c[i] = 0;
		
		for(int i=0; i<ss.length; ++i)
			++c[(int)ss[i].charAt(idx) - (int)'A'];
		
		for(int i=1; i<26; ++i)
			c[i] += c[i-1];
		
		for(int i = ss.length-1; i>-1; --i){
			ss1[c[(int)ss[i].charAt(idx)-(int)'A']-1] = ss[i];
			--c[(int)ss[i].charAt(idx)-(int)'A'];
		}
		
		return ss1;
	}
	
	public static String[] sort(String[] ss, int width){
		for(int i = width-1; i>-1; --i)
			ss = countingSort(ss, i);
		return ss;		// adding return statement because change is not reflected as it is pass by value
	}
	
	public static void test(){
		String[] ss = {"COW", "DOG", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB",
				"BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};
		ss = sort(ss, 3);
		
		for(String s: ss)
			System.out.println(s);
	}
}
