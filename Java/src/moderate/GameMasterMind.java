package moderate;

public class GameMasterMind {
	public static void game(char[] sol, char[] guess){
		int hit = 0, phit = 0;
		int rsol=0, ysol=0, gsol=0, bsol=0;
		int rg=0, yg=0, gg=0, bg=0;
		for(int i=0; i<sol.length; i++){
			if(sol[i] == guess[i])
				hit++;
			else{
				switch(sol[i]){
				case 'R': rsol++; break;
				case 'G': gsol++; break;
				case 'Y': ysol++; break;
				case 'B': ysol++; break;
				}
				switch(guess[i]){
				case 'R': rg++; break;
				case 'G': gg++; break;
				case 'Y': yg++; break;
				case 'B': yg++; break;
				}
			}
		}
		
		phit += Math.min(rsol, rg);
		phit += Math.min(gsol, gg);
		phit += Math.min(ysol, yg);
		phit += Math.min(bsol, bg);
		
		System.out.println("hits: "+ hit+ " and pseudo hits: "+phit);
	}
	
	public static void test(){
		char[] sol = {'R', 'G', 'B', 'Y'};
		char[] guess = {'G', 'G', 'R', 'R'};
		game(sol, guess);
	}
}
