import java.util.Scanner;

public class Ln2Iter {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int c = -1;
        while (c != 0) {
            System.out.print("Bitte n > 0 eingeben (0 zum Beenden): ");
            c = sc.nextInt();
            if (c == 0) {
                return;
            }
            double result = 0.0;
            for (int i=1; i<=c; i++) {
                if ((i % 2) == 1) {
                    result += ((double) 1 /i);
                    continue;
                }
                result -= ((double) 1 /i);
            }
            System.out.println("ln(2) ist naeherungsweise " + result);
        }
    }
}
