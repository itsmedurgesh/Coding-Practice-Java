package moderate;

public class MaxWithoutComp {
	public static int max(int a, int b){
		byte signa = (byte) ((a>>31)&0x1);
		byte signb = (byte) ((b>>31)&0x1);
		byte signa_b = (byte) (((a-b) >> 31) & 0x1);
		byte usesigna = (byte) (signa ^ signb);
		byte usesigna_b = (byte) (usesigna ^ 1);
		byte sign = (byte) (usesigna * signa + usesigna_b * signa_b);
		int flip = sign ^ 1;
		return flip*a + sign*b;
	}
	
	public static void test(){
		System.out.println(max(23,44));
	}
}
