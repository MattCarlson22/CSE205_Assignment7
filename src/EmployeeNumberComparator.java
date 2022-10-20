//Assignment #: ASU Fall 2022 #7
//Name: Matt Carlson
//StudentID: 1224917226
//Lecture: T - Th 10:30 - 11:45
//Description: This class allows for Companies to be compared by their number of employees to be sorted.

// DONE

import java.util.Comparator;

public class EmployeeNumberComparator implements Comparator<Company> {

    @Override
    public int compare(Company o1, Company o2) {
        return o1.getNumOfEmployees() - o2.getNumOfEmployees();
    }
}
