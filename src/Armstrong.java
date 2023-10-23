import java.util.Scanner;

public class Armstrong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte geben Sie die untere Grenze an: ");
        int lowerBorder = sc.nextInt();
        System.out.print("Bitte geben Sie die obere Grenze an: ");
        int upperBorder = sc.nextInt();
        for (int i=lowerBorder; i<=upperBorder; i++) {
            if (isArmstrong(i)) {
                System.out.println(i + " ist eine Armstrongzahl!");
            }
        }
    }

    public static boolean isArmstrong(int number) {
        return number == useArmstrongPrinciple(number);
    }

    public static int useArmstrongPrinciple(int number) {
        int digits = countDigits(number);
        int internalNumber = number;
        int result = 0;
        while (internalNumber != 0) {
            result += internalPow(internalNumber % 10, digits);
            internalNumber /= 10;
        }
        return result;
    }

    public static int internalPow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int result = base;
        for (int i=1; i<exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int countDigits(int number) {
        int digitCount = 0;
        float internalNumber = number;
        while (internalNumber/10 > 1) {
            internalNumber = internalNumber/10;
            digitCount++;
        }
        return digitCount+1;
    }
}
