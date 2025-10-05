package Strings;

import java.util.*;

public class DistinctYearCounter {
    public static void main(String[] args) {
        // Test case 1
        String document1 = "UN was established on 24-10-1945. India got freedom on 15-08-1947.";
        System.out.println("Test 1 Expected: 2 | Got: " + countDistinctYears(document1));

        // Test case 2 - repeated years
        String document2 = "Event1: 01-01-2000, Event2: 02-02-2000, Event3: 03-03-2001";
        System.out.println("Test 2 Expected: 2 | Got: " + countDistinctYears(document2));

        // Test case 3 - no years
        String document3 = "No dates here";
        System.out.println("Test 3 Expected: 0 | Got: " + countDistinctYears(document3));

        // Test case 4 - adjacent dashes and digits but not valid dates
        String document4 = "Random text 1234-5678 not a date 99-99-9999";
        System.out.println("Test 4 Expected: 1 (9999) | Got: " + countDistinctYears(document4));

        // Test case 5 - partially valid dates
        String document5 = "Dates are 31-12-1999 and 01-01-2000 and 31-12-1999 again";
        System.out.println("Test 5 Expected: 2 | Got: " + countDistinctYears(document5));
    }

    static int countDistinctYears(String doc) {
        Set<String> set = new HashSet();
        String str = "";
        int n = doc.length();
        for(int i = 0;i < n;i++){
            char a = doc.charAt(i);
            if(Character.isDigit(a)){
                str += a;
            }

            if(a == '-'){
                str = "";
            }

            if(str.length() == 4){
                set.add(str);
                str = "";
            }
        }

        return set.size();
    }
}

