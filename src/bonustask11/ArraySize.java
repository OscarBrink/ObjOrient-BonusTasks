package bonustask11;

/**
 * Class checks the amount of ints in a 3D int array.
 *
 * @author  Oscar Brink
 *          2018-02-19
 */
public class ArraySize {

    public static void main(String[] args) {
        int[][][][] b = { // b är en 4D-array med de 10 testfallen
                        null,
                        { { {} } },
                        { { {} }, { {} } },
                        { null, null },
                        { { null }, { null }, { null } },
                        { { { 1, 2, 3 } } },
                        { { { 1, 2, 3 }, { 1, 2, 3 } } },
                        { { { 1, 2, 3 }, {}, { 1, 2, 3 }, null } },
                        { { { 1, 2, 3 }
                        }, {}, { { 1, 2, 3 } }, null },
                        { { { 1 }, {}, { 2 }, { 3, 4 } }, {}, null,
                        { { 5, 6 }, {}, { 7 } } }
        };
        for (int i = 0; i < b.length; i++) {
            System.out.println("" + i + " : " + arraySize(b[i]));
        }
    }

    /**
     * Checks how many integers the 3D-array contains.
     *
     * @param a 3D int-array to be checked.
     * @return int Amount of ints in array.
     */
    public static int arraySize(int[][][] a) {
        if (a == null) {
            return 0;
        }
        return dimension3(a);
    }

    /*
    Method checks the 3D-array by calling method below that checks all
    2D-arrays in the array.
    Returns amount of ints in the 3D-array.
     */
    private static int dimension3(int[][][] a) {
        int returnValue = 0;

            for (int i = 0; i < a.length; i++) {
                try {
                    returnValue += dimension2(a[i]);
                } catch(NullPointerException e){
                    continue; // If null, move on to next subarray.
                }
        }
        return returnValue;
    }

    /*
    Method checks a 2D-array by calling method below that checks all
    1D-arrays in the array.
    Returns amount of ints in the 2D-array.

    Methods above will have checked if the array is null.
     */
    private static int dimension2(int[][] a) {
        int returnValue = 0;
        for (int i = 0; i < a.length; i++) {
            try {
                returnValue += dimension1(a[i]);
            } catch (NullPointerException e) {
                continue; // If null, move on to next subarray.
            }
        }

        return returnValue;
    }

    /*
    Method returns the length of a 1D int array.
    Methods above will have checked if the array is null.
     */
    private static int dimension1(int[] a) {
        return a.length; // int array can not contain null.
    }
}
