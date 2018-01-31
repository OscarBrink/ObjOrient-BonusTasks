package bonustask6;

import javafx.util.Pair;

/**
 * Program calculates the long and short sides of a A-paper.
 *
 * @version 1.0 2018-01-31
 * @author Oscar Brink
 */
public class An {

    public static void main(String[] args) {
        System.out.println(
                "a0:" + a(0) + "\n"
                + "a1:" + a(1) + "\n"
                + "a2:" + a(2) + "\n"
                + "a3:" + a(3) + "\n"
                + "a4:" + a(4) + "\n"
                + "a5:" + a(5) + "\n"
                + "a6:" + a(6)
        );
    }

    /**
     * Gets the sides of an A-paper.
     *
     * @param n int that specifies the size of the A-paper.
     * @return Returns Pair with the long and short sides.
     */
    public static Pair<Integer, Integer> a(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        return new Pair<Integer, Integer>(l(n), k(n));
    }

    /**
     * Calculates the long side of an A-paper in millimeters.
     *
     * @param n int that specifies the size of the A-paper.
     * @return Returns the long side of the A-paper of size n.
     */
    private static int l(int n) {
        /*
        You get the long side of an A-paper simply by getting the short
        side of the next bigger A-paper.
        The long side of the biggest A-paper (A0) is 1189 millimeters.
        */
        if (n == 0) {
            return 1189;
        }
        return k(n-1);
    }

    /**
     * Calculates the short side of an A-paper in millimeters.
     *
     * @param n int that specifies the size of the A-paper.
     * @return Returns the short side of the A-paper of size n.
     */
    private static int k(int n) {
        /*
        You get the short side of an A-paper by cutting the next bigger
        A-paper's long side in two.
        The short side of the biggest A-paper (A0) is 841 millimeters.
        */
        if (n == 0) {
            return 841;
        }
        return l(n-1) / 2;
    }

}
