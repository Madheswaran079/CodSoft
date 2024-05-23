package NumberGame;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("The game has 10 rounds\nYou have 10 guesses in the first round");
		System.out.println("The total number of guesses will be keep on reducing in upcoming rounds");
		System.out.println("If the guessed number is too low or too high, the difference between them is more than 5\n\n");
		int num, round = 1, guess = 10, random, points = 0;
		String choice;
		boolean lost = false;
		while(true) {
			System.out.println("Round - " + round + "\n");
			random = (int)(Math.random() * 100) + 1;
			while(true) {
				System.out.println("Enter the guessed number : ");
				num = sc.nextInt();
				if(num == random) {
					System.out.println("Your guess is correct");
					System.out.println("Round - " + round + " cleared");
					System.out.println("Points scored " + (guess*2) + " ");
					System.out.println("---------------");
					points += guess*2;
					break;
				}
				else if(num < random) {
					if(num+5 < random) System.out.println("Your guess is too low");
					else System.out.println("Your guess is low");
				}
				else {
					if(num-5 > random) System.out.println("Your guess is too high");
					else System.out.println("Your guess is high");
				}
				System.out.println(--guess + " guesses left\n");
				if(guess == 0) {
					System.out.println("You lost the game");
					lost = true;
					break;
				}
			}
			if(!lost) {
				System.out.println("Do you want to continue the game ? Yes/No");
				choice = sc.next();
				System.out.println();
				if(choice.equals("Yes")) {
					guess = 10-round;
					round++;
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
		System.out.println("Total points : " + points);
		
		sc.close();
	}
}
