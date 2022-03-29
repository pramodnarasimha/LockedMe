package lockedmeass;

import java.io.IOException;
import java.util.Scanner;

public class subjectcode {

	private static final int a = 0;
	private static final int b = 0;
	private static final int c = 0;
	private static final int d = 0;
	Scanner scan = new Scanner(System.in);
	calloperations dao = new calloperations();

	public void introScreen() {
		System.out.println();
		System.out.println("*************************************************");
		System.out.println("      DEVELOPED BY PRAMOD VEDULA    ");
		System.out.println("*************************************************");
		System.out.println("               LOCKEDME.COM                    ");
		System.out.println("*************************************************");
		System.out.println("*   File location: " + welcome.path +"    *");
		System.out.println("*************************************************");
		System.out.println("\n\n");


	}

	public void exitScreen() {

		System.out.println("******THANK YOU******");


	}

	public void mainMenuOptions() {
		System.out.println("********  MAIN_MENU_PROMPT *******");
		System.out.println("\n");
		System.out.println(" Select any one of the following:- ");
	    System.out.println("  1 - List of user files            ");
	    System.out.println("  2 - Add or Delete or Search Files");
	    System.out.println("  3 - Quit Application         ");
		System.out.println("\n***********************************\n");
	    System.out.println("Please enter your option:- ");
	}

	public void subMenuOptions() {

		System.out.println("\n");
		System.out.println("********* SECONDARY MENU PROMPT  *******");
		System.out.println("\n");
		System.out.println("| Select any one of the following:  |");
	    System.out.println("   1 - Add a file                  ");
	    System.out.println("   2 - Delete a file               ");
	    System.out.println("   3 - Search a file               ");
	    System.out.println("   4 - Go Back                     ");
		System.out.println("\n***********************************\n");
	    System.out.println("Enter your option :- ");

	}

	

	public void subMenu() {
		String file = null;
		String fileName = null;
		int choice = 0;

		do {

			subMenuOptions();

			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Oops! Invalid input");
				System.out.println("Please enter valid inputs");				
				subMenu();
			}


			switch (choice) {
			case 1: 
					System.out.println("\n==> Adding a File in the Application...");
					System.out.println("Please enter a file name to be added :- ");
					file = scan.nextLine();
					fileName = file.trim();
					try {
						dao.createNewFile(welcome.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println("Error occurred while adding..");
					}catch(Exception e) {
						System.out.println("Error occurred while adding ..");
					}
					System.out.println("\n**********************************\n");
					break;

			case 2: 
					System.out.println("\n==> Deleting a File in the Application...");
					System.out.println("Please enter a file name to be Delete : ");
					file = scan.nextLine();
					fileName = file.trim();
					try {
						dao.deleteFile(welcome.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println("Error occurred while Deleting.");
					}catch(Exception e) {
						System.out.println("Error occurred while Deleting File..");
					}
					System.out.println("\n***********************************\n");
					break;

			case 3: 
					System.out.println("\n==> Searching a File...");
					System.out.println("Please enter a file name to Search : ");
					file = scan.nextLine();
					fileName = file.trim();
					try {
						dao.searchFile(welcome.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\n***********************************\n");
					break;
			case 4: mainMenu();
					break;

			default:
				System.out.println("Oops!! invalid output... ");
				subMenu();

			}

		file = null;
		fileName = null;

		}while(true);

	}



public void mainMenu() {

	int choice = 0;
	char decision = 0;
	do {

		mainMenuOptions();

		try {
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("\nInvalid Input \nPlease select options between:(1-3)\n");
			mainMenu();
		}


		switch (choice) {

		case 1:
				System.out.println();
				try {
					dao.listAllFiles(welcome.path);
				}catch(NullPointerException e) {
					System.out.println(e.getMessage());
				}catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n***********************************\n");
				break;

		case 2: 
				System.out.println();
				subMenu();
				break;

		case 3: 
				System.out.println("\n Are you sure you want to exit ? ");
				System.out.println("  (Y) ==> Yes    (N) ==> No        ");
				decision =  scan.nextLine().toUpperCase().charAt(0);
				if(decision == 'Y') {
					System.out.println("\n");
					exitScreen();
					System.exit(1);
				}else if(decision == 'N') {
					System.out.println("\n");
					mainMenu();
				}else {
					System.out.println("\nInvalid Input \nValid Inputs :(Y/N)\n");
					mainMenu();
				}


		default:
				System.out.println("Oops!! invalid output... ");
				mainMenu();

		}


	}while(true);

}
}
