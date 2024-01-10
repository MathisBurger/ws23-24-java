import java.util.Scanner;

public class CharCategory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextLine().charAt(0);
        if (65 <= c && c <= 90) {
            System.out.println("Großbuchstabe");
        }
        if (97 <= c && c <= 122) {
            System.out.println("Kleinbuchstabe");
        }

    }
}
