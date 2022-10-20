//Assignment #: ASU Fall 2022 #7
//Name: Matt Carlson
//StudentID: 1224917226
//Lecture: T - Th 10:30 - 11:45
//Description: This class allows for Companies to be compared by their address to be sorted.

// DONE

import java.util.Comparator;

public class CompanyAddressComparator implements Comparator<Company>
{
	@Override
	public int compare(Company first, Company second) {
		int stateCompare = first.getAddress().getState().compareTo(second.getAddress().getState()); // compares states
		if (stateCompare == 0) {
			int cityCompare = first.getAddress().getCity().compareTo(second.getAddress().getCity()); // compares cities
			if (cityCompare == 0) {
				return first.getAddress().getStreet().compareTo(second.getAddress().getStreet()); // returns compared address
			} else {
				return cityCompare;
			}
		}
		return stateCompare;
	}
	//First we compare the state info., if they are same, we then compare their city info.
	//If the two company addresses have the same state AND city info. then we should compare
	//their street info. The companies should be listed in the alphabetical order of their addresses!

}
