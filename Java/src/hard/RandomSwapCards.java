package hard;

import java.util.Random;

public class RandomSwapCards {
	
	
	public static void test(){
		int[] cards = new int[52];
		for(int i=1; i<=52; i++)
			cards[i-1] = i;
		
		cards = swapcards(cards);
		for(int i=0; i<52; i++)
			System.out.print(cards[i] + "> ");
	}

	private static int[] swapcards(int[] cards) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		for(int i=0; i<52; i++){
			int t = rand.nextInt(52);
			int t1= cards[t];
			cards[t] = cards[i];
			cards[i] = t1;
		}
		return cards;
	}
}
