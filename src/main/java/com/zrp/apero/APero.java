package com.zrp.apero;
import java.util.Scanner;


public class APero {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.displayMainMenu();
	}
	
	private static void Controls2(Scanner uI) {
		System.out.println("CONTROLS");
		System.out.println("---------");
		System.out.println("There are 2 types of controls:");
		System.out.println("wsda and 2468");
		System.out.println("wsda is (or at least should) be on your keypad");
		System.out.println("w is North");
		System.out.println("s is South");
		System.out.println("d is East");
		System.out.println("and a is West");
		System.out.println("+++++++++++++");
		System.out.println("2468 controls are meant to be used if you have a number pad.");
		System.out.println("8 is North");
		System.out.println("2 is South");
		System.out.println("6 is East");
		System.out.println("and 4 is West");
		Options(uI);
	}
	
//	private static void mainMenu() {
//		System.out.println("MAIN MENU");
//		System.out.println("---------");
//		System.out.println("Type 1 for profiles");
//		System.out.println("Type 2 for options");
//		Scanner uI = new Scanner(System.in);
//		String answer = uI.next();
//		
//		if (answer.equalsIgnoreCase("1")) {
//			
//			pg1(uI);
//			
//		} else if (answer.equalsIgnoreCase("2")) {
//			
//			Options(uI);
//			
//		} else {
//			
//		}
//	}
	
	private static void Options(Scanner uI) {
		System.out.println("OPTIONS");
		System.out.println("---------");
		System.out.println("Type 1 to go back");
		System.out.println("Type 2 to change controls");
		String answer = uI.next();
		
		if (answer.equalsIgnoreCase("1")) {
			
//			mainMenu();
			
		} else if (answer.equalsIgnoreCase("2")) {
			
			Controls(uI);
			
		} else {
			
		}
	}
	
	private static void Controls(Scanner uI) {
		System.out.println("CONTROLS");
		System.out.println("---------");
		System.out.println("There are two types of controls:");
		System.out.println("Type 1 to change to wsda controls");
		System.out.println("Type 2 to change to 2468 controls");
		System.out.println("Type 3 to learn what the controls are");
		System.out.println("Type 4 to go back");
		String answer = uI.next();
		
		int Controls = 1;
		
		if (answer.equalsIgnoreCase("1")){
			
			Controls = 1;
			Options(uI);
			
		} else if (answer.equalsIgnoreCase("2")){
			
			Controls = 2;
			Options(uI);
			
		} else if (answer.equalsIgnoreCase("3")){
			
			Controls2(uI);
			
		} else if (answer.equalsIgnoreCase("4")){
//			mainMenu();
		} else {
			
		}
	}

	private static void pg1(Scanner uI){
		
//		if (pg1Message == 1) {
//		
//		System.out.println("A voice says \"Meet me at the temple!\"");
//		
//		}
	}
	
//	public static void main(String[] args) {
//		int pg1Message = 1;
//		int Controls = 1;
//		mainMenu();
//	}
}
