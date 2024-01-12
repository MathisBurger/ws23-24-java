public class MoreSmallThanLarge {

    static boolean moreSmallThanLarge(String s) {
        int counterLower = 0;
        int counterUpper = 0;
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                counterUpper++;
            }
            if ('a' <= c && c <= 'z') {
                counterLower++;
            }
        }
        return counterLower > counterUpper;
    }

    public static void main(String... args) {
        System.out.println(moreSmallThanLarge("aaaaSSSS"));
    }
}
