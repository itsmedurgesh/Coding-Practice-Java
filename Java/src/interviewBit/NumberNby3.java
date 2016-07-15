package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberNby3 {
	public static void findmax(final List<Integer> a) {
		int p = -1, cp = 0;
		int q = -1, cq = 0;
		
		for(int i=0; i<a.size(); i++){
			
			if(cp != 0 && p == a.get(i)){
				cp++;
				continue;
			}
						
			if(cq != 0 && q == a.get(i)){
				cq++;
				continue;
			}
			
			if(cp == 0){
				p = a.get(i);
				cp = 1;
				continue;
			}
					
			if(cq == 0){
				q = a.get(i);
				cq = 1;
				continue;
			}
			
			cp--;
			cq--;
		}
		
		
		int c1 = 0, c2=0;
		for(int i = 0; i<a.size(); i++){
		    if(a.get(i) == p)
		        c1++;
		    if(a.get(i) == q)
		        c2++;
		}
		
		if(c1 > a.size()/3)
			System.out.println("max is : "+p + " cp is: "+cp);
		else if(c2 > a.size()/3)
			System.out.println("max is : "+q +" cq is: "+cq);
		else 
			System.out.println("none");
				
	}
	
	public static void test(){
		List<Integer> a = new ArrayList<Integer>();
		Integer[] p = {1000727, 1000727, 1000641, 1000517, 1000212, 
				1000532, 1000727, 1001000, 1000254, 1000106, 1000405, 
				1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 
				1000713, 1000727, 1000333, 1000069, 1000727, 1000877, 
				1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 
				1000727, 1000727, 1000508, 1000475, 1000727, 1000573, 
				1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 
				1000727, 1000727, 1000426, 1000547, 1000727, 1000972, 
				1000575, 1000303, 1000727, 1000533, 1000669, 1000489, 
				1000727, 1000329, 1000727, 1000050, 1000209, 1000109};
		a.addAll(Arrays.asList(p));
		findmax(a);
	}
}
