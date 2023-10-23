import static isbn10.Isbn10StatusCodes.*;
import java.util.Scanner;
class Isbn10 {
    public static void main(String [] args) {
        System.out.print("ISBN eingeben: ");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        scanner.close();
        int status = validityIsbn10(isbn);
        if (status == OK) System.out.println("OK");
        if (status == FALSCHES_ZEICHEN) System.out.println("Fehler: Keine Ziffer");
        if (status == FALSCHE_PRUEFSUMME) System.out.println("Fehler: Falsche Pruefsumme");
        if (status == FALSCHE_LAENGE) System.out.println("Fehler: Falsche Laenge");
    }

    /**
     * Validates the ISBN
     * @param isbn The initial isbn
     * @return The error code
     */
    public static int validityIsbn10(String isbn) {
        String formattedIsbn = removeSpacesFromIsbn(isbn);
        int badCharIndex = badCharIndex(formattedIsbn);
        boolean isCheckSumValid = isCheckSumValid(formattedIsbn);
        boolean isSizeValid = isSizeValid(formattedIsbn);
        return findErrorCode(formattedIsbn, badCharIndex, isCheckSumValid, isSizeValid);
    }

    /**
     * Finds the error code from the validation results
     * @param isbn The isbn
     * @param badCharIndex If there is a bad char
     * @param isCheckSumValid If the checksum is valid
     * @param isSizeValid If the size is valid
     * @return The resulting error code
     */
    public static int findErrorCode(String isbn, int badCharIndex, boolean isCheckSumValid, boolean isSizeValid) {
        int errorCount = 0;
        if (badCharIndex != -1) errorCount++;
        if (!isCheckSumValid)errorCount++;
        if (!isSizeValid) errorCount++;

        if (errorCount > 1) {
            if (badCharIndex != -1 && badCharIndex < (isbn.length()-1)) {
                return FALSCHES_ZEICHEN;
            }
            if (!isSizeValid) return FALSCHE_LAENGE;
        }
        if (badCharIndex != -1) return FALSCHES_ZEICHEN;
        if (!isCheckSumValid) return FALSCHE_PRUEFSUMME;
        if (!isSizeValid) return FALSCHE_LAENGE;
        return OK;
    }

    /**
     * Gets the index of a bad char
     * @param isbn The isbn
     * @return The index of the bad char. If not exists its -1
     */
    public static int badCharIndex(String isbn) {
        String goodChars = "1234567890-X";
        char[] split = isbn.toCharArray();
        for (int i=0; i<split.length; i++) {
            if (goodChars.indexOf(split[i]) < 0) {
                return i;
            }
            if (split[i] == 'X' && i != (split.length-1)) {
                return i;
            }
            //if (split[i] == '-' && i != 2 && i != 8) {
            //    return i;
            //}
        }
        return -1;
    }

    /**
     * Checks if the check sum is valid
     * @param isbn The isbn
     * @return If the checksum is valid
     */
    public static boolean isCheckSumValid(String isbn) {
        char[] chars = isbn.toCharArray();
        int lastNumber = chars[chars.length-1] - '0';
        if (chars[chars.length-1] == 'X') {
            lastNumber = 10;
        }
        int sum = 0;
        for (int i=0; i<(chars.length-1); i++) {
            int num = chars[i] - '0';
            int multi = i+1;
            sum += (num*multi);
        }
        return sum % 11 == lastNumber;
    }

    /**
     * Checks if the size is valid
     * @param isbn The ISBN
     * @return If the size is valid
     */
    public static boolean isSizeValid(String isbn) {
        return isbn.toCharArray().length == 10;
    }

    public static String removeSpacesFromIsbn(String isbn) {
        return isbn.replaceAll("-", "");
    }
}
