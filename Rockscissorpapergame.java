package numberguess;
import java.util.*;
public class rockpapergame {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			String[] rps= {"r","p","s"};
			String computermove=rps[new Random().nextInt(rps.length)];
			String playermove;
			
			while(true) {
				System.out.println("Plz enter your move..(r,p or s)");
				playermove=sc.nextLine();
				if(playermove.equals("r")||playermove.equals("s")||playermove.equals("p")) {
					break;
				}
				System.out.println(playermove+" is not a valid move. ");
			}
			System.out.println("Computer played: "+computermove);
			if(playermove.equals(computermove)){
				System.out.println("The game was a tie.");
			}
			else if(playermove.equals("r")){
				if(computermove.equals("p")) {
					System.out.println("You lose ...");
				}
				else if(computermove.equals("s")) {
					System.out.println("You win...");
				}
			}
			else if(playermove.equals("p")){
				if(computermove.equals("r")) {
					System.out.println("You win...");
				}
				else if(computermove.equals("s")) {
					System.out.println("You lose...");
				}
			}
			
			else if(playermove.equals("s")) {
				if(computermove.equals("p")) {
					System.out.println("You win...");
				}
				else if(computermove.equals("r")) {
					System.out.println("You lose...");
				}
			}	
			System.out.println("----------------------");
			System.out.println("Do you want to play again(y/n)");
			String play=sc.nextLine();
			if(!play.equals("y")){
				break;
			}
			
	}
	sc.close();

}
}
