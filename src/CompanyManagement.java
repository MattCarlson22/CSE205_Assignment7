//Assignment #: ASU Fall 2022 #7
//Name: Matt Carlson
//StudentID: 1224917226
//Lecture: T - Th 10:30 - 11:45
//Description: Class with methods to check a list of companies if they exist or sort the list.

//import all necessary classes and interfaces
//----

// DONE

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyManagement implements Serializable
{
	ArrayList<Company> companyList;

	public CompanyManagement() {
		companyList = new ArrayList<>();
	}

	public int companyExists(String companyName, String companyAddress) { // if a company matches companyName and companyAddress, the index is returned
		for (int i = 0; i < companyList.size(); i++) {
			if (companyList.get(i).getCompanyName().equals(companyName) &&
				companyList.get(i).getAddress().toString().equals(companyAddress)) {
				return i;
			}
		}
		return -1; // -1 is returned if no company is found in list.
	}

	public int addressExists(String street, String city, String state) {
		String cStreet, cCity, cState;
		for (int i = 0; i < companyList.size(); i++) {
			cStreet = companyList.get(i).getAddress().getStreet();
			cCity = companyList.get(i).getAddress().getCity();
			cState = companyList.get(i).getAddress().getState();
			if (street.equals(cStreet) && city.equals(cCity) && state.equals(cState)) { // returns index if the city, street, and state all match
				return i;
			}
		}
		return -1;
	}

	public boolean addCompany(String companyName, int numOfEmployees, String nameOfCEO, String street, String city, String state) {
		if (companyExists(companyName, new Address(street, city, state).toString()) != -1) { // checking if company exists
			return false;
		}
		companyList.add(new Company(companyName, nameOfCEO, numOfEmployees, street, city, state));
		return true; // if successful, true is returned
	}

	public boolean removeCompany(String companyName, String companyAddress) {
		if (companyExists(companyName, companyAddress) == -1) { // will return -1 if company is not in list
			return false;
		}
		companyList.remove(companyExists(companyName, companyAddress));
		return true;
	}

	public void sortByCompanyName() {
		Sorts.sort(companyList, new CompanyNameComparator());
	}

	public void sortByEmployeeNumbers() {
		Sorts.sort(companyList, new EmployeeNumberComparator());
	}

	public void sortByCompanyAddress() {
		Sorts.sort(companyList, new CompanyAddressComparator());
	}

	public String listCompanies() {
		String out = "";

		if (companyList.size() == 0) { // checking if list is empty
			return "\nNo company\n\n";
		}

		for (Company c : companyList) {
			out += c.toString();
		}
		return "\n" + out + "\n";
	}

	public void closeCompanyManagement() {
		companyList = new ArrayList<>(); // replaces the companyList ArrayList with a new one
	}
}