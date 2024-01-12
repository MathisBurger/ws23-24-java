public class AB {

    static boolean ab(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.charAt(0) != 'a') {
            return false;
        }
        if (s.charAt(s.length()-1) != 'b') {
            return false;
        }
        return ab(s.substring(1,s.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(ab("aab"));
        System.out.println(ab("aabb"));
        System.out.println(ab("aaaba"));
    }
}
