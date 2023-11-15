import java.util.Scanner;

public class MultiTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input max row index:");
        int rows = sc.nextInt();
        System.out.println("Input max col index:");
        int cols = sc.nextInt();
        System.out.println("Input filter:");
        int filter = sc.nextInt();
        sc.close();
        int maxIndexSpace = MultiTable.getNumOfMaxChars(rows);
        int maxLineSpace = MultiTable.getNumOfMaxChars(rows * cols)+1;

        System.out.printf("%" + maxIndexSpace +  "s |", "");
        for (int i=1; i<=cols; i++) {
            System.out.printf("%" + maxLineSpace + "d", i);
        }
        System.out.print("\n");

        // Maybe error here
        for (int i=1; i<=(cols+1)*maxLineSpace; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        for (int i=1; i<=rows; i++) {
            System.out.printf("%" + maxIndexSpace + "d |", i);
            for (int j=1; j<=cols; j++) {
                int result = i*j;
                if (result % filter == 0) {
                    System.out.printf("%"+ maxLineSpace + "s", "");
                    continue;
                }
                System.out.printf("%" + maxLineSpace + "d", result);
            }
            System.out.print("\n");
        }
    }

    private static int getNumOfMaxChars(int num) {
        return ("" + num).length();
    }
}
