package recursionAndDP;

public class CheckDuplicate {
	
	private static class BitSet{
		int[] bitset;
		BitSet(int size){
			bitset = new int[size>>5];
		}
		
		boolean get(int index){
			int word = (index >> 5);
			int bit = (index & 0x1F);
			return (bitset[word] & (1 << bit)) != 0;
		}
		
		void set(int index){
			int word = (index >> 5);
			int bit = (index & 0x1F);
			bitset[word] |= (1<<bit); 
		}
	}
	
	public static void checkDuplicate(int[] a){
		BitSet b = new BitSet(32000);
		for(int i=0; i<a.length; i++){
			int n = a[i] - 1;
			if(b.get(n))
				System.out.println(n+1);
			else
				b.set(n);
		}
		
	}
	
	public static void test(){
		int[] a = {1,2,4,4,5,2,8};
		checkDuplicate(a);
	}

}
