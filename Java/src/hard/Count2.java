package hard;

public class Count2 {
	public static int count2(int n){
	
		int count = 0;
		
		int i = 0, j = 1;
		int t = n;
		
		while(t > 0){
			int p = t%10;
			if(p < 2){
				count += p*i;
			}
			else if(p == 2){
				count += p*i + n%j + 1;
			}
			else{
				count += p*i + j;
			}
			
			t /= 10;
			i = i*10 + j;
			j *= 10;
		}
		return count;			
	}
	
	static int basiccount(int n){
		int count = 0;
		for(int i=1; i<= n; i++)
			count+= countbydigit(i);
		return count;
	}
	
	static int countbydigit(int n){
		int c = 0;
		while(n > 0){
			if(n%10 == 2)
				c++;
			n /= 10;
		}
		return c;
	}
	
	public static void test(){
		System.out.println(count2(19273));
		System.out.println(basiccount(19273));
	}
}
