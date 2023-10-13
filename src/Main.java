import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, BaseTask> tasks = new HashMap<>();

        // Adds all tasks that can be executed
        tasks.put("Hello World", new HelloWorld());

        System.out.println("Choose your task:");
        tasks.keySet().forEach(System.out::println);
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        String str = sc.nextLine();
        sc.close();
        tasks.get(str).run();
    }
}