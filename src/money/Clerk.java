package money;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Clerk {

	static Scanner in = new Scanner(System.in);

	static float cost;
	static float cash;
	static float changeDue;
	static String change;
	static String answer;
	
	static DecimalFormat f = new DecimalFormat("##.##");

	static int pennies;
	static int nickels;
	static int dimes;
	static int quarters;
	static int ones;
	static int fives;
	static int tens;
	static int twenties;

	public static void main(String[] args) {

		customerCheckOut();

	}

	//Initial user interaction is handled here
	public static void customerCheckOut() {
		System.out.println("Do you want to ring up an item? y or n. n cancels this transaction\n");
		answer = in.next();

		if (answer.equalsIgnoreCase("n")) {
			System.out.println("Thank you for shopping, goodbye!\n");
			return;
		}else if(answer.equalsIgnoreCase("y")){
			ringUp();
		} else{
			System.out.println("That answer is not reconized, please try again.\n");
			customerCheckOut();
		}

	}

	//This method will decide how many of each unit of currency
	//that the customer will be given as change
	public static void changeMaker() {
		
		if (changeDue - 20 >= 0) {
			twenties += (int) (changeDue / 20);
			changeDue -= 20 * twenties;
			
			changeMaker();

		} else if (changeDue - 10 >= 0) {
			tens = (int) (changeDue / 10);
			changeDue -= 10 * tens;
			
			changeMaker();

		} else if (changeDue - 5 >= 0) {
			fives = (int) (changeDue / 5);
			changeDue -= 5 * fives;
			
			changeMaker();

		} else if (changeDue - 1 >= 0) {
			ones = (int) changeDue;
			changeDue -= (int) changeDue;
			
			changeMaker();

		} else if (changeDue - .25 >= 0) {
			quarters = (int) (changeDue / .25);
			changeDue -= .25 * quarters;
			
			changeMaker();

		} else if (changeDue - .1 >= 0) {
			dimes = (int) (changeDue /.1);
			changeDue -= .1 * dimes;
			
			changeMaker();

		} else if (changeDue - .05 >= 0) {
			nickels = (int) (changeDue / .05);
			changeDue -= .05 * nickels;
			
			changeMaker();

		} else{ 
			pennies = (int)(changeDue*101); //*101 due to inaccuracy with math with doubles
			
		}
		

	}

	//This method handles the addition of items to the user's cart
	//and transaction cancellation.
	public static void ringUp() {
		System.out.println("Enter the price of your item.\n");

		cost += in.nextDouble();
		in.nextLine();

		System.out.println("Do you want to add another item? y or n\n");

		answer = in.next();

		if (answer.equalsIgnoreCase("y")) {
			ringUp();

		} else if (answer.equalsIgnoreCase("n")) {
			payUp();
			System.out.println("Your change is $" + change + " and is paid out in: \n");
			printChange();

		} else {
			System.out.println("I did not reconize your choice, please try again.\n ");
			customerCheckOut();
		}
	}

	//Handles the customer paying. Will handle transactions
	//whether or not the customer has enough money
	public static void payUp() {

		System.out.println("Your total comes to $" + cost + " \n \n" + "Enter the amount that you are paying with.\n");
		cash = in.nextFloat();

		if (cash < cost) {
			System.out.println("$" + cash + " is not enough to pay your bill. Would you like to try again? y or n\n");
			answer = in.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("Thank you for shopping, goodbye!\n");
				return;
			}

		} else {
			changeDue = cash - cost;
			String temp = f.format((double)changeDue);
			changeDue = (float)Double.parseDouble(temp);
			change = ""+changeDue;
			changeMaker();
		}

	}
	
	public static void printChange() {

		if (pennies > 0) {
			System.out.print("Pennies: "+ pennies+" - ");
		} 
		if (nickels > 0) {
			System.out.print("Nickels: "+ nickels+" - ");
		}
		if (dimes > 0) {
			System.out.print("Dimes: "+ dimes+" - ");
		}
		if (quarters > 0) {
			System.out.print("Quarters: "+ quarters+" - ");
		}
		if (ones > 0) {
			System.out.print("Ones: "+ ones+" - ");
		}
		if (fives > 0) {
			System.out.print("Fives: "+ fives+" - ");
		}
		if (tens > 0) {
			System.out.print("Tens: "+ tens+" - ");
		} 
		if (twenties> 0){
			System.out.print("Twenties: "+ twenties+" - ");			
		}
		
	}

}
