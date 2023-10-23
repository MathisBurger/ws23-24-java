import java.util.Scanner;

public class Zylinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bitte Radius eingeben: ");
        double radius = input.nextDouble();
        System.out.print("Bitte Hoehe eingeben: ");
        double height = input.nextDouble();
        System.out.println("Oberflaeche: " + Zylinder.calcSurface(radius, height));
        System.out.println("Volumen: " + Zylinder.calcVolume(radius, height));
    }

    private static double calcSurface(double radius, double height)
    {
        double baseSurface = Math.PI * radius * radius;
        double bodySurface = 2*Math.PI*radius*height;
        return 2*baseSurface + bodySurface;
    }

    private static double calcVolume(double radius, double height)
    {
        return Math.PI * radius*radius * height;
    }
}
