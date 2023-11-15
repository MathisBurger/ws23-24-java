import java.util.Scanner;

public class PrimeFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();
        PrimeFactor.getPrimeFactors(number);
    }

    private static void getPrimeFactors(int initNum) {
        int div = 2;
        int number = initNum;
        String factorDivision = "";
        while (div*div <= number) {
            if(number % div == 0) {
                number /= div;
                if (factorDivision.isEmpty()) {
                    factorDivision += div;
                } else {
                    factorDivision = String.format("%s * %d", factorDivision, div);
                }
            }
            else {
                div++;
            }
        }
        System.out.printf("%s = %d", factorDivision, initNum);
    }
}
