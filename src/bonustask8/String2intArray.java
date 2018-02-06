package bonustask8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class takes in a string consisting of integers delimited
 * by commas (,) and stores them in an array. Spaces are ignored.
 *
 * @version 1. 2017-02-06
 * @author Oscar Brink
 */
public class String2intArray {

    public static int[] str2ia(String s) {
        // Removes all spaces.
        s = s.replace(" ", "");

        Scanner scanner = new Scanner(s);
        scanner.useDelimiter(" *, *");

        /*
        The ints are first stored in an ArrayList before converting to
        an int array.
         */
        ArrayList<Integer> tempArr = new ArrayList<>();

        while (scanner.hasNext()) {
            /*
            If the scanner fails to interpret the next token as an int
            it will throw an InputMismatchException. When this happens a
            IllegalArgumentException is thrown.
             */
            try {
                tempArr.add(scanner.nextInt());
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("String invalid.");
            }
        }

        int[] returnValue = new int[tempArr.size()];

        // Loop iterates through tempArr and adds all elements to an int array.
        for (int i = 0; i < tempArr.size(); i++) {
            returnValue[i] = tempArr.get(i);
        }
        
        return returnValue;
    }

}
