package money;

import java.util.Scanner;

public class Clerk {

	static Scanner in = new Scanner(System.in);
	
	static double cost;
	static double cash;
	
	static String answer;
	
	static int pennies;
	static int nickels;
	static int dimes;
	static int quarters;
	static int dollars;
	static int fives;
	static int tens;
	static int twenties;
	static int fifties;
		
		
	public static void main(String[] args) {
		
		customerCheckOut();

	}
	
	public static void customerCheckOut(){
		System.out.println("Enter the price of your item.");
		
		cost += in.nextDouble();
		in.nextLine();
		
		System.out.println("Do you want to add another item?");
		
		answer = in.next();
		
	}
	
	public static void changeMaker(){
		
		
	}
	
	public static void 

}
