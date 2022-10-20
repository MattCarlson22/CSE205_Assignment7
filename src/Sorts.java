//Assignment #: ASU Fall 2022 #7
//Name: Matt Carlson
//StudentID: 1224917226
//Lecture: T - Th 10:30 - 11:45
//Description: This class contains a single static sort method that will sort a company list given a specific comparator.

// DONE

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
    public static void sort(ArrayList<Company> companyList, Comparator<Company> xComparator) {
        companyList.sort(xComparator); // java.util.ArrayList already has a sort method built in, so I used that
    }
}
