// Assignment #: ASU Fall 2022 #7
//         Name: Matt Carlson
//    StudentID: 124917226
//      Lecture: T - Th 10:30 - 11:45
//  Description: The Assignment 7 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. //--- is where you need to add your own code.


// DONE
import java.io.*;

public class Assignment7
{
	public static void main(String[] args) throws FileNotFoundException {
		char input1;
		String companyName, numOfEmployeesStr, nameOfCEO;
		String street, city, state;
		String address;
		int numOfEmployees;

		boolean operation = false;
		int operation2 = 0;
		String line;
		String filename;

		// create a CompanyManagement object. This is used throughout this class.
		CompanyManagement companyManage1 = new CompanyManagement();

		File file;

		try {
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System. in );
			BufferedReader stdin = new BufferedReader(isr);

			do {
				System.out.print("\nWhat action would you like to perform?\n");
				line = stdin.readLine().trim(); //read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) //check if a user entered only one character
				{
					switch (input1) {
					case 'A':
						//Add Company
						System.out.print("Please enter the company information:\n");
						System.out.print("Enter its name:\n");
						companyName = stdin.readLine().trim();
						System.out.print("Enter its number of employees:\n");
						numOfEmployeesStr = stdin.readLine().trim();
						numOfEmployees = Integer.parseInt(numOfEmployeesStr);
						System.out.print("Enter its CEO name:\n");
						nameOfCEO = stdin.readLine().trim();
						System.out.print("Enter its street info.:\n");
						street = stdin.readLine().trim();
						System.out.print("Enter its city info.:\n");
						city = stdin.readLine().trim();
						System.out.print("Enter its state info.:\n");
						state = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company is added successfully, show
"Company added\n" on screen, otherwise show "Company NOT added\n"
***********************************************************************************/
						if (companyManage1.addCompany(companyName, numOfEmployees, nameOfCEO, street, city, state)) {
							System.out.print("Company added\n"); // will attempt to add a company to the list with user given info
						} else {
							System.out.print("Company NOT added\n");
						}
						break;
					case 'C':
						//Create a new company management
						companyManage1 = new CompanyManagement();
						break;
						//*****
					case 'D':
						//Search by company name and address
						System.out.print("Please enter the company name to search:\n");
						companyName = stdin.readLine().trim();
						System.out.print("Please enter the company address to search:\n");
						address = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company with above name and address is found
show companyName + " at " + address + " is found\n"; otherwise show
companyName + " at " + address + " is NOT found\n"
***********************************************************************************/
						if (companyManage1.companyExists(companyName, address) != -1) { // companyExists() will always return a number other than -1
							System.out.print(companyName + " at " + address + " is found\n"); // when a company is found
						} else {
							System.out.print(companyName + " at " + address + " is NOT found\n");
						}
						break;
					case 'E':
						//Search by address
						System.out.print("Please enter the street info. to search:\n");
						street = stdin.readLine().trim();
						System.out.print("Please enter the city info. to search:\n");
						city = stdin.readLine().trim();
						System.out.print("Please enter the state info. to search:\n");
						state = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company with above street, city, state info. is found
show "Address: " + street + ", " + city + ", " + state + " is found\n"; otherwise show
"Address: " + street + ", " + city + ", " + state + " is NOT found\n"
***********************************************************************************/
						if (companyManage1.addressExists(street, city, state) != -1) { // if address exists the output will be any number over 0
							System.out.print("Address: " + street + ", " + city + ", " + state + " is found\n");
						} else {
							System.out.print("Address: " + street + ", " + city + ", " + state + " is NOT found\n");
						}
						break;
					case 'L':
						//List companys
						System.out.print(companyManage1.listCompanies());
						break;

					case 'N':
/************************************************************************************
***  Complete the follwing statement. Sort by company names in alphabetical order
***********************************************************************************/
						companyManage1.sortByCompanyName();
						System.out.print("sorted by company names\n");
						break;

					case 'O':
/************************************************************************************
***  Complete the follwing statement. Sort by employee numbers
***********************************************************************************/
						companyManage1.sortByEmployeeNumbers();
						System.out.print("sorted by employee numbers\n");
						break;
					case 'P':
/************************************************************************************
***  Complete the follwing statement. Sort by company addresses
***********************************************************************************/
						companyManage1.sortByCompanyAddress();
						System.out.print("sorted by company addresses\n");
						break;
					case 'Q':
						//Quit
						break;
					case 'R':
						//Remove a company
						System.out.print("Please enter the company name to remove:\n");
						companyName = stdin.readLine().trim();
						System.out.print("Please enter the company address to remove:\n");
						address = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company with above name and address is found
remove it and show companyName + " at " + address + " is removed\n"; otherwise show
companyName + " at " + address + " is NOT removed\n"
***********************************************************************************/
						if (companyManage1.removeCompany(companyName, address)) {
							System.out.print(companyName + " at " + address + " is removed\n");
						} else {
							System.out.print(companyName + " at " + address + " is NOT removed\n");
						}
						break;
					case 'T':
						//Close CompanyManagement
						companyManage1.closeCompanyManagement();
						System.out.print("Company management system closed\n");
						break;
					case 'U':
						//Write Text to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						try {
							file = new File(filename);
							System.out.print("Please enter a string to write inside the file:\n");
							String s = stdin.readLine().trim() + "\n";
/************************************************************************************
***  Complete the follwing statement, write above string inside the relevant file
***********************************************************************************/
							PrintWriter pw = new PrintWriter(file);
							pw.println(s);
							pw.close();
							System.out.print(filename + " is written\n");
						}
						catch(IOException ioe)
						{
							System.out.print("Write string inside the file error\n");
						}
						break;
					case 'V':
						//Read Text from a File
						System.out.print("Please enter a file name to read from:\n");
						filename = stdin.readLine().trim();
						try {
							file = new File(filename);
/************************************************************************************
***  Complete the follwing statement, read from above text file
***********************************************************************************/
							BufferedReader br = new BufferedReader(new FileReader(file));
							System.out.print(filename + " was read\n");
							System.out.print("The first line of the file is:\n" + br.readLine() + "\n");
							br.close();
						}
						catch(FileNotFoundException fnf) {
							System.out.print(filename + " not found error\n");
						}
						catch(IOException ioe) {
							System.out.print("Read string from the file error\n");
						}
						break;
					case 'W':
						//Serialize CompanyManagement to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						try {
/************************************************************************************
***  Complete the follwing statement, write object companyManage1 inside the data file
***********************************************************************************/
							file = new File(filename);
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(companyManage1);
						}
						catch(NotSerializableException nse) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException ioe) {
							System.out.print("Data file written exception\n");
						}
						break;
					case 'X':
						//Deserialize CompanyManagement from a File
						System.out.print("Please enter a file name to read from:\n");
						filename = stdin.readLine().trim();
						try {
/************************************************************************************
***  Complete the follwing statement, read object from the data file and save the object
as companyManage1
***********************************************************************************/
							file = new File(filename);
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
							companyManage1 = (CompanyManagement) ois.readObject();
							System.out.print(filename + " was read\n");
						}
						catch(ClassNotFoundException cnf) {
							System.out.print("Class not found exception\n");
						}

						catch(NotSerializableException nse) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException ioe) {
							System.out.print("Data file read exception\n");
						}
						break;
					case '?':
						//Display Menu
						printMenu();
						break;
					default:
						System.out.print("Unknown action\n");
						break;
					}
				}
				else {
					System.out.print("Unknown action\n");
				}
			} while ( input1 != 'Q' || line . length () != 1);
		}
		catch(IOException exception) {
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" +
						 "------\t\t------\n" +
						 "A\t\tAdd a company\n" +
						 "C\t\tCreate a CompanyManagement\n" +
						 "D\t\tSearch a company\n" +
						 "E\t\tSearch by address\n" +
						 "L\t\tList companies\n" +
						 "N\t\tSort by company names\n" +
						 "O\t\tSort by company employee numbers\n" +
						 "P\t\tSort by company address\n" +
						 "Q\t\tQuit\n" +
						 "R\t\tRemove a company\n" +
						 "T\t\tClose CompanyManagement\n" +
						 "U\t\tWrite strings to a text file\n" +
						 "V\t\tRead strings from a text file\n" +
						 "W\t\tSerialize CompanyManagement to a data file\n" +
						 "X\t\tDeserialize CompanyManagement from a data file\n" +
						 "?\t\tDisplay Help\n");
	}
}