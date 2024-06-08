package numberguess;

import java.util.*;

public class guessnumber {
	public static void main(String[] args) {
		Random rand=new Random();
		int rnum=rand.nextInt(100)+1;
		System.out.println("WELCOME TO NUMBER GUESSING GAME");
		System.out.println("Random number is: "+rnum);
		//to find number of tries u took to find the correct guess
		int trycount=0;
		while(true) {
			System.out.println("Enter your guess(1-100):");
			Scanner sc=new Scanner(System.in);
			int playerguess=sc.nextInt();
			trycount++;
		
			if(playerguess==rnum) {
				System.out.println("Correct.. You Win!!");
				System.out.println("You took "+trycount+"tries ");
				System.out.println("End");
				break;
				
			}
			else if(rnum>playerguess) {
				System.out.println("Wrong.. The number is higher.");
				System.out.println("Guess again");
			}
			else {
				System.out.println("Wrong.. The number is lower.");
				System.out.println("Guess again");
			}
		}
	}
}
