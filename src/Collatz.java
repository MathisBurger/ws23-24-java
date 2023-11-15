public class Collatz {

    public static void main(String[] args) {
        for (int i=9999; i!=0; i--) {
            int value = i;
            while (value != 1) {
                if (value % 2 == 0) {
                    value /= 2;
                } else {
                    value = 3*value+1;
                }
            }
        }
    }
}
