import java.util.Scanner;
import java.util.InputMismatchException;
//=============================================================================
public class Lotto {
//-----------------------------------------------------------------------------
	private static Scanner keyboard = new Scanner(System.in);
//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		
		int digits = 0, smallest = 0, largest = 0, range, index;
		char choice;
		boolean success;
		
		do {
			
			digits = getNumber("How many play numbers? : ");
			
			smallest = getNumber("What is the smallest playable number? : ");
			
			largest = getNumber("What is the largest playable number? : ");
			
			//Creates array with length equal to amount of play numbers.
			int[] numbers = new int[digits];
			
			//Range sets Math.random's [0,1) range to the range needed for the
			//lotto numbers.
			range = largest - smallest;
			
			for (index = 0; index < numbers.length; index++) {
				numbers[index] = (int)((Math.random() * range) + smallest);
				if (digits == 6) {
					//If the largest number is 59, the Powerball lotto is
					//assumed, keeping the last digit in Powerball's range.
					if (largest == 59) {
						if (numbers[numbers.length-1] > 39) {
							numbers[numbers.length-1] = 
									numbers[numbers.length-1]/4;
						}
					}
					//If the largest number is 59, the Mega Million lotto is
					//assumed, keeping the last digit in Mega ball's range.
					if (largest == 75) {
						if (numbers[numbers.length-1] > 15) {
							numbers[numbers.length-1] = 
									numbers[numbers.length-1]/5;
						}
					}
				}
				//Prints the lotto numbers.
				System.out.print(numbers[index] + " ");
			}
			
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
		
		// Prompts user for starting number. Exception/While loop 
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
}
//=============================================================================