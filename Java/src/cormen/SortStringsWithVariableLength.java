package cormen;
/** this program takes strings with variable length 
 * and then sorts them in lexicographical order
 * @author dc
 *
 */
public class SortStringsWithVariableLength {
	/** this uses variation of counting sort
	 * it maps every alphabet to an index of the array but leaving first place for
	 * absence of any alphabet i.e. string is shorter
	 * @param ss
	 * @param idx
	 * @return
	 */
	static String[] sort(String[] ss, int idx){

		int[] c = new int[27];	// 26 for the alphabets and one for the no alphabet at that index
		String[] ss1 = new String[ss.length];
		
		for(int i=0; i<27; ++i)
			c[i]=0;
		
		for(int i=0; i<ss.length; ++i){
			if(idx < ss[i].length())
				++c[(int)ss[i].charAt(idx)-(int)'a'+1];
			else
				++c[0];
		}
		
		for(int i=1; i<27; ++i)
			c[i] += c[i-1];
		
		for(int i = ss.length-1; i>-1; --i){
			if(idx < ss[i].length()){
				ss1[c[(int)ss[i].charAt(idx)-(int)'a' + 1]-1] = ss[i];
				--c[(int)ss[i].charAt(idx)-(int)'a' + 1];
			}				
			else{
				ss1[c[0]-1] = ss[i];
				--c[0];
			}				
		}
		
		return ss1;
		
	}
	
	public static String[] sortall(String[] ss, int width){
		for(int i = width-1; i>-1; --i)
			ss = sort(ss, i);
		return ss;		// adding return statement because change is not reflected as it is pass by value
	}
	
	public static void test(){
		String[] ss = {"ab",
				"a",
				"b",
				"aaa",
				"aa",
				"dsfs",
				"baaa"};
		ss = sortall(ss, 4);
		
		for(String s: ss)
			System.out.println(s);	
	}
}
