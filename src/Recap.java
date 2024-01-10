public class Recap {

    public static void main(String[] args) {
        System.out.println(vocals("ziffern"));
    }

    static int numberFromChars(char... numbers) {
        int sum = 0;
        for (char number : numbers) {
            sum *= 10;
            sum += number - '0';
        }
        return sum;
    }

    static int vocals(String word) {
        if (word.isEmpty()) {
            return 0;
        }
        word = word.toLowerCase();
        char c = word.charAt(0);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1 + vocals(word.substring(1));
        }
        return vocals(word.substring(1));

    }

    public static double average(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }
}
