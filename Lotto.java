import java.util.Scanner;
import java.util.InputMismatchException;
//=============================================================================
public class Lotto {
//-----------------------------------------------------------------------------
	private static Scanner keyboard = new Scanner(System.in);
//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		
		int digits = 0, smallest = 0, largest = 0;
		char choice;
		boolean success;
		
		do {
			
			digits = getNumber("How many play numbers? : ");
			smallest = getNumber("What is the smallest playable number? : ");
			largest = getNumber("What is the largest playable number? : ");
			
			//Creates array with length equal to amount of play numbers.
			int[] numbers = getLottoNumbers(digits, smallest, largest);
			
			// Prints Lotto numbers
			printLottoNumbers(numbers, digits);
			
			//Asks if user wants to print more numbers.
			System.out.println();
			System.out.print("Play another ticket? (Y or N) : ");
			choice = Character.toUpperCase(keyboard.next().charAt(0));
			System.out.println();
			
			while (choice != 'N' && choice != 'Y') {
				System.out.print("Please enter a proper response (Y or N): ");
				choice = Character.toUpperCase(keyboard.next().charAt(0));
				System.out.println();
			}
		} while (choice != 'N');
		
		System.out.print("I hope you win something!");
	}
//-----------------------------------------------------------------------------
	/**
	 * 
	 * @return Returns user's number input
	 * @author Sherman Hewitt
	 */
	private static int getNumber(String prompt) {
		boolean success;
		int number = 0;
		
		// Prompts user for number. Exception/While loop 
		// catches inputs that aren't proper integers.
		success = false;
		while (!success) {
			try {
				System.out.print(prompt);
				number = keyboard.nextInt();
				success = true;
			} catch (InputMismatchException e) {
				keyboard.nextLine();
			} catch (NumberFormatException e) {
				keyboard.nextLine();
			}
		}
		
		return number;
	}
//-----------------------------------------------------------------------------
	private static int[] getLottoNumbers(int digits, int small, int large) {
		int[] lottoNumbers = new int[digits];
		
		// Populates array with lottery numbers.
		for (int i = 0; i < digits; i++) {
			lottoNumbers[i] = numberGenerator(small, large);
		}
		
		return lottoNumbers;
	}	
//-----------------------------------------------------------------------------
	private static int numberGenerator(int small, int large) {
		//Range sets Math.random's [0,1) range to the range needed for the
		//lotto numbers.
		int range = large - small;
		
		return (int)((Math.random() * range) + small);
	}
//-----------------------------------------------------------------------------
	private static void printLottoNumbers(int[] lottoNumbers, int digits) {
		// Loops through array to print lotto numbers.
		for (int i = 0; i < digits; i++) {
			System.out.print(lottoNumbers[i] + " ");
		}
	}
//-----------------------------------------------------------------------------
}
//=============================================================================