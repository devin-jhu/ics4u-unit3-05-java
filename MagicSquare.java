/*
* The magic square program.
*
* @author  Devin Jhu
* @version 1.0
* @since   2022-11-18
*/

import java.util.ArrayList;

/**
 * The MagicSquare class.
 */
final class MagicSquare {
    /**
     * The lower right index.
     */
    public static final int EIGHT = 8;

    /**
     * The middle right index.
     */
    public static final int FIVE = 5;

    /**
     * The center index.
     */
    public static final int FOUR = 4;

    /**
     * The maximum number for magicNumbers.
     */
    public static final int MAGICNUMBER = 15;

    /**
     * The maximum number for magicNumbers.
     */
    public static final int NINE = 9;

    /**
     * The lower center index.
     */
    public static final int SEVEN = 7;

    /**
     * The lower left index.
     */
    public static final int SIX = 6;

    /**
     * The middle left index.
     */
    public static final int THREE = 3;

    /**
     * The MagicSquare.
     *
     * <p>
     * Prevent instantiation.
     * </p>
     *
     * @throws IllegalStateException - error
     */
    private MagicSquare() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The magicSquare function.
     *
     * @param numbers - the list of numbers from 1 to 9.
     * @param square - the current square being filled.
     * @param index - the current index.
     */
    public static void magicSquare(final int[] numbers,
        final int[] square, final int index) {
        // Checks if the square is fille and magic.
        if (index == NINE && isMagic(square)) {
            printMagicSquare(square);
        } else {
            // Adds a number to the square if it's not full.
            if (index != NINE) {
                // Loops through each number from 1 to 9.
                for (int counter = 0; counter < NINE; counter++) {
                    square[index] = numbers[counter];
                    magicSquare(numbers, square, index + 1);
                }
            }
        }
    }

    /**
     * The findDuplicates function.
     *
     * @param array - the array to find duplicates in.
     * @return ArrayList
     */
    public static ArrayList<Integer> findDuplicates(int[] array) {
        final ArrayList<Integer> duplicates = new ArrayList<Integer>();

        for (int counter = 0; counter < array.length; counter++) {
            for (int counter1 = 1; counter1 < array.length; counter1++) {
                if (array[counter] == array[counter1] && counter != counter1) {
                    duplicates.add(array[counter1]);
                    break;
                }
            }
        }
        return duplicates;
    }

    /**
     * The isMagic function.
     *
     * @param theSquare - the square array to check if it's magic.
     * @return boolean
     */
    public static boolean isMagic(final int[] theSquare) {
        // returns true or false for whether or not array is a magic square
        final int row1 = theSquare[0] + theSquare[1] + theSquare[2];
        final int row2 = theSquare[THREE] + theSquare[FOUR] + theSquare[FIVE];
        final int row3 = theSquare[SIX] + theSquare[SEVEN] + theSquare[EIGHT];

        final boolean rows = row1 == MAGICNUMBER
            && row2 == MAGICNUMBER && row3 == MAGICNUMBER;

        final int col1 = theSquare[0] + theSquare[THREE] + theSquare[SIX];
        final int col2 = theSquare[1] + theSquare[FOUR] + theSquare[SEVEN];
        final int col3 = theSquare[2] + theSquare[FIVE] + theSquare[EIGHT];
        final int diag1 = theSquare[0] + theSquare[FOUR] + theSquare[EIGHT];
        final int diag2 = theSquare[2] + theSquare[FOUR] + theSquare[SIX];

        return rows && col1 == MAGICNUMBER && col2 == MAGICNUMBER
                && col3 == MAGICNUMBER && diag1 == MAGICNUMBER
		&& diag2 == MAGICNUMBER
		&& findDuplicates(theSquare).size() == 0;
    }

    /**
     * The printMagicSquare function.
     *
     * @param outputSquare - the square to be formatted and printed.
     */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        final String space = " ";

        System.out.println('\n');
        for (int counter = 0; counter < outputSquare.length; counter++) {
            if (counter == THREE || counter == SIX) {
                System.out.println();
                System.out.print(outputSquare[counter] + space);
            } else {
                System.out.print(outputSquare[counter] + space);
            }
        }
    }

    /**
     * The Main.
     *
     * @param args - No args.
     */
    public static void main(final String[] args) {
        // main stub, get user input here
        final int[] numbers = {
	1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("every 3x3 magic square:");
        magicSquare(numbers, extraArray, 0);

        System.out.println("\nDone.");
    }
}
